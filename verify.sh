#!/usr/bin/env bash
set -e

YEAR="$1"
DAY="$2"

while IFS= read -r line; do
    echo "$line"
    if echo "$line" | grep -qF '[__AOCD_VERIFY_A__['; then
        ANSWER=$(echo "$line" | grep -F '[__AOCD_VERIFY_A__[' | cut -c 20- | rev | cut -c 3- | rev)
        echo -n "Verify part one... "
        python ../../aocd_submit_wrapper.py "$YEAR" "$DAY" a "$ANSWER"
    elif echo "$line" | grep -qF '[__AOCD_VERIFY_B__['; then
        ANSWER=$(echo "$line" | grep -F '[__AOCD_VERIFY_B__[' | cut -c 20- | rev | cut -c 3- | rev)
        echo -n "Verify part two... "
        python ../../aocd_submit_wrapper.py "$YEAR" "$DAY" b "$ANSWER"
    fi
done
