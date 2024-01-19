#! /bin/bash

#lazrak Ali 28605235

echo "--- Création d'un fils : ./processus_adopté $$ --"
ps o pid,ppid,state

#------------------------------------------------------------------
#par la commande sleep je cherche à representer
#la multiprogramation (système a temps partagé)
echo "--- Temps partagé -------------------------------"
echo "--- Retour au père ------------------------------"
sleep 1 #quantum
echo "--- Election processus Fils ---------------------"
ps o pid,ppid,state
#------------------------------------------------------------------




#A noter
#La partie entre le deux barre :
#------------------------------------------------------------------
#...
#------------------------------------------------------------------
#est un decallage de ma partir
#pour visualisé la multiprogramation
