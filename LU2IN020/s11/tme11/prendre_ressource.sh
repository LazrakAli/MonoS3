 #!/bin/bash

function usage(){
    echo "$0 <fichier>"
    exit 1
}
 
#prendre_ressource.sh 
##verifie si le nombre de parametre 

if [ $# -ne 1 ];then 
    echo "Il faut un fichier en parametre pour prendre la ressouce"
    usage
fi
#verfie si on a le droit de lecture
if [ ! -r $1 ];then
    echo "Lecture impossible"
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

# a : nombre de ressources disponibles actuallement dans le fichier
a=0
if [ -s $1 ]; then
    read a <$1
else 
    echo "fichier vide"
    usage
fi

while [ $a -lt 1 ]; do
    sleep 1
    read a <$1
done 

echo $((a - 1)) > $1 # a la fin, on met a jour le fichier

iss_synchro unlock $verrou

echo "$$ a rendu $verrou"
