public class Test{
	public static void main(String[] args){
		Terrain t=new Terrain(10,15);
		t.setCase(3,5,new Ressource("Bois",10));
		t.affiche(1);

		int cpt=0;
		for (int i=0;i<t.nbLignes;i++){
			for(int j=0;j<t.nbColonnes;j++){
				if (!t.caseEstVide(i,j)){
					System.out.println(t.getCase(i,j));
					cpt+=t.getCase(3,5).getQuantite();
				}
			}
		}

		System.out.println("quantite totale de bois "+cpt);
		t.videCase(3,5);
		t.affiche(1);
	}
}