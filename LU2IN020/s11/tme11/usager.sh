#!/bin/bash

echo "Arrivee de l'usager $$"
source ./prendre_ressource.sh ./tmp/28605235/nb_paniers
source ./prendre_ressource.sh ./tmp/28605235/nb_cabines
source ./prendre_ressource.sh ./tmp/28605235/nb_cabines
echo "Usager $$ se baigne "
sleep 3
source ./prendre_ressource.sh ./tmp/28605235/nb_cabines
source ./prendre_ressource.sh ./tmp/28605235/nb_paniers
source ./prendre_ressource.sh ./tmp/28605235/nb_cabines
echo "Fin de $$"
