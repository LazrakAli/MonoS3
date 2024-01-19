#! /bin/bash
# ecriture.sh

if [ $# -lt 1 ] ; then
  echo Il faut au moins un parametre
  exit 1
fi


for elem in "$@" ; do
  if [ ! -e "$elem" ] ; then
    echo premier $$ > "$elem"
    iss_synchro lock mylock
  else
    echo suivant $$ >> "$elem"
  fi
    iss_synchro unlock mylock
done