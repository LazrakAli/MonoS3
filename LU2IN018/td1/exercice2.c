
int compte_mots_chaine(char *chaine){
    int nb_mots=0;
    while(*chaine){//while(*chaine!=\0)
        if (*chaine==' '){
            chaine++;
            continue;//passae a iteration suivante de la boucle
        }
        nb_mots++;
        while((chaine!=' ')&&(*chaine))chaine++;
       
    }
    return nb_mots;
}