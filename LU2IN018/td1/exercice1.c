#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#define TAILLE 5

void min_max_moy0(int *min,int *max, float *moy,int tab[],int taille ){
    *min=tab[0];
    *max=tab[0];
    *moy=tab[0];
    for (int i=1;i<taille;i++){
        if (tab[i]<*min)
            *min=tab[i];
        if (tab[i]>*max)
            *max=tab[i];
        *moy+=tab[i];
    }
    *moy=*moy/taille;
}

void min_max_som(int *min,int *max,int *som,int tab[],int taille){
    if (taille==1){
        *min=tab[0];
        *max=tab[0];
        *som=tab[0];
    }
    else{
    //j'avance mon tab d'une case et je reduit ma taille de -1
    min_max_som(min,max,som,tab+1,taille-1);
    if(tab[0]<*min)
        *min=tab[0];
    if(tab[0]>*max)
        *max=tab[0];
    *som+=tab[0];
    }
}

void min_max_moy(int *min,int *max,float *moy,int tab[],int taille){
    int som;
    min_max_som(min,max,&som,tab,taille);
    *moy=(float)(som)/taille;
}

int main(){
    /*
    int t[TAILLE]={1,2,3,4,5};
    int min,max;
    float moy;
    min_max_moy(&min,&max,&moy,t,TAILLE);

    for (int i=0;i<TAILLE;i++){
        printf("%d ",t[i]);
    }
    printf("\n");
    printf("min=%d max=%d moy=%2.f\n",min,max,moy);
    */
   int *t;
   int j,min,max;
   float moy;
   for (int i=1;i<TAILLE;i++){
        t=malloc(i*sizeof(int));
        if(t==NULL){//(ou !t)
            printf("erreur de malloc\n");
            return 1;
        }
        for (j=1;j<=i;j++){
            t[j-1]=j;
        }
        min_max_moy(&min,&max,&moy,t,i);
        if (min!=1)
            printf("Min vaut %d au lieud de 1\n",min);
        if(max!=i)
            printf("Max vaut %d au lieu de %d\n",max,i);
        if (fabs(moy-(i+1)/2.0)>0.0001)
            printf("Moy vaut %f au lieu de %f\n",moy,(i+1)/2.0);
        free(t);  
   }
    return 0;
}