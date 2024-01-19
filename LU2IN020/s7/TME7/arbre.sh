#!/bin/bash

if [ $1 ] && [ -f $1 ];then 
    affichage=$(cut -d ";" -f 8 $1 | sort | uniq -c | sort -n | tail -1)
    read a b <<<$affichage
    echo "L'arrondissement parisien possèdant le plus d’arbres remarquables  est $b"
else
    echo "probleme de fichier"
fi