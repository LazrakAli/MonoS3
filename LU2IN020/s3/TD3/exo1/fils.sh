#!/bin/bash
nb=4
while [ $nb -gt 0 ] ; do
    chaine="$chaine$chaine"
    echo "$$ : $chaine"
    nb=$((nb-1))
done
export chaine

