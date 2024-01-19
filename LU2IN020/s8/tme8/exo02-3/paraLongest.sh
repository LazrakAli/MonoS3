#! /bin/bash

if [ $# -lt $1 ] && [ ! -d $1 ]; then
	echo "Usage : $0 <nom_repertoire>"
	exit
fi

for f in $1/*.txt ; do 
	./longest.sh $f &
	liste_pid="$! "
done

champion=""
max=0

for f in $(cat $1/*.tmp); do 
	for y in $liste_pid; do
		wait $y
	if [ $max -lt ${#f} ];then
		champion=$f
		max=${#f}
	fi
	done	
done

echo "Le plus long mot du dictionaire est $champion"
