#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ecosys.h"


void ecrire_ecosys(const char *nom_fichier,Animal *liste_proies,Animal *liste_predateurs){
    Animal *tmp;
    FILE *F=fopen(nom_fichier,"w");
    if (F==NULL){
        fprintf(stderr,"Erreur ouverture fichier\n");
        return;
    }
    fprintf(F,"<proies>");
    tmp=liste_proies;
    while(tmp){
        fprintf(F,"x=%d y=%d dir=[%d %d] e=%f\n",tmp->x,tmp->y,tmp->dir[0],tmp->dir[1],tmp->energie);
        tmp=tmp->suivant;

    }
}


void lire_ecosys(char *nom_fichier,Animal **liste_proies,Animal **liste_predateurs){
    char buffer[256];
    FILE *f=fopen(nom_fichier,"r");
    if (f==NULL){
        printf(stderr,"Erreur ouvreture de fichier\n");
        return;
    }
    //on lit la premiere ligne de notre fichier 
    //fgets("flux de l'ecture",taille,ou le stocker)
    int x_lu,y_lu,dir0_lu,dir1_lu;
    float energie_lue;
    fgets(f,156,buffer);//au max 256char, s'arrete si un retour chariot present
    assert(strncmp(buffer,"<proies>",8)==0);
    fgets(f,256,buffer);
    while(strncmp(buffer,"</proies>",9)!=0){
        int ret=sscanf(buffer,"x=%d y=%d dir=[%d %d] e=%f",&x_lu,&y_lu,&dir0_lu,&dir1_lu,&energie_lue);
        assert(ret==5);
        Animal *a=creer_animal(x_lu,y_lu,energie_lue);
        a->dir[0]=dir0_lu;
        a->dir[1]=dir1_lu;
        a->suivant=*liste_proies;
        *liste_proies=a;
        fgets(f,256,buffer);
    }
    fgets(f,156,buffer);
    assert(strncmp(buffer,"<predateur>",12)==0);
    fgets(f,256,buffer);
    while(strncmp(buffer,"</predateur>",13)!=0){
        int ret=sscanf(buffer,"x=%d y=%d dir=[%d %d] e=%f",&x_lu,&y_lu,&dir0_lu,&dir1_lu,&energie_lue);
        assert(ret==5);
        Animal *a=creer_animal(x_lu,y_lu,energie_lue);
        a->dir[0]=dir0_lu;
        a->dir[1]=dir1_lu;
        a->suivant=*liste_predateurs;
        *liste_predateurs=a;
        fgets(f,256,buffer);
        //meme chose qu'avant en remplasant *liste_proies par *liste_predateurs
    }
    fclose(f);
}

void bouger_animaux(Animal *la){
    float p_ch_dir=0.01;
    while (la){
        if (rand()/(float)RAND_MAX < p_ch_dir) {
            la->dir[0]=rand()%3-1;
            la->dir[1]=rand()%3-1;
        }
        la->x=(la->x+la->dir[0]+SIZE_X)%SIZE_X;
        la->y=(la->y+la->dir[1]+SIZE_Y)%SIZE_Y;
        la=la->suivant;
    }    
}


void reproduce(Animal **la,float p_reproduce){
    if (*la != NULL){
        Animal *l=*la;
        while(*l){
            if(rand()/(float)RAND_MAX < p_reproduce){
                ajouter_animal(l->x,l->y,l->energie/2,la);
                l->energie=l->energie/2;
            }
            l=l->suivant;
        }
    }
}