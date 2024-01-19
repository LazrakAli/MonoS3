Lazrak Ali 28605235


# Exercice 1

## Question 1

1. Pour que le script ignore SIGINT il faut ajouter un trap au debut
2. On affiche "il ne doit en rester qu'un" 
3. On attend 1sec avant le prochain echo dans une boucle infinie

./highlander.sh
```bash
#!/bin/bash

trap 'I wont die' SIGINT

while [ 0 ]; do
 echo "il ne doit en rester qu'un"
 sleep 1
done
```

## Question 2

- Pour l'arreter on peut faire un SIGKILL dans un autre terminal.
Il faut alors recuperer le pid du highlander avec un ps actuel et lancer la commande.
- Si on veut le faire dans le meme terminal il faut executer higlander en tache de fond. Comme 1sec est trop court pour faire tout ca j'ai fait un script killhighlander qui permet de tuer highlander afin que les appels recursifs s'arretent

1. la variable current recuppere le pid du premier highlander.
Si le nom du script est different il faut modifier le grep dans la commande.
2. puis on envoie un signal SIGKILL au pid obtenu

./killHighlander.sh
```bash
#!/bin/bash

current=$(ps | grep 'highlander' | head -n 1 | cut -d ' ' -f2)

echo $current
kill -s SIGKILL $current
```

## Question 3

Dans le script invincible.sh j'ai créé une liste de tous les signaux 
1. avec une liste de leur numeros de signals
2. en parsant la liste de tous les signaux disponible
Cela permet de résister à tous les signaux mise à part SIGKILL qui ne peut pas etre réceptionné ni ignoré/bloqué.

./invincible.sh
```bash
#!/bin/bash

# trap 'echo I will never die muhahahaha' {1..31}
trap 'echo I will never die muhahahaha' $(kill -L | tr -s ' \t' '\n' | grep SIG | tr '\n' ' ')

while [ 0 ]; do
	echo "il ne doit en rester qu'un"
	sleep 1
done

```

# Exercice 2

## Question 1

- if : fichier en entrée = /dev/urandom
- of : fichier de sortie = /tmp/iss
- bs : taille des blocks copié/collé = 1b (fini avec un b donc 1 * 512)
- count : nombre de blocks copié = 5000000

affiche : 
```bash
5000000+0 records in
5000000+0 records out
2560000000 bytes transferred in 34.057419 secs (75167176 bytes/sec)
```

Soit le nombre de blocks en entrée et sortie demandé 
et le nombre de bytes transféré (count * bs = 5000000 * 512 = 256 * 10^7) avec le temps pris pour le transfert

## Question 2


# Exercice 3

## Question 1

./chain.sh
```bash
#!/bin/bash

if [ $# -lt 1 ] || [ $1 -lt 0 ] ; then
	echo "Usage : $0 <positive_number>"
	exit -1
fi

if [ $1 -gt 0 ]; then
	printf "Ola :%-$1s0\n" " " 
	./$0 $(($1 - 1))
fi
```
