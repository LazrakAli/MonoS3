#!/bin/bash
#lancement.sh
if [ $# -ne 3 ]; then 
    echo "Il faut 3 parametres"
    echo "Usage : $0 <nb_usagers> <nb_paniers> <nb_cabines>"
    exit 1
fi
echo $2 > /tmp/28707365/nb_paniers
echo $3 > /tmp/28707365/nb_cabines

iss_synchro create prise_nb_cabines
iss_synchro create prise_nb_paniers
iss_synchro create remise_nb_cabines
iss_synchro create remise_nb_paniers
for i in $(seq 1 $1); do
    ./usager.sh &
done 
wait