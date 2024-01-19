#!/bin/bash


if [ $1 ];then 
	PID=$$
	echo -e "PID du pere est de $$."
	for f in {1..10}
		do 
		cd ..
		./exo3/fils.sh
		done
else 
	echo "il manque un parametre"
	exit
fi
