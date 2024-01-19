#!/bin/bash
#BERRADA Nacer 28610440
wget -q https://opendata.paris.fr/explore/dataset/arbresremarquablesparis/download/?format=csv

#definir l'arrondissement à la plus grande fréquence d'apparition
#ne pas oublier de supprimer les doublons
echo -n "L'arrondissement de Paris possédant le plus d'arbres remarquables est : "
echo $(cat index.html\?format\=csv  |sed -En 's/([^;]*;){7}([^;]*);.*/\2/p' |sort |uniq -c |sort -nr|sed -En "1s/ *[0-9]* (.*)/\1/p")


rm index.html\?format\=csv 
