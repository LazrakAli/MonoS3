#!/bin/bash
#rendre_ressource.sh
# verifer si le nombre de parametres est bon
if [ $# -ne 1 ]; then
    echo "Il faut un fichier en parametre pour rendre la ressource" 
    exit 1
fi
# verfier si le fichier existe et on a le droit de le lire
if [ ! -r $1 ]; then
    echo "Cannot read file"
    exit 1
fi

verrou=$(echo $1 | cut -d "/" -f4 | cut -d "_" -f2)
verrou="remise_nb_"$verrou
iss_synchro lock $verrou
#echo "$$ veut rendre rends $verrou (lock)"

a=0 # a : nombre des ressources disponibles dans le fichier 
if [ -s $1 ]; then
    a=$(cat $1)
fi
echo $((a + 1)) > $1

iss_synchro unlock $verrou
echo "$$ a rendu $verrou"