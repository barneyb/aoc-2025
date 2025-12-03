#!/usr/bin/env bash
set -e

YEAR="$1"
DAY="$2"

while IFS= read -r line; do
    echo "$line"
    for PART in A B; do
        if echo "$line" | grep -qE "^\[__AOCD_VERIFY_${PART}__\[.+\]\]$"; then
            ANSWER=$(echo "$line" | cut -c 20- | rev | cut -c 3- | rev)
            echo -n "Verify Part $PART ... "
            python ../../aocd_submit_wrapper.py "$YEAR" "$DAY" "$PART" "$ANSWER"
        fi
    done
done
