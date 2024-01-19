#! /bin/bash

x=1
while [ $x -le 100 ]; do 
	echo $x
	if [ $((x%2)) -ne 0 ] 
	then
		x=$((x+x+3))
	else
		$((x--))
	fi
done
