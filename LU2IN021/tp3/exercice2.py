import matplotlib.pyplot as plt
import numpy as np
import math

file=open("./reactions.csv",'r')
texte=file.readlines()
file.close()

x=[]
y=[]
for f in texte:
    a=f.split(',')
    x.append(float(a[1]))
    y.append(float(a[2]))


#equation de la droite linéaire est agale a y*=a+bx
    #a = moyenneY-b*moyenneX
    #b= Sxy/Sxx

#moyenne des x
moyenneX=0
i=0
for j in x:
    moyenneX+=j
    i=i+1
moyenneX=moyenneX/i
moyenneY=0

#moyenne des y
i=0
for j in y:
    moyenneY+=j
    i=i+1
moyenneY=moyenneY/i

#Sxy
Sxy=0
for p in range(len(x)):
    Sxy+=(x[p]-moyenneX)*(y[p]-moyenneY)

#Sxx
Sxx=0
for j in x:
    Sxx+=((j-moyenneX)*(j-moyenneX))

#Syy
Syy=0
for j in y:
    Syy+=((j-moyenneY)*(j-moyenneY))

#b
b=Sxy/Sxx

#a
a=moyenneY-b*moyenneX

#Coefficient de correlation lineaire
r=Sxy/math.sqrt(Sxx*Syy)

#Coefficient de determination 

R2=r*r


#y*

Yetoile=[]
for i in x:
    Yetoile.append(a+b*i)

#SR erreur quadratique
SR=0
for i in range(len(y)):
    SR+=pow((y[i]-Yetoile[i]),2)

#Racine de l'estimateur sans biais

Resb=math.sqrt(SR/(len(x)-2))

#Residus normalisé

Rn=[]

for i in range(len(x)):
    Rn.append((y[i]-Yetoile[i])/Resb)

"""
Pour evaluer alpha et beta on peut faire un systeme avec les valeurs precedentes
    ainsi nous avons
        p+p*e**(alpha+beta*t)=e**(alpha+beta*t)
        p=e**(alpha+beta*t)*(1-p)
        p/(1-p)=e**(alpha+beta*t)

        ln(19)=alpha+beta*0.7
        ln(0.965/0.035)=alpha+beta

        (7*ln(0.965/0.035)-10*ln(19))/-3=alpha
"""
alpha=(math.log(11.5)-3*math.log(9))/-2
beta=(math.log(9)-alpha)/0.3

alpha1=(7*math.log(0.965/0.035)-10*math.log(19))/-3
beta1=(math.log(19)-alpha)/0.7
print(alpha)
print(beta)
print(alpha1)
print(beta1)



#-------------------affichage des differentes valeurs


print("moyenne des X:{0:.2f}".format(moyenneX))
print("moyenne des Y:{0:.2f}".format(moyenneY))
print("Sxy:{0:.2f}".format(Sxy))
print("Sxx:{0:.2f}".format(Sxx))
print("b:{0:.2f}".format(b))
print("a:{0:.2f}".format(a))
print("Coefficient de corrélation lineaire:{0:.2f}".format(r))
print("Coefficient de determination :{0:.2f}".format(R2))
print("Residus normalisés",Rn)

#--------------------affichage du graphe
"""
xx=np.linspace(0,max(x),100)
yy=a+b*xx

plt.plot(xx,yy,'-r')
plt.scatter(x,y)
plt.show()
"""