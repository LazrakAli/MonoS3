#!/bin/bash

cd 1001_Albums_You_Must_Hear_Before_You_Die


echo Les albums recommandés des Beatles sont :
ls *Beatles*


echo

ls *-[A-z]-*.flac

echo 
CPT=0
for f in *.flac
do
	CPT=$(($CPT+1))
done
echo -e "Cette collection comporte $CPT albums.\n"

echo 

SOMME=0
for f in *.flac
do 
	SOMME=$(($SOMME+${#f}))
done 

MOYENNE=$(($SOMME/$CPT))
echo -e "La myenne des tailles des noms de fichier de ces albums et de $MOYENNE. \n"

echo

for f in {1995..2016}
do 
	echo $f : 
	for g in *.flac
	do
		if (("*-*-$f.flac" == "$g"))
		then
			echo x
		fi
	done
	echo -e "\n"
done 

	

















