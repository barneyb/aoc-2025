import sys

from aocd.models import Puzzle
from aocd.post import submit

[_, year, day, part, val] = sys.argv

BAD = ""
GOOD = ""
END = ""
if sys.stdout.isatty():
    NEGATIVE = "\033[7m"
    BAD = f"\033[0;31m{NEGATIVE}"
    GOOD = f"\033[0;32m{NEGATIVE}"
    END = "\033[0m"

# accept part in uppercase
part = part.lower()
if part != "a" and part != "b":
    raise TypeError(f"Unknown '{part}' part")

puzzle = Puzzle(year=int(year), day=int(day))
if not getattr(puzzle, f"answered_{part}"):
    # this is a little silly, but Puzzle itself doesn't offer a reopen flag
    submit(val, part=part, day=puzzle.day, year=puzzle.year, reopen=False)
    if getattr(puzzle, f"answered_{part}"):
        exit(0)  # woo!
    else:
        exit(1)  # bummer

answer = getattr(puzzle, f"answer_{part}")
if val == answer:
    print(f"{GOOD}'{val}' is correct!{END}")
    exit(0)
if val.__contains__("\n"):
    print(f"{BAD}Expected '{answer}', actual:\n{val}{END}")
else:
    print(f"{BAD}Expected '{answer}', actual '{val}'{END}")
exit(2)
