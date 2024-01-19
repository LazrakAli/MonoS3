#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
if (argc != 3) {
printf("Il faut deux arguments\n");
exit(-1);
}
for (int i=0;i<argc;i++){
    printf("%s\n",argv[i]);
    if (i==1){
        printf("l'atoi de 22 est: %d\n",atoi(argv[i])+ atoi(argv[2]));
    }
}
//printf("Le résultat est : %d\n", atoi(argv[1]) + atoi(argv[2]));
return 0;
}