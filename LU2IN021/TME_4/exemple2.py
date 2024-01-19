#Installation de pupl : (pulp est une librairie Python permettant de lancer GLPK à partir d'un programme Python. GLPK doit être installé préalablement.)
#https://pypi.org/project/PuLP/
 
#pip install pulp  OR
#python -m pip install pulp

from pulp import *

# Création du modèle
model = LpProblem(name="Exemple2", sense=LpMinimize) 

#nombre de variables
n=10

#n variables x
x = LpVariable.matrix("x", list(range(1,n+1)),lowBound=0) #n variables 

#Fonction objectif
model += lpSum(x) #on cherche à minimiser la somme des x

#Contraintes

y = list(range(1,n+1))

for i in range(n-2):
    model += (x[i]+x[i+1]+x[i+2] >= y[i]) 

#Résolution du problème
status = model.solve(solver=GLPK(msg=True,keepFiles=True)) #keepFiles permet de créer un fichier .sol contenant la solution

# Affiche le statut de la solution (optimale, non borné, etc.)
print("Status:", LpStatus[model.status])

# Affiche la valeur de la fonction objectif
print("objective=", value(model.objective))

#Affiche les valeurs optimales des variables de décision : 

for i in range(0,n):
	print("x[",i,"]=",value(x[i]))

#Remarque : En lancant le programme avec python exemple2.py on retrouve un fichier nommé Exemple2-pulp.lp contenant le programme linéaire, et un fichier nommé Exemple2-pulp.sol contenant les résultats de la résolution par GLPK



