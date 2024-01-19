#! /bin/bash

#lazrak Ali 28605235

#creer un repertoire pour les fichier du dictionnaire
if [ ! -d ./dictionnaire ]
then
  mkdir -p ./dictionnaire
fi

#boocle
#lire les mot un pzr un
i=0
while read MOT
do
  #definir la première letttre du mot
  FIRT_LETTER=$( echo $MOT | cut -c1 )
  #si le fichier associer à la premère lettre du mot existe
  if [ -f .dictionnaire/$FIRT_LETTER.txt  ]; then
    echo $MOT>>./dictionnaire/$FIRT_LETTER.txt
  else #si le fichier associer à la premère lettre du mot n'existe pas
    echo $i
    echo $MOT>>./dictionnaire/$FIRT_LETTER.txt
  fi
  ((i++))
done <dico.txt
