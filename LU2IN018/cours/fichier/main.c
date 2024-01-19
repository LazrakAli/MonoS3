#include <stdio.h>
#include <stdlib.h>

/* 
    fopen(<fichier>,<mode ouverture>) : r (lecture seul, doit exister)
                                         w (ecriture seul)
                                         a (ajout fin fichier)
                                         r+ (lecture /ecriture, doit exister)
                                         w+ (lecture/ecriture, supprime contenue)
                                         a+ (ajout lecture/ecriture, fin de fichier)



    fclose (<fichier>) : fermer un fichier ouvert
    feof(<fichier>) : tester la fin d'un fichier
    
    [lecture]
    fgetc() : lire un caractere (return EOF SI fin de lecture OU erreur)
    fgets(<chaine>,<taille_Chaine>,<fichier>) : lit une ligne (return NULL si ERREUR ou FIN)
    fscanf(<fichier>,<format>,..........) : lit une ligne en nommant les attributs (return EOF SI fin de lecture OU erreur)


    [ecriture]
    fputc(<caractere>,<fichier>) : ecrit un caractere
    fputs(<chaine>,<fichier>)    : ecrit une ligne de texte
    fprintf(<fichier>,<format>,.....)  : ecrit du texte formater

    [positionnement]
    ftell(<fichier>) : retourne position curseur dans fichier

    fseek(<fichier>,<origine>) : deplace curseur
        -> <origine> : SEEK_SET (debut fichier)
                       SEEK_CUR (position courante)
                       SEEK_END (fin fichier)
    
    rewind(<fichier>) : réinitialiser la position du curseur


    [DIVERS]
    rename(<ancien_nom>,<nouveau_nom>) : change le nom du fichier
    remove(<fichier>) : supprime un fichier

*/


int main(void) {
    FILE *fic= fopen("sauvegarde.txt","w");

    if (fic == NULL) {
        exit(1);
    }
    
    int i=0;
    while (i != 10) {
        fputs("Aida c'est la plus Belle <3\n",fic);
        i++;
    }

    fclose(fic);

    return 0;
}
