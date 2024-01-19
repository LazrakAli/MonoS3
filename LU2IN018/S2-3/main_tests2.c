#include <stdlib.h>
#include <assert.h>
#include <stdio.h>
#include <time.h>
#include <math.h>
#include "ecosys.h"
#define N 20

int main(){

    srand(time(NULL));

    Animal *liste_predateur=(Animal*) malloc(sizeof(Animal));
    Animal *liste_proie=(Animal*) malloc(sizeof(Animal));

    assert(liste_predateur);
    assert(liste_proie);
    
    Animal* a1=creer_animal((int)rand()%SIZE_X,(int)rand()%SIZE_Y,10);
    Animal* p1=creer_animal((int)rand()%SIZE_X,(int)rand()%SIZE_Y,10);
    
    for (int i=1;i<N;i++){
        ajouter_animal((int)rand()%SIZE_X,(int)rand()%SIZE_Y,10,&liste_predateur);
        ajouter_animal((int)rand()%SIZE_X,(int)rand()%SIZE_Y,10,&liste_proie);
    }
    
    
    assert(compte_animal_it(liste_predateur)==N);
    assert(compte_animal_it(liste_proie)==N);

    afficher_ecosys(liste_proie,liste_predateur);  

    Animal *an=liberer_liste_animaux(liste_predateur);
    Animal *an1=liberer_liste_animaux(liste_proie);
    
    enlever_animal(liste_predateur,liste_predateur);

    return 0;
}