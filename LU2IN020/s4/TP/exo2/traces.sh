#!/bin/bash


function usage()
{
    echo "Usage: $0 <ficher>"
    exit 1
}


if [ $# -eq 0 ];then 
    echo "Il manque un argument"
    usage
elif [ ! -r $1 ];then 
    echo "Le fichier n'est pas lisible"
fi

username=$(whoami)

#on utilise head pour afficher les 2 premier ligne correspndant a la dernier connection
#tail -n -1 pour afficher la dernier ligne 
#utilisation de cut avec l'option -d ' ' pour sperarer par les espace et non les tba recuper le premier mot avec -f 1
dernier=$(head -n 2 connexion.log | tail -n -1 | cut -d ' ' -f 1)
if [ $username == $dernier ];then 
    echo "tu est le dernier connecté"
else 
    echo "tu n'est pas le dernier connecté"
fi


echo 

echo "Nombre de connexion :"
#on selection les ligne contenant notre username en suite on les compte avec wc et son option -l 
grep $username connexion.log | wc -l 


echo "Nombre utilisateurs connecté au moins 1 fois:"
#sort: tri par ordre ASCII uniq:permet de ne pas avoir de repetition 
head -n -2 connexions.log | cut -d ' ' -f 1 | sort | uniq | wc -l

echo

echo "Nombre machines distantes:"
cut -c 60- connexions.log | head -n -2 | sort | uniq | wc -l
echo


