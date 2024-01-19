#!/bin/bash

# Lazrak Ali 28605235

# récupérer le choix de l'utilisateur
echo "Voulez vous VF ou VO?"
read CHOIX

# commencer boucle
IFS=,
while read animal vf vo
do
    # vérifier le choix de l'utilisateur
    if [ $CHOIX == "VF" ]
    then
        ./bin/cowsay -f $animal $vf
    elif [ $CHOIX == "VO" ]
    then
        ./bin/cowsay -f $animal $vo
    # si l'utilisateur a donné un option invalide
    else
        echo "Vous n'avez pas entré \"VF\" ou \"VO\""
        exit 1
    fi
done  < exo1/blabla.csv
# donner le contenu du fichier à read
