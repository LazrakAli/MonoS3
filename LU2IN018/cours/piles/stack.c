#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

Stack new_stack(void) {
    return NULL;
}

//------------------------------------------------------------

Bool is_empty_stack(Stack st){
    if(st ==NULL)
        return true;
    return false;
}

//-------------------------------------------

Stack push_stack(Stack st, int x){
    StackElement *element;

    element = malloc(sizeof(*element));
    
    if (element == NULL) {
        fprintf(stderr, "Probleme allocation dynamique");
        exit(EXIT_FAILURE);
    }
    element -> value = x;
    element -> next = st;

    return element;
}

//---------------------------------------------------

void taille_de_la_pile(Stack sta) {
    if (is_empty_stack(sta))
        printf("la pile est vide\n");
    else{ 
        printf("la pile est pleine\n");
    }
}
//--------------------------------------------------------------------
Stack retirer_Dernier_Element(Stack st) {

    if(is_empty_stack(st)) //renvoie true si la pile est vide
        return new_stack();

    StackElement *element;
    element=malloc(sizeof(*element));

    element=st->next;
    free(st);
    
    return element;
}

//---------------------------------------------------

Stack clear_stack(Stack st) {
    StackElement *element;
    while (is_empty_stack(st)){ //renvoie true si la pile est vide
        st=retirer_Dernier_Element;
    }
    return st;
}

//----------------------------------------------------------------------------

void print_stack(Stack st){
    if (is_empty_stack(st)){
        printf("Rien a afficher, la pile est vide\n");
    }
    while(!is_empty_stack(st)){
        printf("[%d]\n",st->value);
        st=st->next;

    }
}

