#!/bin/bash
if ! [ -d chunks ];then
    mkdir chunks
fi
cd chunks
for i in {0..99};do
    if [ $i -le 9 ];then         
        if ! [ -f data.0$i ];then 
            wget http://julien.sopena.fr/chunks/data.0$i
        fi
    else
        if ! [ -f data.$i ];then
            wget http://julien.sopena.fr/chunks/data.$i
        fi
    fi
done
