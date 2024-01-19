#! /bin/bash

#lazrak Ali 28605235

if [ -d LONGEST_WORDS ]
then
  rm -rf LONGEST_WORDS
fi


if [[ $# -ne 1 || ! -d $1 ]]
then
  echo "Usage : $0 <UN_REPERTOIRE>"
fi

#passer un repertoire en paramètre puis definir son mot le plus grand
for f in $1/*txt
do
  ./longest.sh $f & # &: permet d'executer les fihchiers en arrière plan

done
wait #permet d'executer le fihchier en premier plan
     #jusqu'à ce que toute les tâche en arrière plans
     #soit terminée

MAX=''
for mot in $(cat LONGEST_WORDS/*.tmp)
do
  if [ ${#mot} -gt ${#MAX} ]; then
    MAX=$mot
  fi
done

echo "LONGEST_WORD_OF $1 : $MAX"
