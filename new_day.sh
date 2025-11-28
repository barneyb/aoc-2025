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
    YEAR=`date +%Y`
    MONTH=`date +%m`
    if (( MONTH < 12 )); then
        YEAR=$((YEAR - 1))
    fi
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

if ! git diff --quiet; then
    git commit -am "WIP: auto-commit before starting $YEAR/$DAY"
fi

git checkout master
./run_all.sh

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
EOF
)"

DIR="${YEAR}/${NAME}_${DAY}"
echo
echo "Creating '${NAME}.jn' in '$DIR'"
echo
BNAME=`echo $NAME | sed -e 's/_/-/g'`
I=`git branch --list "$BNAME*" | wc -l`
if (( I > 0 )); then
    BNAME="$BNAME-$((I + 1))"
fi
git checkout -b $BNAME master
mkdir -p "$DIR"
cd "$DIR"

cat << EOF > "Makefile"
YEAR = ${YEAR}
DAY = ${DAY}
NAME = ${NAME}
include ../../make_vars.inc
PROG = \$(BIN)/\$(NAME)
OBJECTS = \\

all: \$(PROG) input.txt
	time \$(PROG) < input.txt

\$(OUT)/${NAME}.s: \\
		${NAME}.jn
	\${CATPILE}

include ../../makefile.inc
EOF

cat << EOF > "${NAME}.jn"
pub fn main() {
    puts("Hello, ${NAME}!");
    int line_count = 0;
    while !iseof() {
        free(read_line());
        line_count = line_count + 1;
    }
    printf("There are %d lines of input waiting!\n", line_count);
}
EOF

make
git add .
git commit -am "skeleton for $NAME"
idea Makefile
idea "${NAME}.jn"
