import numpy as np
import matplotlib.pyplot as plt
import math
import statistics as stat
from statistics import mean
#Exercice 1
# 1
print("Exercice 1")


def B(x,i,k,u):
    if k == 0:
        if u[i]<=x<u[i+1]:
            return 1.0
        else:
            0.0
    if u[i+k]==u[i]:
        c1=0.0
    else:
        c1=(x-u[i])/(u[i+k]-u[i])*B(x,i,k-1,u)
    if u[i+k+1] == u[i+1]:
        c2=0.0
    else:
        c2=(u[i+k+1]-x)/(u[i+k+1]-u[i+1])*B(x,i+1,k-1,u)
    return c1+c2

def bcurve(x,u,k,c):
    somme=0
    n = len(u)-1
    somme = 0
    for i in range(n):
        somme += c[i]*B(x,i,k,u)
    return somme

def I(x,i,k,u):
    for j in range(len(u)):
        if u[j] <= x <= u[j+1]:
            break
    
    if j < i+1:
        return 0
    if j > i+k:
        return 1
    
    s=0
    for t in range(i+1,j+1):
        s += B(x,t,k,u)
    return s


def icurve(x,u,k,c):
    s = 0
    m=len(u)-1
    for i in range(len(m-k-1):
        s += c[i] * I(x,i,k,u)
    return s

"Q:1"

u=[0,0,0,0,1,2,3,4,5,5,5,5]
m=len(u)-1
k=3
c[-0.5,0.5,-0.5,1,-0,5,1,-0,5-1]

X=np.linspace(u[0],u[m],100)
for i in range(m-k):
    Y= [B(x,i,k,u) for x in X]
    #plt.plot(X,Y)
#plt.show()

Y=[bcurve(x,u,c,k) for x in X] 

"Q:2"

v = [0,0,0,1,2,3,4,5,5,5 ]
m = len(v)-1
k=2
c[0,5,1,0.5,0.5,-0.5,-1,0.5]

X = np.linspace(v[0],v[m],100)
for i in range (m-k):
	Y = [B(x,k,i,v) for x in X]
	 #plt.plot(X,Y)
#plt.show()

#total des fonctions isplines est m-k+1 = 9-2+1 = 11

"Q:3"

u=[0,0,0,0,1,2,3,3,3,3]
k=3
m=len(u)-1
c=[0,0,0.3,0.3,0.4]
X = np.linspace(u[0],u[m]-0.001,100)
for i in range(m-k-1)
	Y=[isplines(x,k,i,u) for x in X]
	#plt.plot(X,Y)

Y = [icurve(x,u,c,k) for x in X]
#plt.plot(X,Y)

#plt.show()




#Exercice 2
print("Exercice 2")

"Q:1"

x=[1,2,3,4,5,6,7,8,9]
y=[8,12,9,6,15,10,12,7,10]
m= len(x)-1
k=3

u=list(range(-k,m+k+2)) #creation du vecteur u
#print(u)

for i in range(k-1):
	x.insert(0,x[0])
	y.insert(0,y[0])
	x.append(x[len(x)-1])
	y.append(y[len(x)-1])
#print(x)
#print(y)

plt.plot(x,y,'b.')
plt.plot(x,y,'black')
plt.axis[0,10,0,16]

X=np.linspace(x[0],x[len(x)-1],100)

Y=[bcurve(x1,u,y,k) for x1 in X] #on trace b-curve
plt.plot(X,Y)
plt.show()

"Q:2"

x=[1,2,3,4,5,6,7,8,9]
y=[8,12,9,8,15,10,12,7,10]

for i in range(k-1):
	x.insert(0,x[0])
	y.insert(0,y[0])
	x.append(x[len(x)-1])
	y.append(x[len(y)-1])

plt.plot(x,y,'b.')
plt.plot(x,y,'black')
plt.axis([0,10,0,17])

X= np.linspace(x[0],x[len(x)-1],100)
Y=[bcurve(x1,u,y,k) for x1 in X] # On trace la b-curve
plt.plot(X,Y)

#changement du point de controle (4,6) en (4,10)
x=[1,2,3,4,5,6,7,8,9]
y=[8,12,9,10,15,10,12,7,10]

for i in range(k-1):
	x.insert(0,x[0])
	y.insert(0,y[0])
	x.append(x[len(x)-1])
	y.append(x[len(y)-1])

plt.plot(x,y,'b.')
plt.plot(x,y,'black')
X = np.linspace(x[0],x[len(x)-1],100)
Y = [bcurve(x1,u,y,k) for x1 in X] #on trace b-curve
plt.plot(X,y)

plt.show()

# Observation: la modification est local


"Q:3"

#les m-k+2 points Qk,..., Qm+1 sont le y[k] -> y fin 
#b-curve Q(up)=Qp, p=k .. m+1
#ajoute Q k-1 = Q k et Q m+2 = Q m+1 => resoudre BP = Q

x=[1,2,3,4,5,6,7,8,9]
y=[8,12,9,6,15,10,12,7,10]
m=len(x)-1
k=3

u = list(range(-k, m+k+2))

xspline=[bcurve(i,u,k,x1) for i in np.arange(0,9,0.1)]
yspline=[bcurve(i,u,k,y1) for i in np.arange(0,9,0.1)] #On définit les points de nos courbes

for i in range(len(xspline)-1): #On va parcourir toute la liste de nos points
    if (int(xspline[i])%2 == 0): #On vérifie la parité de la partie entière de l’élement actuel
        plt.plot((xspline[i],xspline[i+1]),(yspline[i],yspline[i+1]),'b') #Et on trace le segment actuel soit en bleu
    else:
        plt.plot((xspline[i],xspline[i+1]),(yspline[i],yspline[i+1]),'r') #Soit en rouge


plt.show()


#Exercice 3
"Q:1"


def f(x):
    y=1/(1+25*x*x)
    return y

xspline = [x for x in np.arange(-1,1.1,0.01)]
yspline = [f(x) for x in xspline]

pointsx=[-1.+((i*1.)/5.) for i in range(11)]
pointsy=[f(-1.+((i*1.)/5.)) for i in range(11)]
plt.plot(xspline,yspline,'blue')
plt.scatter(pointsx,pointsy,c='black')


yy=[]
for idx in range(len(pointsx)):
    xp=pointsx[idx]
    yp=0
    for i in range(len(pointsx)):
        p=1
        for j in range(len(pointsx)):
            if j!=i:    
                p=p*((xp-pointsx[j])/(pointsx[i]-pointsx[j]))
        yp=yp+pointsy[i]*p
    yy.append(yp)
plt.plot(pointsx,yy,'red')
plt.plot()
plt.show()

print("La courbe en bleu est la fonction, la courbe en rouge est l’interpolation LAD")


print("Pour l’interpolation B-spline cubique")

k=3# Spline cubique
def f(x):
    y=1/(1+25*x*x)
    return y

pointsxx=[-1.+((i*1.)/5.) for i in range(11)]
pointsyy=[f(-1.+((i*1.)/5.)) for i in range(11)]
pointsx=[-1.+((i*1.)/5.) for i in range(11)]
pointsy=[f(-1.+((i*1.)/5.)) for i in range(11)]
u=[j for j in range(-k,len(pointsx)+k+1)] # on crée les noeuds
pointsx.insert(0,(-1.+((0*1.)/5.)))
pointsx.append((-1.+((10*1.)/5.)))
pointsy.insert(0,(f(-1.+((0*1.)/5.))))
pointsy.append(f(-1.+((10*1.)/5.)))
C = np.array([[0] * 13 for x in range(13)]) # on crée la matrice B de taille m+k
for i in range(len(C)): #on initialise la matrice B
    for j in range(len(C[i])):
        if i==j:
            C[i][j]=4
        elif i-j<2 and i-j>-2:
            C[i][j] =1
C=C.dot(0.166666667) # On multiplie la matrice B par 1/6 
B_inv=np.linalg.inv(C) # on l'inverse 
Q=[[pointsx[i],pointsy[i]] for i in range(len(pointsx))] # crée la matrice des points X et Y de la fonction
P=B_inv.dot(Q) #on calcule P 
Px=[P[x][0] for x in range(len(P))] # on prend la liste des X des points de controles 
Py=[P[x][1] for x in range(len(P))] # on prend la liste des Y des points de controles 

xspline=[bcurve(i,u,k,Px) for i in np.arange(0,10,0.1)] #on lisse la courbe des points de controle 
yspline=[bcurve(i,u,k,Py) for i in np.arange(0,10,0.1)]

plt.plot(xspline,yspline,'blue') # on affiche la courbe 
plt.scatter(pointsxx,pointsyy,c='blue') # on affiche les points 
plt.show()

print("On remarque que l’interpolation par une coubre Spline cubique est beaucoup plus fidèle a la fonction  que l’interpolation LAD")



