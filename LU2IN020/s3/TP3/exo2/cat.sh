#!/bin/bash

if [ -d ./chunks ];then 
    cd chunks
    for i in {0..99};do
        if [ $i -le 9 ];then  
            if [ -f data.0$i ]
            then
                cat data.0$i >> final.jpeg
            else 
                echo "Il y'a un probleme avec data.0$i"
            fi
        else 
            if [ -f data.$i ];then
                cat data.$i >> final.jpeg
            else 
                echo "il y'a un probleme avec data.$i"
            fi
        fi
    done  
else 
    echo "Probleme de repertoire"
fi 