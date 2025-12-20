import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
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

    private record Machine(int lights,
                           List<Integer> buttons,
                           List<Integer> joltages) {

        public int do_lights() {
            record St(int lights, int steps) {}
            Queue<St> q = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            q.add(new St(0, 0));
            while (!q.isEmpty()) {
                St st = q.remove();
                if (!visited.add(st.lights)) continue;
                if (st.lights == lights) return st.steps;
                buttons.stream()
                        .map(b -> st.lights ^ b)
                        .filter(not(visited::contains))
                        .forEach(b -> q.add(new St(b, st.steps + 1)));
            }
            throw new NoSuchElementException("Didn't find a way to do the lights?!");
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
            return new Machine(lights(),
                               buttons(),
                               joltages());
        }

        int lights() {
            int lights = 0;
            consume('[');
            Deque<Character> stack = new ArrayDeque<>();
            while (peek() != ']') {
                stack.push(read());
            }
            while (!stack.isEmpty()) {
                lights <<= 1;
                if (stack.pop() == '#') lights++;
            }
            consume(']');
            consume(' ');
            return lights;
        }

        List<Integer> buttons() {
            List<Integer> btns = new ArrayList<>();
            while (peek() == '(') btns.add(button());
            return btns;
        }

        private int button() {
            int b = 0;
            consume('(');
            while (Character.isDigit(peek())) {
                int v = num();
                b |= 1 << v;
                if (peek() == ',') consume(',');
            }
            consume(')');
            consume(' ');
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

}
