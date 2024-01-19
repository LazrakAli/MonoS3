#!/bin/bash
function usage(){
    echo "$0 <fichier>"
    exit 1
}
#rendre_ressource.sh
# verifer si le nombre de parametres est bon
if [ $# -ne 1 ]; then
    echo "Il faut un fichier en parametre pour rendre la ressource" 
    usage
fi
# verfier si le fichier existe et on a le droit de le lire
if [ ! -r $1 ]; then
    echo "Cannot read file"
    usage
fi
#2types de fichier attendue ( ./tmp/28605235/nb_cabines ou ./tmp/28605235/nb_paniers ) 
verrou=$(echo $1 | cut -d "/" -f4 | cut -d "_" -f2)
if [ $verrou != "cabines" ] && [ $verrou != "paniers" ];then 
    echo "ce ne sont pas les bon fichiers"
    usage
fi
verrou="verrou_"$verrou

##afficher le verrou pour tcheck que c'est bon
#echo $verrou


iss_synchro lock $verrou
#echo "$$ veut rendre rends $verrou (lock)"

a=0 # a : nombre des ressources disponibles dans le fichier 
if [ -s $1 ]; then
    read a<$1
fi
echo $((a + 1)) > $1

iss_synchro unlock $verrou

echo "$$ a rendu $verrou"