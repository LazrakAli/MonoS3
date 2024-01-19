#!/bin/bash 


function usage(){
    echo "Usage : $0 <pid>"
    exit 1
}

if [ $# -eq 0 ];then 
    echo "Argument manquant"
    usage
fi

PID=$1
#ps -ef -e:afficher tout les processus -f:processus detaille
#awk '{print $2}' selectionne les valeur de la 2 eme commande
#l'option -w de grep nous assure d'avoir le PID et pas une derive
test=$(ps -ef | awk '{print $2}' | grep -w "$PID")
if [ "$test" == "" ];then 
    echo "$PID n'existe pas "
    exit 1
fi

echo "$PID"

while [ $PID -ne 1 ];do
    
    PID=$(ps -ef | grep -w "$PID" | awk '{print $3}' | head -n 1)
    echo "$PID"
done
