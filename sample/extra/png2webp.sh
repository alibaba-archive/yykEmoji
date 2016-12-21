#!/bin/bash

ROOT="yykemoji/src/main/res"
SEEK_RESULT="$(find $ROOT -type f -name '*.png')"
for f in $SEEK_RESULT; do
    echo "$f"
    dir="$(dirname $f)"
    filename=$(basename "$f")
    ext="${filename#*.}"
    filename="${filename%.*}"
    newname="$dir/$filename.webp"
    if [[ "$ext" == 'png' && "$filename" != 'ic_launcher' ]]
    then
        cwebp -lossless -m 6 -af "$f" -o "$newname"
        rm "$f"
    fi
done