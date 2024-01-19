#include <stdlib.h>
#include <stdio.h>
#include "../td5/TD5.txt"

typedef struct double_int{
    int a;
    int b;
}Double_int;

void *dupliquer_2int(const void *src){
    Double_int *iscr=(Double_int *)src;
    Double_int *dst =(Double_int *)malloc(sizeof(Double_int));
    if(dst==NULL){
        fprintf(stderr,"Erreur Malloc \n");
        return NULL;
    }
    dst->a=iscr->a;
    dst->b=iscr->b;
    return (void*) dst;
}

void copire2int(const void *src,void *dst){
    Double_int *isrc = (Double_int *)src;
    Double_int* idst =(Double_int *) dst;
    *idst=*isrc;
}

void detruire_2int(void * data){
    free(data);
}

void afficher_2_int(const void *data){
    Double_int *idata=(Double_int *)data;
    printf("a=%d b=%d\n",idata->a,idata->b);
}

/*
int comparer_2int(const void *a,const void *b){
    Double_int *ia=
}
*/


void * lire_2int(FILE *f){
    int i,j;
    int r=fscanf(f,"%d %d",&i,&j);
    if(r<2){
        return NULL;
    }
    Double_int *data=(Double_int *)malloc(sizeof(Double_int));
    if(data==NULL)
        return NULL;
    data->a=i;
    data->b=j;
    return (void *)data;
}

void map(Pliste pliste,void(*fonction)(void *data,void *oa),void *optarg);

void compte(void *data,void *optarg){
    char *mot=(char *)data;
    Pliste pl2i=(PListe *)optarg;
    int len=strlen(mot);
    PElement elt;
    elt chercher_liste(pl2i,&len);
    if (elt==NULL){//pas d'element de cette longueur
        Double_int new={len 1};
        inserer_place(pl2i,new);
    }
    else{//element deja existant
        Double_int *ielt=(Double_int *) elt;
        ielt->b++;
    }

}

int main(){
    Plist pl=malloc(sizeof(Liste));
    pl->elements=NULL;
    pl->dupliquer=dupliquer_str;
    pl->copier=copier_str;
    pl->dupliquer=dupliquer_str;
    pl->copier=copier_str;
    pl->dupliquer=dupliquer_str;
    pl->copier=copier_str;
    pl->dupliquer=dupliquer_str;
    pl->copier=copier_str;
    pl->dupliquer=dupliquer_str;
    pl->copier=copier_str;
    pl->dupliquer=dupliquer_str;
    pl->copier=copier_str;
    pl->dupliquer=dupliquer_str;
    pl->copier=copier_str;
    lire_liste(pl,"French_za");
    PListe pl2i=malloc(sizeof(Liste));
    pl2i->elements=NULL;
    pl2i->dupliquerdupliquer_2int;
    pl2i->copier=copier_2int;
    pl2i->dupliquerdupliquer_2int;
    pl2i->copier=copier_2int;
    pl2i->dupliquerdupliquer_2int;
    pl2i->copier=copier_2int;
    pl2i->dupliquerdupliquer_2int;
    pl2i->copier=copier_2int;
    pl2i->dupliquerdupliquer_2int;
    pl2i->copier=copier_2int;
    pl2i->dupliquerdupliquer_2int;
    pl2i->copier=copier_2int;
    pl2i->dupliquerdupliquer_2int;
    pl2i->copier=copier_2int;
    map(pl,compte,pl2i);
    map(pl,compte,pl2i);
    afficher_liste(pl2i);
    detruire_liste(pl2i);
    detruire_liste(pl);
    return 0;
}