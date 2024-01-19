
# TME 8 

# Exercice 1

## Question 1

avec les commande : 
```bash 
sleep 30 &
ps o pid,ppid,state --pid $!
```

On obtient :
```
 PID  PPID S
 6298  6280 S
 ```

## Question 2

Avec le script : 

./script.sh
```bash
#! /bin/bash

sleep 60 &
echo "Debut pere $$ je lance $!" 
echo "fin pere"
```

Puis la ligne de commande : 
```bash 
ps o pid,ppid,state,command --pid $!
```

On obtient : 

```
PID  PPID S COMMAND
527  526  S -bash
792    1  S sleep 60
793  527  R ps o pid,ppid,state,command
 ```

-  Le processus pere (script) se termine avant son fils (sleep) ce qui provoque la creation d'un fils zombie.
- Sleep est alors adopté par init (de PID 1).

Ce qui prouve bien l'adoption d'un processus par init.

## Question 3

Afin de répéter la commande chaque seconde on utilise sleep 1

Il y a 2 methode : 


La premiere lance la commande ps sur le pid en parametre pendant 1min. Et continue meme si le processus est terminé.
En prenant soin qu'il y ait bien un parametre et que ce soit un pid.

./processMonitor.sh
```bash
#! /bin/bash

if [ $# -lt 1 ] || [ ! -f '/proc/$1/exe' ]; then
    echo "Usage : $0 <PID>"
    exit
fi

for i in {0..59}; do
    echo "$1 secondes :"
    ps o pid,ppid,state,command --pid $1
    sleep 1
done
```

La deuxieme lance la commande ps sur le pid en parametre pendant 1min. Mais s'arrete si le processus rentré en parametre se termine. Pour ce faire on utilise une variable qui sert de compteur de secondes.

./processMonitor.sh
```bash 
#! /bin/bash

if [ $# -lt 1 ] || [ ! -f '/proc/$1/exe' ]; then
    echo "Usage : $0 <PID>"
    exit
fi

i=0
while [ $i -lt 59 ]; do
    echo "$1 secondes :"
    ps o pid,ppid,state --pid $1
    sleep 1
    i=$((i+1))
done
```

## Question 4

./zombieDetector.sh
```bash
#!/bin/bash

if [ $# -lt 1 ] || [ ! -f '/proc/$1/exe' ]; then
    echo "Usage : $0 <PID>"
    exit
fi

state=$( ps o pid,state $1  | grep "$1" | tr -s ' ' | cut -d ' ' -f2)
while [ $state != 'Z' ]
do
        state=$(ps o pid,state $1  | grep "$1" | tr -s ' ' | cut -d ' ' -f2)
done
echo "Le processus est devenu un zombie"
```

# Exercice 2

Ce script permet de créer un répertoire dico, générer un fichier txt par lettre contenant tous les mots commençant par cette lettre.
1. Creer le directory dico s'il n'existe pas
2. Lis ligne par ligne contenant un mot
3. Deplacer le mot dans le fichier correspondant a sa premiere lettre

./mvscript1.sh
```bash
#! /bin/bash

if [ ! -d dico ]; then
       mkdir dico
fi

while read line; do
  echo "$line"  >> dico/${line:0:1}.txt
done < dico.txt

```

# Exercice 3

## Question 1

1. champion = mot le plus long 
2. max = taille mot le plus long
3. Si un fichier est bien rentré en parametre on commence la recherche
4. Si un mot lu est plus long que champion on met a jour le plus long mot et sa taille
5. On cree un fichier .tmp contenant le plus long mot

./longest.sh
```bash
#! /bin/bash

champion=""
max=0

if [ $# -lt 1 ] || [ ! -f $1 ]; then
        echo "Usage : $0 <nom_fichier>"
        exit
fi

while read line ;do 
        if [ $max -lt ${#line} ]; then
                champion=$line
                max=${#line}
        fi
done < $1

echo $champion > $1.tmp
```

## Question 2

1. Si un directory est bien rentré en parametre on commence la recherche
2. On cree des fichiers tmp contenant le plus long mot de chaque fichier du directory en parallele (le mot le plus long par fichier sont independant les uns des autres)
3. On garde dans une liste le pid de chaque processus de recherche
4. champion = mot le plus long / max = taille mot le plus long
5. Comme on a besoin du fichier contenant le mot le plus long par lettre on lance une commande wait sur la liste de PID pour verifier que le processus de recherche est bien fini
6. Si un mot lu est plus long que champion on met a jour le plus long mot et sa taille
7. On affiche le plus long mot du dictionnaire

./paraLongest.sh
``` bash
#! /bin/bash

if [ $# -lt 1 ] || [ ! -d $1 ]; then
        echo "Usage : $0 <nom_repertoire>"
        exit
fi

for f in $1/*.txt ; do 
        ./longest.sh $f &
        liste_pid="$! "
done

champion=""
max=0


for f in $(cat $1/*.tmp); do 
    for y in $liste_pid; do
        wait $y
        if [ $max -lt ${#f} ];then
            champion=$f
            max=${#f}
        fi
    done
done

echo "Le plus long mot du dictionnaire est : $champion"
```

## Question 3

```
time ./longest.sh dico.txt
```

- real    0m2,110s
- user    0m1,797s
- sys     0m0,308s

```
time ./paraLongest.sh dico
```

- real    0m0,096s
- user    0m0,071s
- sys     0m0,012s

On remarque que le temps mis par le script _paraLongest.sh_ est beaucoup plus rapide que _longest.sh_. 
-   Le temps d'execution a été divisé par 20
-   Le temps d'utilisation du processeur en mode user a été divisé par plus de 100
-   Le temps d'utilisation du processeur en mode systeme a été divisé par plus de 10
Cela prouve que paralelliser les taches optimise grandement le temps de recherche.

## Question 4

```
time ./longest.sh dico.txt
```

- real    0m2,110s
- user + sys =  0m1,797s + 0m0,308s = 0m2,105 

```
time ./paraLongest.sh dico
```

- real    0m0,096s
- user + sys =  0m0,071s + 0m0,012 = 0m0,083

On remarque que la somme des temps user et sys sont tres proche des temps de real a 0,010s pres

Ce resultat s'explique parce que 

- Le temps ``real`` : correspond au temps ecoule entre le debut et la fin de l'appel comprenant temps utilisé par les processus et le temps en état bloqué

- Le temps ``user`` : correspond au temps ou le processus est  en mode en mode utilisateur 
- Le temps ``sys`` : correspond au temps le temps ou le processus est en mode en mode systeme (super utilisateur)

donc real = temps de processus en mode utilisateur + temps de processus en mode systeme 

## Question 5

```
- taux de Parallelisme = (Temps real avec parallelisme)/(Temps real sans parallelisme)

-  0,096 / 2,110* 100 = 4,5
```

Oui ce resultat parfait satisfaisant car le taux est tres petit. Donc le temps de processus avec parallelisme est tres petit devant le temps du processus sans parallelisme.