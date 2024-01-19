package classDonne;

public class Bucheron extends Agent{
	private int x;      //Position X
	private int y;		//Position Y
	private int boisPorte; 
	private int capaciteBoisMax; //Le nombre de pieces de bois qu'un bucheron peut porter .
	public Bucheron(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		boisPorte = 0;
		capaciteBoisMax = (int)(Math.random()*10)+5;  //La capacite de porter differe
	}

	public double distance(int x,int y) {
		return Math.sqrt( Math.pow( this.x - x,2) + Math.pow(this.y - y, 2));
	}
	
	public void seDeplacer(int xnew,int ynew) {
		x = xnew;
		y = ynew;
	}
	
	public boolean recolter(Ressource r) {
		/*
		Role : un boucheron recolte le bois d'une resource de type bois r (Arbre),
		 . il s'arrete quand on aura plus de bois dans la case ,ou  quand il recolte sans maximum,
		 . il doit deposer ce qu'il a coupe au niveau du stock de l'usine .
		 . la methode retourne false si la ressource R est vide ,true sinon
		 */
		
		 if(boisPorte + r.getQuantite() >= capaciteBoisMax) { 
			 r.setQuantite(r.getQuantite() - capaciteBoisMax + boisPorte); //Recolter jusqu'arriver a leur maximum
			 boisPorte = capaciteBoisMax;
			 deposerBois();
			 if(r.getQuantite() == 0)
				 return false;
			 
			 return true;
		 }else {
			 boisPorte += r.getQuantite();
			 r.setQuantite(0);
			 deposerBois();
			 return false;
		 }
	}
	public boolean changerCase(Terrain terrain){
		/*Role : Quand la case est vide , le bucheron doit chager la case ,
		 . 	 la methode retourne true s'il trouve une autre case , false sinon (terrain vide)
			principe : elle parcoure les cases qui entourent la case ou se trouve le bucheron
		 	et cherche s'il ya une case libre pour se declacer vers elle, sinon le rayon de la recherche augmente
		 	et comme a on couvre tous le terrain. 
		 */
		int c = terrain.nbColonnes;
		int l = terrain.nbLignes;
		int a,b,d,e,res = 0;
		int r = 1; //le rayon du cercle de recherche 
		while( r < c || r < l ) {
			//tracer les cordonnees du carre qui entoure la case en fonction du r

			if( x - r >= 0 ) 
				a = x - r;
			else 
				a = 0;

			if(x + r < l) 
				b = x + r;
			else
				b = l-1;

			if(y - r >= 0)
				d = y-r;
			else
				d = 0;

			if(y + r < c)
				e = y+r;
			else
				e = c-1;

			for(int i = a;i <= b;i++) {
				if(terrain.getCase(i,d)!=null) {
					if(!terrain.caseEstVide(i,d)) {
						seDeplacer(i, d);
						return true;
					}
				}
				if(terrain.getCase(i, e)!=null) {
					if(  !terrain.caseEstVide(i,e)) {
						seDeplacer(i, e);
						return true;
					}
				}
			}
			for(int j = d;j <= e;j++) {
				if(terrain.getCase(a, j)!=null ) {
					if( !terrain.caseEstVide(a,j)) {
						seDeplacer(a, j);
						return true;
					}
				}
				if(terrain.getCase(b, j)!=null) {
					if(  !terrain.caseEstVide(b,j)) {
						seDeplacer(b, j);
						return true;
					}
				}
			}
			r++;
		}
		return false;
	}
	
	public void deposerBois() {
		/*
		Role : Quand l'agent atteint sa capacite maximume de porter du bois ,
		il faut qu'il depose ce qu'il a recolte dans le stock de l'usine . 
		 */
		Usine.setBois(Usine.getBois() + boisPorte);//Stock general		
		Usine.setBoisParRecolte(Usine.getBoisParRecolte() + boisPorte); //Bois recolter durant une seule recolte
		boisPorte = 0;
	}
	//Seters et geters 
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
