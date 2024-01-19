#!/bin/bash
# prendre_ressource.sh
# verifer si le nombre de parametres est bon
if [ $# -ne 1 ]; then
    echo "Il faut un fichier en parametre pour prendre la ressource" 
    exit 1
fi
# verfier si le fichier existe et on a le droit de le lire
if [ ! -r $1 ]; then
    echo "Cannot read file"
    exit 1
fi

verrou=$(echo $1 | cut -d "/" -f4 | cut -d "_" -f2)
verrou="prise_nb_"$verrou
#echo $verrou
iss_synchro lock $verrou
#echo "$$ a pris $verrou (lock)"

# a : nombre de ressources disponibles actuallement dans le fichier
a=0
if [ -s $1 ]; then
    a=$(cat $1)
fi
while [[ "$a" -le 0 ]]; do
    sleep 1
    a=$(cat $1)
done 
echo $((a - 1)) > $1 # a la fin, on met a jour le fichier

iss_synchro unlock $verrou
echo "$$ a pris $verrou"
