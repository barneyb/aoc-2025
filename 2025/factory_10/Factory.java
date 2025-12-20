import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
        int presses = 0;
        try (var in = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = in.readLine()) != null) {
                Machine m = new Parse(line).machine();
                System.out.println(m);
                int p = m.do_lights();
                System.out.println("  lights: " + p);
                presses += p;
            }
        }
        long end = System.nanoTime();
        System.out.printf("Part A (%d ms): %d %n", (end - start) / 1_000_000, presses);
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

}
