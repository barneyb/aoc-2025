#!/usr/bin/env bash

set -e

if ! git diff --quiet; then
    echo "Working copy is dirty. Refusing to proceed."
    exit 1
fi

BRANCH="$(git branch --show-current)"
if [ "$BRANCH" = "master" ]; then
    echo "Already on master - you can't finish that?!"
    exit 1
fi

./run_all.sh
git checkout master
git merge $BRANCH
./run_all.sh
