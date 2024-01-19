#!/bin/bash

echo "choisissez entre VO et VF"
read choix


while [ $choix != "VF" ] && [ $choix != "VO" ];do
    echo "choisissez entre VO et VF"
    read choix
done
IFS=,
while read animal vf vo; do
    if [ $choix == "VF" ];then 
        ~/usr/bin/cowsay -f $animal $vf
    else 
        ~/usr/bin/cowsay -f $animal $vo
    fi
done < blabla.csv
