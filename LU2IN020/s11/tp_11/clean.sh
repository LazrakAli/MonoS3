#!/bin/bash
#clean.sh
killall usager.sh
killall lancement.sh
killall iss_synchro
iss_synchro destroy prise_nb_cabines
iss_synchro destroy prise_nb_paniers
iss_synchro destroy remise_nb_cabines
iss_synchro destroy remise_nb_paniers