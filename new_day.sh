#!/usr/bin/env bash

set -e

DAY="$1"
YEAR="$2"

if [ -z "$DAY" ]; then
    echo "Day missing."
    echo "Usage: $0 day [year]"
    exit 1
fi
if [ -z "$YEAR" ]; then
    YEAR=2025
fi

if (( $YEAR < $DAY )); then
    # flip 'em around
    t=$YEAR
    YEAR=$DAY
    DAY=$t
fi

if (( $YEAR < 2025 )); then
    if (( $DAY > 25 )); then
        echo "There's no day $DAY in $YEAR?!"
        exit 2
    fi
else
    if (( $DAY > 12 )); then
        echo "There's no day $DAY in $YEAR?!"
        exit 2
    fi
fi

NAME="$(cat << EOF | python - "$YEAR" "$DAY"
import re
import sys
from aocd.models import Puzzle

year = int(sys.argv[1])
day = int(sys.argv[2])
name = Puzzle(year=year, day=day).title.lower()
name = f"{name}"
name = re.sub(r'[^a-z0-9]+', '_', name)

print(name)
EOF)"

DIR="${YEAR}/${NAME}_${DAY}"
echo
echo "Creating '${NAME}.jn' in '$DIR'"
echo
mkdir -p "$DIR"
cd "$DIR"

cat << EOF > "Makefile"
YEAR = ${YEAR}
DAY = ${DAY}
include ../../make_vars.inc
OBJECTS = \

all: \$(BIN)/${NAME} input.txt
	\$(BIN)/${NAME} < input.txt

include ../../makefile.inc
EOF

cat << EOF > "${NAME}.jn"
pub fn main() {
    puts("Hello, ${NAME}!");
    int lines = 0;
    while !iseof() {
        free(read_line());
        lines = lines + 1;
    }
    printf("There are %d lines of input waiting!\n", lines);
}
EOF

make
git add .
