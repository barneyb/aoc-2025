#!/usr/bin/env bash
set -e

if [ -z "$JOHANN_HOME" ]; then
    echo "JOHANN_HOME is not set, please see the README"
    exit 1
fi

"$JOHANN_HOME/bin/jnc" --version
UTIL=./util

# utils first
for dir in "$UTIL" $(find . -name Makefile -depth 3 \
    | sed -Ee 's~^(\./([0-9]+)/.+_([0-9]+))/.*~\2 \3 \1~' \
    | sort -n \
    | cut -d ' ' -f 3); do
    echo
    echo "$dir"
    pushd "$dir" > /dev/null
    if [ "$1" = "--clean" ]; then
        make clean
    else
        tgt=verify
        if [ "$dir" = "$UTIL" ]; then
            tgt=all
        fi
        make clean $tgt
    fi
    popd > /dev/null
    echo
done
