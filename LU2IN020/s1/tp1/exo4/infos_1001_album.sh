#!/bin/bash

cd 1001_Albums_You_Must_Hear_Before_You_Die

#Q:4
echo "Les albums recommandé des Beatles sont: "
ls *Beatles*

#
echo 
#

#Q:5
echo "album(s) ayant qu'une seul lettre: "
ls *-[A-z]-*


#
echo 
#

#Q:6
echo "le nombre d'album est present dans le repertoire est de:"
j=0
for i in $(ls);do 
    j=$(($j+1))
done
echo "$j" 

#
echo ""
#

#Q:7
 x=$(ls|wc -m) 
 echo "la moyenne des tailles des noms de fichiers de ces albums est de: $(($x/$j))"

#
echo ''
#

 #Q:8

for x in {1995..2016};do
    s=''
    for i in $(ls *$x*);do 
        s+='X'
    done
    echo "$x: $s"
done
