#!/bin/bash
if [ $# -ne 3 ]; then 
    echo "Il faut 3 parametres"
    echo "Usage : $0 <nb_usagers> <nb_paniers> <nb_cabines>"
    exit 1
fi
echo $2 > ./tmp/28605235/nb_paniers
echo $3 > ./tmp/28605235/nb_cabines

iss_synchro create verrou_cabines
iss_synchro create verrou_paniers
for i in {1..$0};do
    ./usager.sh $
done 
wait 
iss_synchro destroy verrou_cabines 
iss_synchro destroy verrou_paniers