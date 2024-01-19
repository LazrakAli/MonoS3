#!/bin/bash

for i in {0..5}
do 
	if ((i%2==0)) ;then 
		echo "le chiffre $i est paire"
	else 
		echo "le chiffre $i est impaire"
	fi
done