#!/bin/bash


max=0
plgfichier=''
if [ -d "$1" ];then
    for fich in $(ls ./$1);do
        if [ -f ./$1/$fich ];then
            tmp=$(wc -m < ./$1/$fich)
            if [ $max -lt $tmp ];then 
                max=$tmp
                plgfichier=$fich
            fi
        fi
    done 
    echo "$plgfichier"
else 
    echo "Il y'a un probleme avec le repertoire"
fi


