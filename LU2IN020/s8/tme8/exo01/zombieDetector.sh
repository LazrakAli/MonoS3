#!/bin/bash

if [ $# -lt 1 ] || [ ! -f '/proc/$1/exe' ]; then
    echo "Usage : $0 <PID>"
    exit
fi

state=$( ps o pid,state $1  | grep "$1" | tr -s ' ' | cut -d ' ' -f2)
while [ $state != 'Z' ]
do
        state=$(ps o pid,state $1  | grep "$1" | tr -s ' ' | cut -d ' ' -f2)
done
echo "Le processus est devenu un zombie"
