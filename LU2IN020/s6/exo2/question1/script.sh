#!/bin/bash
#BERRADA Nacer 28610440

#verifier la présence d'un paramètre
if ! [ $# -eq 1 ];then 
	echo  argument manquant
	exit 1
fi

#verifier la présence d'un fichier
if ! [ -f $1  ];then 
	echo <usage>:file
	exit 1
fi

#modifie le fichier passé en paramètre en ligne puis on cherche la présence du mot"numbikesavailable" et inscrire dans le fichier temporaire tmp le nombre qui lui ai associé.La creation du fichier tmp permet de preserver le fichier original
cat $1 |tr ',' '\n'|sed -En "s/\"numbikesavailable\": ([0-9]+)/\1/p" >tmp

sum=0
#calcule du nombre de velib disponible
while read ligne ; do
	sum=$((sum+ligne))
done<tmp

rm tmp

echo "D'aprés l'exercice Paris compte $sum vélibs. "
