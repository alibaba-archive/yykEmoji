#/bin/sh
ROOT="yykemoji/src/main/res"
SEEK_RESULT="$(find $ROOT -type f -name '*.webp')"
for f in $SEEK_RESULT; do
    echo "$f"
    dir="$(dirname $f)"
    filename=$(basename "$f")
    ext="${filename#*.}"
    filename="${filename%.*}"
    newname="$dir/$filename.png"
    if [[ "$ext" == 'webp' ]]
    then
        dwebp "$f" -o "$newname"
        rm "$f"
    fi
done