#! /bin/bash

#lazrak Ali 28605235

#lance toute les secondes pendant une minute,
#la commande ps sur le pid passé en paramètre.

function usage(){
  echo "Usage : ./processMonitor <UN_PID>"
  exit 1
}

#verifier que le nombre de paramètre est correcte
if [ $# -ne 1 ];
then
    usage
fi
#verifier l'xistance du PID
if [ ! -d /proc/$1 ]
then
    echo "ERREUR : processus inexistant"
    usage
fi


for t in {1..60};do
    echo "------------ $t seconde(s) ------------ "
    ps o pid,ppid,state --pid $1
    sleep 1
done
