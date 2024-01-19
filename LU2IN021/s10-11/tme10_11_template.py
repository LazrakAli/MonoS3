import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
from matplotlib import cm

#dessine le graphe d'une fonction f à une variable, entre les bornes x=vmin et x=vmax, avec title une chaîne de caractères correspondant
#au titre donné à la figure
def graph(f,vmin,vmax,title):  
	x = np.arange(vmin,vmax,0.01)
	y = f(x) 
	plt.plot(x, y) 
	plt.title(title) 
	plt.show() 

#dessine la surface représentative d'une fonction f à deux variables, entre les bornes x=vmin,y=vmin et x=vmax,y=vmax 
#dessine également les courbes de niveaux de f
def surface(f,vmin,vmax):
	fig = plt.figure(figsize=(8,8))
	ax = fig.add_subplot(111, projection='3d')
	x = y = np.arange(vmin, vmax, 0.01)
	X, Y = np.meshgrid(x, y)	
	zs = np.array([f(x,y) for x,y in zip(np.ravel(X), np.ravel(Y))])
	Z = zs.reshape(X.shape)
	surf=ax.plot_surface(X, Y, Z,cmap=cm.coolwarm,linewidth=0, antialiased=False)

	ax.set_xlabel('x')
	ax.set_ylabel('y')
	ax.set_zlabel('f(x,y)')

	fig.colorbar(surf, shrink=0.5, aspect=5)
	plt.title("surface représentative") 
	plt.show()
	
	plt.contour(X,Y,Z,20)	
	plt.title("courbes de niveaux")
	plt.show()

#f1
def f1(x):
	return -2*np.exp(-(x+1)**2)

#f2
def f2(x):
	return (1/4)*x**4-2*x**2+x
#f3
def f3(x):
	return 0.5*x**2-3*x*(np.log(x)-1)
#f4
def f4(x,y):
	return np.exp(x+y)+x*x+y*y

#fonction Newton à une variable 
def Newton(f,fP,fPP,x,EPS):
	return 

#Hessienne de f4
def Hessiennef4(x,y):
	return

#Gradient de f4
def Gradientf4(x,y):
	return 

#fonction Newton à deux variables
def Newton2Var(f,Gradient,Hessienne,x,y,EPS):
	return

#fonction Gradient à deux variables
def Gradient2Var(f,Gradient,x,y,EPS,alpha):
	return




