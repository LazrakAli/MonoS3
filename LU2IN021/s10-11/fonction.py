from tme10_11_template import *
from pulp import *



#f1'(x)
def fprime1(x):
    return 4*x+4*np.exp(-(x+1)**2)

#f2'(x)
def fprime2(x):
    return (x**3)-4*x+1

#f3'(x)
def fprime3(x):
    return x-3/x

#f1''(x)
def fseconde1(x):
    return 4*np.exp(-(x+1)**2)+(-2*x-2)*np.exp(-(x+1)**2)*(4*x+4)

#f2''(x)
def fseconde2(x):
    return 3*(x**2)-4

#f3''(x)
def fseconde3(x):
    return 1+3/x**2

#graph(fprime1,-3,3,"derivée de la fonction1")
#graph(fprime2,-1,1,"derivée de la fonction2")
#graph(fprime3,0,5,"derivée de la fonction3")


##EXERCICE:2
#fonction Newton à une variable 
def Newton(f,fP,fPP,x,EPS):
    cpt=0
    xk=x
    while(np.abs(fP(xk))>=EPS):
        if (fPP(xk)!=0):
            xkplus1=xk-fP(xk)/fPP(xk)
            xk=xkplus1
            cpt+=1
        else :
            print("la methode de newton echoue")
            exit()
    return (cpt,xk,fP(xk))
#(a,b,c)=Newton(f1,fprime1,fseconde1,-1,0.001)
#print(a,b,c)
#(d,e,f)=Newton(f2,fprime2,fseconde2,0,0.001)
#print(d,e,f)
#(i,j,k)=Newton(f3,fprime3,fseconde3,1.5,0.001)
#print(i,j,k)



##EXERCICE:3


#surface(f4,-2,2)

#gradient de la fonction f4 en un point (x,y) 
def Gradientf4(x,y):
    return np.array([np.exp(x+y)+2*x,np.exp(x+y)+2*y])


#Hessiennne de la fonction f4 en un point (x,y)
def Hessiennef4(x,y):
    M= [[2+np.exp(x+y),np.exp(x+y)],[np.exp(x+y),2+np.exp(x+y)]]
    return np.array(M)


##Exercice 4

#retourne la distance 2 points (x,y) et (x1,y1)
def Distance(x,y,x1,y1):
    return np.sqrt((x-x1)**2+(y-y1)**2)

def Newton2Var(f,Gradient,Hessienne,x,y,EPS):
    cpt=1
    Xk=[x,y]
    Xkplus1=np.linalg.solve(Hessienne(Xk[0],Xk[1]),-Gradient(Xk[0],Xk[1]))+Xk
    
    #critere d'arret la distance entre ||Xk+1-Xk|| est inferieur a epislone
    while(Distance(Xkplus1[0],Xkplus1[1],Xk[0],Xk[1])>EPS):
        Xk=Xkplus1
        Xkplus1=np.linalg.solve(Hessienne(Xk[0],Xk[1]),-Gradient(Xk[0],Xk[1]))+Xk
        cpt+=1
    return (cpt,Xkplus1,f(Xkplus1[0],Xkplus1[1]))

#On prend le meme valeur pour episole que la question 2.2
#(a,b,c)=Newton2Var(f4,Gradientf4,Hessiennef4,4,5,0.001)
#print(a,b,c)



##Exercice 5:

def Gradient2Var(f,Gradient,x,y,EPS,alpha):
    X=[x,y]
    cpt=0
    D=-Gradient(X[0],X[1])
    while(Distance(D[0],D[1],0,0)>EPS):
        X+=alpha*D
        cpt+=1
        D=-Gradient(X[0],X[1])
    return (cpt,X,f(X[0],X[1]))

#(a,b,c)=Gradient2Var(f4,Gradientf4,2,1,0.001,0.4)
#print(a,b,c)


#Exercice 6:


file=open("./Base_apprentissage_Notes_Admis.dat",'r')
texte=file.readlines()
file.close()

x=[]
y=[]

for f in texte:
    a=f.split('   ')
    x.append(float(a[0]))
    y.append(float(a[1]))


file=open("Base_apprentissage_Notes_NonAdmis.dat",'r')
texte1=file.readlines()
file.close()

x1=[]
y1=[]

un=[i for i in range(1,41)]
deux=[i for i in range(41,81)]

for f in texte1:
    a=f.split('   ')
    x1.append(float(a[0]))
    y1.append(float(a[1]))
"""
plt.scatter(un,x,c='LightGreen',label='Admis teste 1')
plt.scatter(un,y,c='DarkGreen',label='Admis teste 2')
plt.scatter(deux,x1,c='red',label='Non Admis teste 1')
plt.scatter(deux,y1,c='DarkRed',label='Non Admis teste 2')
plt.title("Notes Concours")
plt.xlabel("élève")
plt.ylabel("notes sur 100 (2 notes par élève)")
plt.legend()
plt.show()
"""

#Exercice 7:

def sigmoide(z):
    return 1/(1+np.exp(-z))

def unMoinSigmoide(z):
    return 1-sigmoide(z)

def sigmoideAvecZnegatif(z):
    return 1/(1+np.exp(z))

def sigmoidePrime(z):
    return np.exp(-z)/(1+np.exp(-z))**2

def SigmoideFoisUnMoinSigmoide(z):
    return sigmoide(z)*unMoinSigmoide(z)

#graph(unMoinSigmoide,-10,10,"1-σ(z)")
#graph(sigmoideAvecZnegatif,-10,10,"σ(-z)")

#graph(sigmoidePrime,-10,10,"σ'(z)")
#graph(SigmoideFoisUnMoinSigmoide,-10,10,"σ(z)(1-σ(z))")


#Exercice 8:
    ## Sur feuille mis directement dans le pdf


#Exercice 9:

def f(X,THETA):
    (x1,x2)=X
    (a,b,c)=THETA
    return a+b*x1+c*x2

def fprime(X,i):
    X=(x,y)
    if (i<0 and i >2):
        print("Usage : fprime(Tuple[float,float], int i) avec 0<=i<=2")
        exit()
    elif (i==0):
        return 1
    elif(i==1):
        return x
    else: 
        return y

def F(THETA):
    p1=0
    p2=0
    for i in range(0,len(x)):
        X=(x[i],y[i])
        X1=(x1[i],y1[1])
        p1+=np.log(1+np.exp(-f(X,THETA)))
        p2+=np.log(1+np.exp(-f(X1,THETA)))
    return p1+p2


def Fprime(THETA,i):
    if i>2 or i<0:
        print("Usage : (Fprime(Tuple[float,float,float], int i) avec 0<=i<=2")
        exit()
    else:
        cpt1=0
        cpt2=0
        if (i==0):
            for i in range(0,len(x)):
                X=(float(x[i]),float(y[i]))#notes d'un eleve admis
                X1=(float(x1[i]),float(y1[i]))#notes d'un eleve admis
                cpt1+=-sigmoide(-f(X,THETA))*fprime(X,0)
                cpt2+=sigmoide(f(X1,THETA))*fprime(X1,0)
            return cpt1+cpt2
        elif(i==1):
            for i in range(0,len(x)):
                X=(float(x[i]),float(y[i]))#notes d'un eleve admis
                X1=(float(x1[i]),float(y1[i]))#notes d'un eleve admis
                cpt1+=-sigmoide(-f(X,THETA))*fprime(X,1)
                cpt2+=sigmoide(f(X1,THETA))*fprime(X1,1)
            return cpt1+cpt2
        else :
            for i in range(0,len(x)):
                X=(float(x[i]),float(y[i]))#notes d'un eleve admis
                X1=(float(x1[i]),float(y1[i]))#notes d'un eleve admis
                cpt1+=-sigmoide(-f(X,THETA))*fprime(X,2)
                cpt2+=sigmoide(f(X1,THETA))*fprime(X1,2)
            return cpt1+cpt2
    
def Fseconde(THETA,i,j):
    """derivée partielles seconde de F avec i et j les element a derivérée"""
    cpt1=0
    cpt2=0
    for p in range(0,len(x)):
        X=(float(x[p]),float(y[p]))#notes d'un eleve admis
        X1=(float(x1[p]),float(y1[p]))#notes d'un eleve admis
        cpt2+=sigmoide(f(X1,THETA))*(1-sigmoide(f(X1,THETA)))*fprime(THETA,i)*fprime(THETA,j)
        cpt1+=sigmoide(f(X,THETA))*(1-sigmoide(f(X,THETA)))*fprime(THETA,i)*fprime(THETA,j)
    return cpt1+cpt2


def GradientF(THETA):
    return np.array([Fprime(THETA,0),Fprime(THETA,1),Fprime(THETA,2)])


def HessienneF(THETA):
    Hess=[[Fseconde(THETA,0,0),Fseconde(THETA,0,1),Fseconde(THETA,0,2)],[Fseconde(THETA,0,1),Fseconde(THETA,1,1),Fseconde(THETA,1,2)],[Fseconde(THETA,0,2),Fseconde(THETA,1,2),Fseconde(THETA,2,2)]]
    return np.array(Hess)

def Distance3Var(X):
    X=(a,b,c)
    return np.sqrt(a**2+b**2+c**2)
    
def Newton3Var(f,Gradient,Hessienne,X,EPS):
    cpt=1
    Xk=X
    Xkplus1=np.linalg.solve(HessienneF(Xk),-G)+Xk
    
    #critere d'arret la distance entre ||Xk+1-Xk|| est inferieur a epislone
    while(Distance(XKplus1)>EPS):
        Xk=Xkplus1
        Xkplus1=np.linalg.solve(Hessienne(Xk),-Gradient(Xk))+Xk
        cpt+=1
    return (cpt,Xkplus1,F(Xkplus1))


#a=Newton3Var(F,GradientF,HessienneF,(0,0,0),0.001)
#print(a)
##Erreur multiple 
