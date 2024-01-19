#!/bin/bash

if [ $1 ] && [ -r $1 ]; then
    fichier=$1
    file=$(sed 's/,/\n/g' $fichier | grep -w 'nbbike' | sed 's/: /\n/g' | sed '1~2d' )
    cpt=0
    for a in $file; do
        cpt=$(($cpt+$a))
    done 
    echo "le nombre de velib est de $cpt"
else 
    echo "probleme de fichier"
fi