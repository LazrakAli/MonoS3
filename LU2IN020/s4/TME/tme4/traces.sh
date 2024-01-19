#!/bin/bash

#Lazrak Ali 28605235



#creation de la fonction d'usage
function usage(){
  echo "Usage : $0 <fichier log>"
  exit 1
}
#reçoit un paramètre
if [ $# -ne 1 ]
then
  usage
fi
#verifier que ce paramètre est un fichier accessible en lecture
if [ ! -r $1 ]
then
  echo "Fichier non accessible en lecture "
  usage
fi


# --- Q3 -----------------------------------
nb_entree=$(( $(wc -l <$1) -2 ))
echo " Le nombre d'entrée est $nb_entree "

# --- Q4 -----------------------------------
#recuperer le nom du dernier connecté
LAST_USER=$(head -n 1 < connexions.log | cut -d " " -f1)
#whoami =? LAST_USER
if [ $LAST_USER == $(whoami) ]
then
  echo "Vous :$(whoami), êtes le dernier connecté"
else
  echo "Dernier utilisateur : $LAST_USER"
fi

# --- Q5 -----------------------------------
#nombre de mes connexions

#--- option 1 ----------------------
#last $whoami >> connexion.log
#nb_entree=$(( $(wc -l <$1) -2 ))

#--- option 2 ----------------------
#function utilisateur
function USER() {
    #cut -d " " -f1 $1 ne fonctionne pas que $1 n'est pas un fichier
    echo $(echo $1 | cut -d " " -f1)
}
MOI=0
AUTRES=0
while read -r INFO_CONNEXION
do
    USER=$(USER $INFO_CONNEXION)
    if [ $USER == $(whoami) ]
    then
      ((MOI++))
    elif [[ ! $USER == 'reboot' && ! $USER == '' && ! $USER == 'wtmp' ]]
    then
      ((AUTRES++))
    fi
done < connexions.log
echo $MOI
echo $AUTRES
