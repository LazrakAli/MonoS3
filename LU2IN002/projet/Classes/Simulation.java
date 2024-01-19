package classDonne;

public class Simulation {
	
	private Terrain terrain;         //La foret 
	private Ressource[] ressourcesProduits;  //Les meubles produits par l'usine 
	private int indexMeubles = -1;
	private Bucheron[] bucherons;    //Les bucherons qui travaillent pour recolter du bois
	
	public Simulation(int n,int m) {
		// n : represente le nombre des agents et m represente le nombre de ressources .
		super();
		int posx,posy,i = 0;
		terrain = new Terrain(5, 6);  //Terrain 5*6
		bucherons = new Bucheron[n/2];  
		Usine.setOuvriers(new Ouvrier[n/2]);
		ressourcesProduits = new Ressource[100];//Nombre maximum que l'usine peut produire.

		while(i < m) { // place aleatoirement m ressources sur le terrain
    
			//Coordonnee de la case ou inserer la ressource .
			posx = (int)(Math.random()*5);
			posy = (int)(Math.random()*6);
			if(terrain.caseEstVide(posx, posy)) {//Boucler jusqu'a trouver une case vide				
				//la quantit� des pieces de bois dans chaque arbre (Ressource) est entre 10 et 30 pieces 
				terrain.setCase(posx, posy, new Ressource("Bois", (int)(Math.random()*20)+10));
				i++;
			}
		}
		i = 0;
		while(i < n/2){//genere n agents dans des positions differentes dans le terrain .
			//n/2 bucherons et n/2 ouvriers
			//generer des bucherons
			posx = (int)(Math.random()*5);
			posy = (int)(Math.random()*6);
			
			if(!terrain.caseEstVide(posx, posy)) {
				//Un bucherons va a une case qui n'est pas vide au debut
				if(i == 0 ) {
					bucherons[i] = new Bucheron(posx, posy);
					i++;				
				}else {
					bucherons[i] = new Bucheron(posx, posy);
					if(bucherons[i].distance(bucherons[i-1].getX(),bucherons[i-1].getY() ) > 1 ) {
						/*
						Pour bien distribuer les agents sur le terrain ,Il faut que l'espace entre
						2 bucherons soit au moins superieur a 1 CAD : une case entre 2 bucherons.    
						*/
						bucherons[i] = new Bucheron(posx, posy);
						i++;
					}
				}
			}
	
		}
		i = 0;
		while(i < n/2) {
			//generer des ouvriers
			Usine.getOuvriers()[i] = new Ouvrier();
			i++;
		}
		i = 0;
		while(i < n/4) {
			//generer des apprentis
			Usine.getOuvriers()[i] = new Apprenti();
			i++;
		}
	}
	
	public boolean recoltes() {
	/*Role : oblige les bucherons a commence leur travail ;
	 * Retourne false si le terrain est vider completement du bois ;true sinon
	 */
		Usine.setBoisParRecolte(0); //Initialiser le nombre de pieces de bois par recote (On vient de commencer une nouvelle).
		for(Bucheron b : bucherons) {//Les bucherons commencent a regrouper du bois
			
			if(terrain.caseEstVide(b.getX(), b.getY())) {//si le bucheron se trouve dans une case vide,il doit se declacer
				if(!b.changerCase(terrain)) { 
					System.out.println("Le terrain ne contient aucune arbre !");
					return false;
				}
			}else { //il est pret a recolter.
				if(!b.recolter(terrain.getCase(b.getX(),b.getY()))) {//Si elle donne faux, Le bucheron doit changer la case
					//CAD : le bucheron a pris tous le bois de la case,il faut la vider donc.
					terrain.videCase(b.getX(), b.getY());   //Enlever la case du terrain .
				}
			}
		}
		return true;
	}
	public void production() {
		Ressource[] r;
		int length ;
		Usine.produire();
		length = Usine.getIndexMeubles();
		r = Usine.exporter(); //Meubles produits
		for(int i = indexMeubles+1 ; i <= indexMeubles+length;i++) {
			ressourcesProduits[i] = r[i-indexMeubles-1]; //les mettre en stock.
		}
		indexMeubles += length+1;
	}
	public void afficherTerrain() {
		terrain.affiche();
	}
	
	public void afficherStat() {
		System.out.println("Statisqtique de la recolte et de la production :");
		System.out.println("Pandant cette recolte:\nLes bucherons on recolter :"+Usine.getBoisParRecolte()+" Pi�ces de bois.");
		System.out.println("Et l'usine a fabrique et a exporte :"+Usine.getNbMeubleParRecolte()+" Pieces de meuble.");
		System.out.println("Nombre totale des meubles en stock :"+(indexMeubles+1)+" Pieces de Meuble.");
		System.out.println("Nombre de pieces de bois qui reste en stock : "+(Usine.getBois()));
		
	}
	
	
}
