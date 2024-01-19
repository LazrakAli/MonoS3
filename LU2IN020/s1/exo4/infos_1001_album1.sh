#!/bin/bash

cd 1001_Albums_You_Must_Hear_Before_You_Die
echo "Les albums recommandés des Beatles sont :"
ls *Beatles* 

echo ""
echo ""

echo "les albums n'ayant qu'une seule lettre sont: "
ls *-?-*

echo ""
echo ""

CPT=0
for f in *.flac
do
	CPT=$((CPT+=1)) 
done 
echo "le nombre d'albums dans le repertoires est de $CPT"

echo ""
echo ""

SOMME=0
for f in *.flac
do
	SOMME=$(($SOMME+${#f}))
done 
echo "la taille moyenne d'albums est de $(($SOMME/$CPT))"

echo ""
echo ""

for i in {1955..2016}
do 
	X=''
	COMPTEUR=0
	for f in *-*-$i.flac
	do 
		COMPTEUR=$((COMPTEUR+=1))
	done
	jd=0
	while (($jd != $COMPTEUR))
	do
		X=$X'x'
		jd=$((jd+=1))
	done

	echo "$i : $X"
	done



