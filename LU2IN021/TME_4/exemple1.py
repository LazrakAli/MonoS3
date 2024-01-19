#Installation de pupl : (pulp est une librairie Python permettant de lancer GLPK à partir d'un programme Python. GLPK doit être installé préalablement.)
#https://pypi.org/project/PuLP/
 
#pip install pulp  OU
#python -m pip install pulp

from pulp import *

#Exercice 1 du TME Semaine 3

# Création du modèle
model = LpProblem(name="Ex1TMESem3", sense=LpMaximize) #LpMinimize si on veut minimiser

#Variable x1
x1 = LpVariable("x1",  lowBound=0)  #x1 doit être supérieur à 0, pas de limite supérieure

#Variable x2
x2 = LpVariable("x2",  lowBound=0)  #x2 doit être supérieur à 0, pas de limite supérieure

#Variable x3
x3 = LpVariable("x3",  lowBound=0)  #x3 doit être supérieur à 0, pas de limite supérieure

#Fonction objectif
model += 3*x1 + 2*x2+ 4*x3

#Contraintes

model += x1+x2+2*x3 <= 4
model += 2*x1+3*x3 <= 5
model += 2*x1+x2+3*x3 <= 7

#Résolution du problème
status = model.solve(solver=GLPK(msg=True,keepFiles=True)) #keepFiles permet de créer un fichier.sol contenant la solution

# Affiche le statut de la solution (optimale, non borné, etc.)
print("Status:", LpStatus[model.status])

# Affiche la valeur de la fonction objectif
print("objective=", value(model.objective))

#Affiche les valeurs optimales des variables de décision : 

print("x1 =",value(x1)," x2 = ",value(x2)," x3 = ",value(x3))

#Remarque : En lancant le programme avec python exemple1.py on retrouve un fichier nommé Ex1TMESem3-pulp.lp contenant le programme linéaire, et un fichier nommé Ex1TMESem3-pulp.sol contenant les résultats de la résolution par GLPK



