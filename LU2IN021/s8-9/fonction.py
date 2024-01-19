from pulp import *
import numpy as np
import matplotlib.pyplot as plt

def f(x):
    return 1/(1+25*pow(x, 2))

x = np.linspace(-1, 1, 500)
y = f(x)

plt.plot(x, y, color="green")

x2 = []
y2 = []
for i in range(10):
    x2.append(-1+i/5)
    y2.append(f(-1+i/5))
x2 = np.array(x2)
y2 = np.array(y2)


#_______________________________________________________________________________
xp = []
yp = []
for i in range(10):
    xp.append(-1+i/5)
    yp.append(f(-1+i/5))
xp = np.array(xp)
yp = np.array(yp)


#_______________________________________________________________________________

def l(x, xp, i):
    res=1
    for xj in xp:
        if xp[i] != xj:
            res = res * ((x-xj)/(xp[i] - xj))
    return res
    

def lagrange(x, xp, yp):
    res = 0
    for i in range(len(xp)):
        res += yp[i] * l(x, xp, i)
    return res

x = np.linspace(-1,1,500)
y = lagrange(x, xp, yp)







#_______________________________________________________________________________
def s(x, xi, ai, bi, ci, di):
    return ai + bi * (x - xi) + ci * (x - xi)**2 + di * (x - xi)**3

def s_p(x, xi, bi, ci, di):
    return bi + ci * 2 * (x-xi) + di * 3 * (x - xi) ** 2

def s_pp(x, xi, ci, di):
    return 2 * ci + 6 * di * (x-xi)

model = LpProblem(name="Spline Cubique")

a = LpVariable.matrix("a", list(range(1,len(xp)+1)))
b = LpVariable.matrix("b", list(range(1,len(xp)+1)))
c = LpVariable.matrix("c", list(range(1,len(xp)+1)))
d = LpVariable.matrix("d", list(range(1,len(xp)+1)))

model += 1

#x = np.linspace(-1,1,10)

for i in range(len(xp) - 1):
    model += s(xp[i], xp[i],a[i],b[i],c[i],d[i]) == yp[i]
    model += s(xp[i+1], xp[i],a[i],b[i],c[i],d[i]) == yp[i+1]

for i in range(len(xp) - 2):
    model += s_p(xp[i+1], xp[i],b[i],c[i],d[i]) == s_p(xp[i+1], xp[i+1],b[i+1],c[i+1],d[i+1])
    
for i in range(len(xp) - 2):
    model += s_pp(xp[i+1], xp[i],c[i],d[i]) == s_pp(xp[i+1], xp[i+1],c[i+1],d[i+1])

model += s_p(xp[0], xp[0], b[0], c[0], d[0]) == -(50 * x[0])/((1 + 25*x[0])**2)
model += s_p(xp[8], xp[9], b[8], c[8], d[8]) == -(50 * x[9])/((1 + 25*x[9])**2)

# Résolution du problème
# keepFiles permet de créer un fichier .sol contenant la solution
status = model.solve(solver=GLPK(msg=True, keepFiles=False))

# Affiche le statut de la solution (optimale, non borné, etc.)
print("Status:", LpStatus[model.status])

# Affiche la valeur de la fonction objectif
print("objective=", value(model.objective))

# Affiche les valeurs optimales des variables de décision :
for i in range(len(xp) - 1):
    print("a =", value(a[i]))
    print("b =", value(b[i]))
    print("c =", value(c[i]))
    print("d =", value(d[i]))


values = xp
for i in range(len(values) - 1):
    x_axis = np.linspace(values[i], values[i+1], 200)
    plt.plot(x_axis, s(x_axis, values[i], value(a[i]), value(b[i]),value(c[i]),value(d[i])))
plt.show()