#! /bin/bash

champion=""
max=0

if [ $# -lt $1 ] && [ ! -f $1 ]; then
	echo "Usage : $0 <nom_fichier>"
	exit
fi

while read line ;do 
	if [ $max -lt ${#line} ]; then
		champion=$line
		max=${#line}
	fi
done < $1

echo $champion > $1.tmp

