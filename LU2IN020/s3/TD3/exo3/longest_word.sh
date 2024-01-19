#!/bin/bash
chaine=""
if [ $# -eq 1 ] && [ -f $1 ] 
then {
    
    while read ligne ; do
        ./longest_param.sh $ligne >> test.txt
    done < $1
    echo "$chaine"
    }
else 
    echo "Erreur de lecture du fichier entrée en arguement"
fi
