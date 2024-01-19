#!/bin/bash


for s in $(kill -l | tr -s '\t' '\n' | cut -d')' -f2 | tr -d ' '); do 
    trap 'Nop' $s 
done 

while true; do
    echo "il ne doit en rester qu'un"
    sleep 1
done
