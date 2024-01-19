#! /bin/bash

while IFS=',' read salle nbMachine ; do
    for id in $(seq -w $nbMachine) ; do
        echo "ppti-14-$salle-$id"
    done
done < $1