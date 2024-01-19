#! /bin/bash

if [ $# -lt 1 ] || [ ! -f '/proc/$1/exe' ]; then
    ./myZombie &
    exit
fi

i=0
while [ $i -lt 59 ]; do
    echo "$i secondes:"
    ps o pid,ppid,state $!
    sleep 1
    i=$((i+1))
done
