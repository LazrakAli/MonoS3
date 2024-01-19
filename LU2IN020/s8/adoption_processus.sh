#! /bin/bash

#lazrak Ali 28605235

#etude de l'adoption d'un processus

# Le SWAPER Lance tout les processus fil
#INT est le premier fils son PID est 1
#INT lance ensuite tout les processus -> permet d'avoir une
#                                        multitude de fonctionnalité



echo "processus père : $$  " # $$=$PID
ps o pid,ppid,state
#lancement d'un processus à partir du processus courant
./processus_adopte.sh
#-----------------------------------------------------
echo "processus père : $$  "
sleep 3
#-----------------------------------------------------
echo "fin processus père : $$ "



#La partie entre le deux barres
#-----------------------------------------------------
#...
#-----------------------------------------------------
#est un decallage de ma partir
#pour visualisé la multiprogramation
