#!/bin/bash

for i in {1..9};do
    ./cesar 16 < ./fenetre_sur_coquillage/part$i
done >>dechiffrage