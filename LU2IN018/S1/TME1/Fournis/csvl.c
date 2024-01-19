#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int compte_mots_chaine(char *chaine) {


	int mots=0;
	
	while (*chaine != '\0') {
		if (*chaine != ' '){
			mots++;
			while (*chaine != ' ' && *chaine != '\0') chaine++;
		}
		if (*chaine != '\0') chaine++;
	}
	return mots;
}
//----------------------------------------------------------------------------------------------------------------


char **decompose_chaine(char *chaine)
{

  /* Fonction vue en TD, exercice 2, question 7 */

  char *pc= chaine;
  int nb_mots=0;
  char **ptab;
  char *psrc_mot;
  int ind_mot=0;

  //comptages des mots
  nb_mots=compte_mots_chaine(chaine);
	
  if (nb_mots == 0)
    return NULL;
  // allocation du tableau

  ptab = malloc((nb_mots + 1) * sizeof(char *));
  ptab[nb_mots] = NULL;
	
  // copie des mots
	
  pc=chaine;
  while (*pc)
    {
      if(*pc == ' ')
        {
          pc++;
          continue;
        }

      psrc_mot = pc;

      while((*pc != ' ') && (*pc)) pc++;

      //allocation du mot
      ptab[ind_mot] = malloc((pc - psrc_mot + 1)* sizeof(char));
      //copie du mot
      memcpy(ptab[ind_mot], psrc_mot, pc - psrc_mot);
      //insertion du marqueur de fin de chaine
      *(ptab[ind_mot] + (pc - psrc_mot)) = '\0';

      ind_mot++;
    }
	

  return ptab;
}



//----------------------------------------------------------------------------------------------------------------


char* compose_chaine(char **ptab_mots) {
  int taille = -1;
  for (int i=0;ptab_mots[i]!=NULL; i++ ){
    taille = taille+sizeof(ptab_mots[i])+1; 
  }
  char *string = malloc(sizeof(taille));
  if (!string){
    printf("Erreur d'allocation memoire");
    exit;
  }
  strcat(string, ptab_mots[0]);
  for (int i=1;ptab_mots[i]!=NULL; i++ ){
    char *esp=" ";
    strcat(string,esp);
    strcat(string, ptab_mots[i]);
  }
  return string;
}
		


//----------------------------------------------------------------------------------------------------------------


void *detruit_tab_mots(char **ptab_mots)
{
  int cpt=0;
  for (int i=0;ptab_mots[i]!=NULL;i++)
    cpt++;
  for (int i=0;i<cpt;i++)
    free(*ptab_mots[i]);
  free(ptab_mots);

}


//----------------------------------------------------------------------------------------------------------------

int compte_mots(char **ptab_mots)
{
  int y=0;
  for(int i=0;ptab_mots[i] != NULL;i++){
    y++;
  }
  return y;
}

//----------------------------------------------------------------------------------------------------------------

void affiche_tab_mots(char **ptab_mots)
{
  for (int i=0;ptab_mots[i]!=NULL;i++){
    printf("[%s] \t",ptab_mots[i]);
  }
  printf("\n");
}


//----------------------------------------------------------------------------------------------------------------

char **reduit_tab_mots(char **ptab_mots)
{
  
 //on alloue a new_tab le meme nombre de case que ptab_mots
  char **new_tab=malloc(sizeof(compte_mots(ptab_mots)));
  if (!new_tab){
    printf("Erreur d'allocation memoire");
    exit;
  }
  //on parcours les mots dans notre tab initiale
  for (int i=0;ptab_mots[i]!=NULL;i++){
    int x=0;
    //initialise en dehors de la boucle pour garder l'indantation du mot (taille du tab actuel)
    int y=0;
    for (y=0;new_tab[y]!=NULL;y++){
      if (new_tab[y]==ptab_mots[i])
        x=-1;
      
    }
    //si x=-1 alors le mot a deja était copie
    if (x != -1){
      new_tab[y]=malloc(sizeof(ptab_mots[i]));
      new_tab[y]=ptab_mots[i];
      // on decale NULL
      new_tab[y+1]=NULL;
    }
  }
  return new_tab;
}



//----------------------------------------------------------------------------------------------------------------

int main() {
  char *temp[]={"mot1","mot2","et","mot3","mot2",NULL};
 
 
  //------on teste la fonction compose_chaine 
  char *tp=compose_chaine(temp);
  printf("la phrase est: '%s'\n",tp);

  //------on teste la fonction compte_mots

  int m=compte_mots(temp);
  printf("Il y'a %d mots\n",m);

  //--------teste des fonction reduit_tab_mots et aussi affiche tab mots

  affiche_tab_mots(temp);
  char **tmp=reduit_tab_mots(temp);
  affiche_tab_mots(tmp);

	//----------teste de compte_mots_chaine
  
  char c[] = "hello world this is some text";
	printf("%d\n",compte_mots_chaine(c));

  //----------on libere la memoire allouer
  //detruit_tab_mots(tmp);
  //detruit_tab_mots(temp);
  free(tp);
  return 1;
}
