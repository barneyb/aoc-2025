import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

import static java.util.function.Predicate.not;

public class Factory {

    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        int part_a = 0;
        float part_b = 0;
        try (var in = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = in.readLine()) != null) {
                Machine m = new Parse(line).machine();
                System.out.println(m);
                int a = m.do_lights();
                System.out.println("  lights: " + a);
                part_a += a;

                float[][] A = m.augmented_matrix();
                System.out.println("  matrix:");
                System.out.println(matrix_to_string(A));
                eliminate(A);
                System.out.println(matrix_to_string(A));
                back_substitute(A);
                System.out.println(matrix_to_string(A));
                float b = do_free_variables(A);
                System.out.println("  jolts : " + b);
                part_b += b;
            }
        }
        long end = System.nanoTime();
        System.out.println("Part A: " + part_a);
        System.out.println("Part B: " + part_b);
        System.out.printf("%d ms%n", (end - start) / 1_000_000);
    }

    private record Machine(List<Integer> lights,
                           List<List<Integer>> buttons,
                           List<Integer> joltages) {

        public int do_lights() {
            record St(List<Integer> lights, int steps) {}
            Queue<St> q = new ArrayDeque<>();
            Set<List<Integer>> visited = new HashSet<>();
            q.add(new St(lights_off(), 0));
            while (!q.isEmpty()) {
                St st = q.remove();
                if (!visited.add(st.lights)) continue;
                if (lights.equals(st.lights)) return st.steps;
                buttons.stream()
                        .map(b -> xor(st.lights, b))
                        .filter(not(visited::contains))
                        .forEach(b -> q.add(new St(b, st.steps + 1)));
            }
            throw new NoSuchElementException("Didn't find a way to do the lights?!");
        }

        public float[][] augmented_matrix() {
            float[][] A = new float[joltages.size()][];
            for (int r = 0; r < A.length; r++) {
                float[] row = new float[buttons.size() + 1];
                for (int c = buttons.size() - 1; c >= 0; c--) {
                    row[c] = buttons.get(c).get(r);
                }
                row[row.length - 1] = joltages.get(r);
                A[r] = row;
            }
            return A;
        }

        private List<Integer> lights_off() {
            return lights.stream().map(n -> 0).toList();
        }

    }

    private static class Parse {

        // [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
        final String line;
        int i = 0;

        private Parse(String line) {
            this.line = line;
        }

        Machine machine() {
            List<Integer> ls = lights();
            return new Machine(ls,
                               buttons(ls.size()),
                               joltages());
        }

        List<Integer> lights() {
            consume('[');
            List<Integer> lights = new ArrayList<>();
            while (peek() != ']') {
                lights.add(read() == '#' ? 1 : 0);
            }
            consume(']');
            consume(' ');
            return lights;
        }

        List<List<Integer>> buttons(int len) {
            List<List<Integer>> btns = new ArrayList<>();
            while (peek() == '(') btns.add(button(len));
            return btns;
        }

        private List<Integer> button(int len) {
            List<Integer> b = new ArrayList<>(len);
            consume('(');
            while (Character.isDigit(peek())) {
                int v = num();
                while (b.size() < v) b.add(0);
                b.add(1);
                if (peek() == ',') consume(',');
            }
            consume(')');
            consume(' ');
            while (b.size() < len) b.add(0);
            return b;
        }

        List<Integer> joltages() {
            List<Integer> jlts = new ArrayList<>();
            consume('{');
            while (Character.isDigit(peek())) {
                jlts.add(num());
                if (peek() == ',') consume(',');
            }
            consume('}');
            return jlts;
        }

        private int num() {
            int n = 0;
            while (Character.isDigit(peek())) {
                n *= 10;
                n += Character.digit(read(), 10);
            }
            return n;
        }

        private char peek() {
            return line.charAt(i);
        }

        private char read() {
            return line.charAt(i++);
        }

        private void consume(char c) {
            if (read() != c) throw new RuntimeException("Didn't get a " + c);
        }

    }

    private static List<Integer> xor(List<Integer> a, List<Integer> b) {
        assert a.size() == b.size();
        Iterator<Integer> itr = b.iterator();
        List<Integer> result = a.stream()
                .map(v -> (v + itr.next()) % 2)
                .toList();
        assert !itr.hasNext();
        return result;
    }

    private static String matrix_to_string(float[][] A) {
        int m = A[0].length;
        var sb = new StringBuilder();
        for (var row : A) {
            for (int c = 0; c < m - 1; c++)
                sb.append("%5.2f ".formatted(row[c]));
            sb.append("| %7.2f ".formatted(row[m - 1]))
                    .append('\n');
        }
        return sb.toString()
                .replace(".00 ", "    ")
                .replace(" 0 ", " . ");
    }

    private static void eliminate(float[][] A) {
        final int m = A.length;
        final int n = A[0].length;
        int r = 0; // pivot row
        int c = 0; // pivot col
        while (r < m && c < n) {
            int i_max = max_in_col(A, c, r, m);
            if (A[i_max][c] == 0) {
//                System.out.println("Skip column "+c);
                c++; // next column...
            } else {
                // move the row into position
                swap(A, r, i_max);
//                System.out.printf("swapped rows %d and %d for pivot at %d\n", r, i_max, c);
//                System.out.println(matrix_to_string(A));
                // eliminate down
                for (int i = r + 1; i < m; i++) {
                    float factor = A[i][c] / A[r][c];
                    A[i][c] = 0;
                    for (int j = c + 1; j < n; j++)
                        A[i][j] = A[i][j] - A[r][j] * factor;
                }
                r++;
                c++;
//                System.out.println(matrix_to_string(A));
            }
        }
    }

    private static void back_substitute(float[][] A) {
        final int m = A.length;
        final int n = A[0].length;
        for (int r = 0; r < m; r++) {
            // find first non-zero
            for (int c = r; c < n - 1; c++) {
                if (A[r][c] == 0) continue;
                // substitute up
                for (int i = r - 1; i >= 0; i--) {
                    float factor = A[i][c] / A[r][c];
                    for (int j = c; j < n; j++)
                        A[i][j] = A[i][j] - A[r][j] * factor;
                }
                // reduce across
                if (A[r][c] != 1)
                    for (int j = n - 1; j >= c; j--)
                        A[r][j] = A[r][j] / A[r][c];
                break;
            }
        }
    }

    private static float do_free_variables(float[][] A) {
//        System.out.println("do free variables:");
//        System.out.println(matrix_to_string(A));
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m && i < n - 1; i++) {
            if (A[i][i] != 1) {
                return find_best_value(A, i);
            }
        }
        if (m < n - 1) {
            return find_best_value(A, m);
        }
        // nothing free!
        float p = 0;
        for (var row : A) {
            if (row[n - 1] < 0) return Float.MAX_VALUE;
            p += row[n - 1];
        }
        return p;
    }

    private static float find_best_value(float[][] A, int c) {
        int m = A.length;
        int n = A[0].length;
        float min = Float.MAX_VALUE;
        float max = get_range(A, c);
        if (max > 1000) {
            throw new RuntimeException("got max of " + max + " (" + ((int) max) + ")for col " + c);
        }
        for (int i = (int) max; i >= 0; i--) {
            float[][] B = add_row(A);
            B[m][c] = 1;
            B[m][n - 1] = i;
//            System.out.printf("added col %d => %d%n", c, i);
//            System.out.println(matrix_to_string(B));
            eliminate(B);
            back_substitute(B);
            try {
                float p = do_free_variables(B);
                if (p < min) {
                    System.out.println("new best: " + p);
                    System.out.println(matrix_to_string(B));
                    min = p;
                }
            } catch (Inconsistent ignored) {
            }
        }
        return min;
    }

    static boolean logged;

    private static float get_range(float[][] A, int c) {
        int m = A.length;
        int n = A[0].length;
        float range = Float.MAX_VALUE;
        for (int r = Math.min(m - 1, c); r >= 0; r--) {
            if (A[r][c] != 0) {
                float factor = A[r][n - 1] / A[r][c];
            if (!logged)    System.out.println(factor);
                if (factor >= 0 && factor < range) range = factor;
            }
        }
        if (range == Float.MAX_VALUE) {
            if (!logged) {
                System.out.println("inconsistent");
                System.out.println(matrix_to_string(A));
                logged = true;
            }
            throw new Inconsistent();
        }
        return range;
    }

    private static class Inconsistent extends RuntimeException {}

    /**
     * which row, from r to m, has the largest absolute value in column c
     */
    private static int max_in_col(float[][] A, int c, int r, int m) {
        float max = -1;
        int i_max = -1;
        for (int i = r; i < m; i++) {
            float v = Math.abs(A[i][c]);
            if (v > max) {
                max = v;
                i_max = i;
            }
        }
        return i_max;
    }

    private static void swap(float[][] A, int r1, int r2) {
        float[] t = A[r1];
        A[r1] = A[r2];
        A[r2] = t;
    }

    private static float[][] add_row(float[][] A) {
        int m = A.length;
        int n = A[0].length;
        float[][] B = new float[m + 1][];
        for (int r = 0; r < m; r++) B[r] = Arrays.copyOf(A[r], n);
        B[m] = new float[n];
        return B;
    }
}
