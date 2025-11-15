# aoc-2025

Advent of Code 2025 solvers, with some solvers from earlier years as warmup. If you don't know what [Advent of Code](https://adventofcode.com/) is, you should go see! It's both lovely, and will help make sense of this repo. :)

https://github.com/barneyb/aoc2017 has an index of all years' repositories.

## Running

The solvers are written in [Johann](https://barneyb.github.io/johann/), one per day. This carries the requirement of `arm64-apple-darwin` (aka Apple Silicon, running macOS), with the command-line dev tools installed.

`make` manages building and acquisition of inputs, via [advent-of-code-data](https://github.com/wimglenn/advent-of-code-data). This carries the requirement of Python 3 installed as well.

Two assumptions must be met for the various `Makefile` to work correctly:

1. a `JOHANN_HOME` environment variable, pointed at a current Johann [installation w/ source](https://barneyb.github.io/johann/#the-short-version), and
1. the `advent-of-code-data` package is configured w/ your token.

You can confirm you're set up correctly with these commands (your output will differ):

```
% $JOHANN_HOME/bin/jnc -v
jnc 0.20251026-6626382

% aocd 2015 1
()(()((()((((()(((((((() # and ~7,000 more...
```

With that squared away, solve [Not Quite Lisp](https://adventofcode.com/2015/day/1) (again, your output will differ):

```
% cd 2015/not_quite_lisp_01
% make
~/projects/johann/bin/jnc < not_quite_lisp.jn > target/out/not_quite_lisp.s
gcc -c target/out/not_quite_lisp.s -o target/lib/not_quite_lisp.o
gcc target/lib/not_quite_lisp.o ~/projects/johann/lib/jstdlib.o -o target/bin/not_quite_lisp
aocd 2015 1 > input.txt
target/bin/not_quite_lisp < input.txt
Final floor  : 321
First descent: 1234
```
