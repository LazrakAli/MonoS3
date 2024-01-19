#!/bin/bash

if [ $# -eq 1 ] || [ f $1 ] 
then 
    while read ligne
    do 
        echo $ligne  
    done < $1
else
    echo "un probleme avec le fichier passer en parametre"    
fi