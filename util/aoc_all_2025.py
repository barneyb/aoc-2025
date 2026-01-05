import glob
import os
import re
import subprocess


def support():
    search_pattern = os.path.join("..", "*", "*", "Makefile")
    files = glob.glob(
        search_pattern,
        root_dir=os.path.dirname(__file__),
        recursive=True,
    )
    return [(int(y), int(d[-2:])) for y, d in [f.split("/")[1:3] for f in files]]


def solve(year, day, data):
    search_pattern = os.path.join("..", str(year), f"*{day:02}")
    cwd = os.path.dirname(__file__)
    dirs = glob.glob(
        search_pattern,
        root_dir=cwd,
    )
    if len(dirs) == 0:
        raise Exception(f"No solver for {year}/{day} found?!")
    if len(dirs) > 1:
        raise Exception(f"Found {len(dirs)} solvers for {year}/{day}?!")
    input_txt = os.path.join(cwd, dirs[0], "input.txt")
    with open(input_txt, mode="w+t") as fd:
        fd.write(data)
        fd.write("\n")
    try:
        proc = subprocess.run(
            [
                "make",
                "-C",
                dirs[0],
                "all",
            ],
            cwd=cwd,
            capture_output=True,
            check=True,
        )
    finally:
        os.remove(input_txt)
    part_a = None
    part_b = None
    for p, ans in re.findall(r"\[__AOCD_VERIFY_([AB])__\[([^]]+)]]", str(proc.stdout)):
        if p == "A":
            if part_a is None:
                part_a = ans
            elif part_a != ans:
                raise Exception(f"Multiple answers for part A?! '{part_a}' and {ans}")
        elif part_b is None:
            part_b = ans
        elif part_b != ans:
            raise Exception(f"Multiple answers for part B?! '{part_b}' and {ans}")
    return part_a, part_b
