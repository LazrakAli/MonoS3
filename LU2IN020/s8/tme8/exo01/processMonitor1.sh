#! /bin/bash

if [ $# -lt 1 ] || [ ! -f '/proc/$1/exe' ]; then
    echo "Usage : $0 <PID>"
    exit
fi

for i in {1..60}; do
	echo "$i secondes : "
	ps o pid,ppid,state,command $1
	sleep 1
done
