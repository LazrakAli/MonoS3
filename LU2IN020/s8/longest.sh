#! /bin/bash

#lazrak Ali 28605235

#donction donnant le nom du fichier
function nomFichier(){
  nomFichier=$(echo $1 |rev| cut -d "/" -f1 |rev)
  echo $nomFichier
}
# Je préfère traiter toutes les exeptions une par une pour plus de clarté
function usage(){
  echo "Usage : $0 <FICHIER.txt> "
  exit 1
}
#verifier que le fichier est passé en paramètre
if [ $# -ne 1 ]; then
  echo "Erreur : fichier manquant "
  usage
fi
#Vérifié que le fichier existe
if [ ! -f $1 ]; then
  echo "Erreur : fichier inéxistant ou chemin inconnu"
  usage
fi
#verifié que le fichier est lisible
if [ ! -r $1 ]; then
  echo "Erreur : fichier illisible "
  usage
fi

# intialisation des variables
MAX=0
LONGEST_WORD=''

#boucle
i=0
while read MOT
do
  #si le nombre de caractère du MOT est supérieur au maximum déjà enregistré
  #son nombre de caractère devient le nouveau maximum
  if [ ${#MOT} -gt $((MAX)) ]; then
    MAX=${#MOT}
    LONGEST_WORD=$MOT
  fi
    #echo $i   #test pour prevenir les boucle vide ou infinie
    #((i++))
done <$1

#creer le repertoire des mots les plus long par fichier
if [ ! -d LONGEST_WORDS ]; then
  mkdir -p LONGEST_WORDS
fi

LETTRE_FICHIER=$(nomFichier $1)
cd LONGEST_WORDS
echo $LONGEST_WORD >$LETTRE_FICHIER.tmp
