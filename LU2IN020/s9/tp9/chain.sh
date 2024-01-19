#!/bin/bash

if [ $# -lt 1 ] || [ $1 -lt 0 ]; then 
    echo "Usage : $0 <positive number> "
    exit -1
fi
while true; do
    if [ $1 -gt 0 ]; then
        printf "Ola :%-$1s0\n" " "
        ./$0 $(($1-1))
        wait $!
    fi
    
done 