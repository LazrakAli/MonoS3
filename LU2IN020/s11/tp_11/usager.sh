#!/bin/bash
# usager.sh
echo "Arrivee de l'usager $$"
source ./prendre_ressource.sh /tmp/28707365/nb_paniers
source ./prendre_ressource.sh /tmp/28707365/nb_cabines 
source ./rendre_ressource.sh /tmp/28707365/nb_cabines
echo "Usager $$ se baigne"
sleep 10
source ./prendre_ressource.sh /tmp/28707365/nb_cabines
source ./rendre_ressource.sh /tmp/28707365/nb_paniers
source ./rendre_ressource.sh /tmp/28707365/nb_cabines
echo "fin de $$"
