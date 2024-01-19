#!/bin/bash

if [ $# -lt 1 ] || [ $1 -lt 0 ] ; then
	echo "Usage : $0 <positive_number>"
	exit -1
fi

if [ $1 -gt 0 ]; then
	printf "Ola :%-$1s0\n" " " 
	str="$str$(printf "Ola :%-$1s0\n" " ")"
	echo $str
	./$0 $(($1 - 1))
	pid=$!
else
#	while [ 0 ];do
		echo $str
#	done 	
fi
