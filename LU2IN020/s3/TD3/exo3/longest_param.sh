#!/bin/bash

if [ $# -eq 0 ] ;
then
    echo "Il manque un parametre "
    echo "Using : ./longest_param.sh <text>"
    exit -1
fi 
max=$1 
for i in $@ ; do
    {
        if [ ${#i} -gt ${#max} ] 
        then
            max=$i
        fi 
    }
done
echo "le mot le plus long est '$max'"