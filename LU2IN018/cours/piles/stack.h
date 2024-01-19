#ifndef __stack__H__
#define __STACK__H__


//type Booléen
typedef enum {
    false, //1
    true //0
}Bool;



//Definition d'une pile 

typedef struct StackElement {
    int value ;
    struct StackElement *next;
}StackElement, *Stack;

    //prototypes des fonctions
    Stack new_stack(void);
    Bool is_empty_stack(Stack st);
    Stack push_stack(Stack st, int x);
    void taille_de_la_pile(Stack sta);
    Stack clear_stack(Stack st);
    void print_stack(Stack st);
    Stack retirer_Dernier_Element(Stack st);



#endif