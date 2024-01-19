#! /bin/bash

if [ ! -d dico ]; then
       mkdir dico
fi

while read line; do
  echo "$line"  >> dico/${line:0:1}.txt
done < dico.txt
    
