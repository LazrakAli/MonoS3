#!/bin/bash

i=0
while [ $i -ne 4 ];do
    tmp=$(./biggest.sh $1)
    mv "./$1/$tmp" './selection'
    echo "$tmp a été déplacé dans le dossier selection"
    i=$(($i+1)) 
done 