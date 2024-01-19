J'ai été affecté au mauvais groupe j'ai donc dû refaire mes soumissions du TP1 et TP2

NOM Prenom: Lazrak Ali 
Numero etudiant: 28605235

EXERCICE 1

Q1) 	La solution trouvée la derniere fois est: 

x1 = 2.5
x2 = 1.5
x3 = 0

z = 10.5

Donc on pose c1, c2 et c3 les variables d'ecart.
Les variables en base sont: c3, x1, x2 et hors base c1, c2, x3

x1 = 5/2 - 1/2*c2 - 3/2*x3
x2 = 3/2 - c1 - 1/2*x3 + 1/2*c2
c3 = 11/2 + 1/2*c2 + c1 + 1/2*x3

w = 21/2 - 3/2*x3 - 2*c1 - 1/2*c2

Donc, notre solution optimale pour le dual est:

y* = (-1/2, -2, 0), car la troisieme var. d'ecart est en base.

Q2) 

Minimize	
	obj: 4 y1 + 5 y2 + 7 y3

Subject To
	y4: y1 + 2 y2 + 2 y3 >= 3 
 	y5: y1 + 3 y3 >= 2
	y6: 2 y1 + y2 + 3 y3 >= 4
Bounds
	0 <= y1 <= +Inf
	0 <= y2 <= +Inf
	0 <= y3 <= +Inf
End

On obtient y* = (0, 0.25, 1.25)

et les variables d'ecart (3, 3.75, 4) avec la solution optimale = 10

Q3) Non, car on a deja la solution optimale du primal, qui est egale a celle du dual.

EXERCICE 2

Q1) Le but est de maximiser le gain, donc 

La variable de decision est le nombre des secondes vendues a chaque client.

Soit x1, x2 et x3 ces trois variables.

Maximize	
	obj: 900 x1 + 1000 x2 + 800 x3
Subject To
	e1: x1 + x2 + x3 = 400 
 	e2: 0.75 x1 + 0.3 x3 >= 120
	e3: x1 + x2 <= 180
Bounds
	30 <= x1 <= +Inf
	30 <= x2 <= +Inf
	30 <= x3 <= +Inf
End

Q2)

x* = (72, 108, 220)

Le gain obtenu est bien 348 800

Q3) 

a) Oui, le nouveau gain est de 350900 

Maximize	
	obj: 900 x1 + 1000 x2 + 800 x3 - 820 x4
Subject To
	e1: x1 + x2 + x3 - x4 = 400 
 	e2: 0.75 x1 + 0.3 x3 >= 120
	e3: x1 + x2 <= 180
Bounds
	30 <= x1 <= +Inf
	30 <= x2 <= +Inf
	30 <= x3 <= +Inf
	0 <= x4 <= +Inf
End

b) 105 secondes

Q4) 

Maximize	
	obj: 900 x1 + 1000 x2 + 800 x3 + 5000 x5 
Subject To
	e1: x1 + x2 + x3 = 400 
 	e2: 0.75 x1 + 0.3 x3 >= 120
	e3: x1 + x2 <= 180
	e4: x1 - x2 - x5 >= 10
Bounds
	30 <= x1 <= +Inf
	30 <= x2 <= +Inf
	30 <= x3 <= +Inf
	0 <= x5 <= +Inf
End

Solution optimale trouve: 891000

Donc oui, c'est rentable de accepter l'offre. On lui donne 110 secondes pour $5000 par seconde.

Q5)

Le cout marginal de l'obligation de la regle des 120 secondes est de 111000 euros.


Maximize	
	obj: 900 x1 + 1000 x2 + 800 x3  
Subject To
	e1: x1 + x2 + x3 = 120 
	e3: x1 + x2 <= 180
Bounds
	30 <= x1 <= +Inf
	30 <= x2 <= +Inf
	30 <= x3 <= +Inf
End


Q6) Oui, se limiter a 2 clients est possible, mais pas rentable. Si c'etait le cas, la solution optimale trouve avait x1, x2 ou x3 egal a zero, en donnant tous les 400 secondes au deux clients.


EXERCICE 3

Q1) Les variables de decision sont: x1, x2, x3 et x4, pour representer (respectivement), le nombre des chambres de type 1, 2, 3, et 4.
La fonction objectif est de maximizer le profit. Donc, max z = somme de (combien coute une chambre type i) * (nombre des chambres de type i), avec i = 1, 2, 3, 4

La premiere contrainte est sur la surface totale. On dispose de 1500 m^2, donc on ecrit: 15 x1 + 20 x2 + 22 x3 + 20 x4 <= 1500
La deuxieme represente les heures des mains-d'oeuvres 30 x1 + 40 x2 + 50 x3 + 60 x4 <= 2000
La troisieme represente le nombre total des personnes x1 + 2 x2 + 2 x3 + 3 x4 <= 100 

On impose que x1, x2, x3, x4 sont superieurs ou egaux a 10 (il veut au moins 10 chambres) et x1 <= 20 (il veut au plus 20 chambres simples).

Maximize
	obj: 120 x1 + 170 x2 + 180 x3 + 240 x4 

Subject To
	e1: 15 x1 + 20 x2 + 22 x3 + 20 x4 <= 1500
	e2: 30 x1 + 40 x2 + 50 x3 + 60 x4 <= 2000
	e3: x1 + 2 x2 + 2 x3 + 3 x4 <= 100
	
Bounds
	10 <= x1 <= 20
	10 <= x2 <= +Inf
	10 <= x3 <= +Inf
	10 <= x4 <= +Inf
End	



Q2) La solution trouvee est: (10, 15, 10, 10), avec un profit maximal de 7950 euros.


Q3) Pour trouver la reponse, on ajoute une variable x5, qui represente le nombre des heures de la main-d'ouvre supplementaire.

La fonction objectif devient: 120 x1 + 170 x2 + 180 x3 + 240 x4 - 4 x5 ,
parce que on soustrait le cout genere par la main-d'oeuvre.

La contrainte 2 devient: 30 x1 + 40 x2 + 50 x3 + 60 x4 - x5 <= 2000

Maximize
	obj: 120 x1 + 170 x2 + 180 x3 + 240 x4 - 4 x5

Subject To
	e1: 15 x1 + 20 x2 + 22 x3 + 20 x4 <= 1500
	e2: 30 x1 + 40 x2 + 50 x3 + 60 x4 - x5 <= 2000
	e3: x1 + 2 x2 + 2 x3 + 3 x4 <= 100
	
Bounds
	10 <= x1 <= 20
	10 <= x2 <= +Inf
	10 <= x3 <= +Inf
	10 <= x4 <= +Inf
	0 <= x5 <= +Inf
End	

Le nouveau profit est de 8000 euros, donc il est interessant d'utiliser cette maneouvre.

Le nombre des heures qui maximise le profit est: x5 = 200 heures et donc la nouvelle solution est: x1 = 10, x2 = 20, x3 = 10, x4 = 10


Q4)

Cas 1: si il y a pas de main-d'ouvre supplementaire: Oui, parce que toutes les chambres construites occupe un total de 15*x1 + 20*x2 + 22*x3 + 20*x4 = 870 m^2
Donc, il nous reste 1500 - 870 = 630 m^2 disponibles pour la salle de seminaire

Cas 2: si il y a de main d'oeuvre supplementaire: Oui, la surface maximale est 1500 - 970 = 530 m^3

Remarque: la valeur du e1 (premiere variable d'ecart) est egale a la surface inoccupe par les chambres ( = surface maximale pour la salle de seminaire) 
Donc, pour le cas 1: on a e1 = 870 et pour le cas 2: e1 = 970

Q5) 

Q6)

Si il augumente le prix de la suite avec 5%, le nouveau prix est de 252 euros. 
Le profit obtenu avec ce nouveau prix est de 8070 euros, donc il est impossible de changer le prix sans changer le plan initial. (ou on a obtenu un profit de 7950 euros)
 

Maximize
	obj: 120 x1 + 170 x2 + 180 x3 + 252 x4

Subject To
	e1: 15 x1 + 20 x2 + 22 x3 + 20 x4 <= 1500
	e2: 30 x1 + 40 x2 + 50 x3 + 60 x4  <= 2000
	e3: x1 + 2 x2 + 2 x3 + 3 x4 <= 100	
Bounds
	10 <= x1 <= 20
	10 <= x2 <= +Inf
	10 <= x3 <= +Inf
	10 <= x4 <= +Inf
End	

