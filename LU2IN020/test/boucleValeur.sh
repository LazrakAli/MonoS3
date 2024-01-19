#! /bin/bash
echo $cpt 
function f(){
    if [ $cpt > 3 ] ; then  
        echo "fin du script"
        exit 1
    fi
    echo "je suis intuable"
    cpt=$((cpt+1))
}
cpt=0
trap 'f' SIGUSR1
value=0
while true ; do
    value=$((value+1))
done