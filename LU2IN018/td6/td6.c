#include <search.h> 

void *lfind(const void* key,const void *array,size_t *nmeds,size_t size,comparaison_fn_t compar);//recherche simple
void *lsearch(const void* key,void *array,size_t *nmeds,size_t size,comparaison_fn_t compar);//recherche et ajoue
void *bsearch(const void* key,void *array,size_t *nmeds,size_t size,comparaison_fn_t compar);//recherche taleau trié

int compare_int(const *void v1,const void* v2){
    int* i1 =(int *)v1;
    int* i2=(int *)v2;
    return (*i1>*i2)-(*i1<*i2);
}

/* utilisation de lfind voir si lfind trouve 42
int tab[100]
int taille =100;
int v=42;
if(lfind(&v,tab,sizeof(int),taille,comparer_int)!=NULL)
    printf("%d est dand le tableau\n",v);
*/

/*      utlisation lsearch
    size_t nb_max=100;
    int *tab=(int *)malloc(nb_max *sizeof(int))
    size_t nb=0;
    srand(time(NULL));
    int alea;
    while(nb<nb_max){
        alea=rand();
        lsearch(&alea,tab,&nb,sizeof(int),comparer_int);
        //pas de nb++ car gérer par lsearch
    }

*/

/*      utilisation bsearch
    int v=42;
    if(bsearch(&v,tab;nb_max,sizeof(int),comparer_int)!=NULL)
        printfd("%d trouvée \n",v);
*/