#!/bin/bash

#affiche son PID
echo "je suis $$"

x=1
#lance une boucle de 10 tours 
while [ $x -le 10 ];do
    #execute fils.sh
    ./fils.sh
    x=$(($x+1))
done