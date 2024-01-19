#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

int main(){

    Stack sta = new_stack();
printf("----------------------------------------------\n");    
    sta = push_stack(sta,14);
    sta = push_stack(sta,419);
    sta = push_stack(sta,19);
    sta = push_stack(sta,619);
    print_stack(sta);
printf("----------------------------------------------\n");
    sta = retirer_Dernier_Element(sta);

    print_stack(sta);

printf("----------------------------------------------\n");
    sta = clear_stack(sta);

    return 0;
}