package classDonne;

public class Usine {
	private static Ressource[] meubles = new Ressource[100]; //a change
	private static int bois = 0;
	private static int nbMeubleParRecolte = 0;  //Nous aident dans l'affichage des statistiques
	private static int boisParRecolte = 0; 	 //Nous aident dans l'affichage des statistiques
	private static Ouvrier[] ouvriers ;
			
	public static void produire() {
		/*Role : Produire a l'aide des ouvriers des meubles en utilisons le bois en stock,
			     on suppose qu'il faut 10 pieces de bois pour produire un meuble.
		 */
		if(bois >= 10) {
			nbMeubleParRecolte = bois/10;
			for(int i = 0; i < ouvriers.length ; i++) {
					ouvriers[i].produire();
					if(ouvriers[i] instanceof Apprenti) {
						if(( (Apprenti)ouvriers[i]).getExperience() >= 100 )//pret a etre recruter.
							recruter((Apprenti)ouvriers[i], i); //Utilisation du cast
					}
			}

		}else {
			System.out.println("Production impossible : Bois insuffisant !");
		}
	}

	public static Ressource[] exporter() {
		/*Role : Exporter les meubles produits .*/
		Ressource[] r = meubles;
		indexMeubles = -1; //vider le stock
		return r;
	}
	
	public static void recruter(Apprenti a,int indice) {
		/*Recrute un apprenti et elle le rend un ouvrier */
		ouvriers[indice] = new Ouvrier(a);//Copier les information de l'apprenti ,et creer un ouvrier avec les memes informations
	}
	//Seters et geters

	public static int getIndexMeubles() {
		return indexMeubles;
	}

	public static void setIndexMeubles(int indexMeubles) {
		Usine.indexMeubles = indexMeubles;
	}

	public static int getBois() {
		return bois;
	}

	public static void setBois(int bois) {
		Usine.bois = bois;
	}

	public static int getNbMeubleParRecolte() {
		return nbMeubleParRecolte;
	}

	public static void setNbMeubleParRecolte(int nbMeubleParRecolte) {
		Usine.nbMeubleParRecolte = nbMeubleParRecolte;
	}

	public static int getBoisParRecolte() {
		return boisParRecolte;
	}

	public static void setBoisParRecolte(int boisParRecolte) {
		Usine.boisParRecolte = boisParRecolte;
	}

	public static Ressource[] getMeubles() {
		return meubles;
	}

	public static void setMeubles(Ressource[] meubles) {
		Usine.meubles = meubles;
	}

	public static Ouvrier[] getOuvriers() {
		return ouvriers;
	}

	public static void setOuvriers(Ouvrier[] ouvriers) {
		Usine.ouvriers = ouvriers;
	}
	
	
}
