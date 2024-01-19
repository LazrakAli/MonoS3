
public class Ouvrier extends Agent{
	protected int capaciteTravail;   //Nombre de pieces maximume de meuble fabrique par production.

	
	public Ouvrier(String nom, String age, int nassurance,int capaciteTravail) {
		super(nom, age, nassurance);
		this.capaciteTravail = capaciteTravail;
	}
	public Ouvrier(int capaciteTravail) {
		super();
		this.capaciteTravail = capaciteTravail;
	}
	public Ouvrier() {
		capaciteTravail = (int)(Math.random()*10)+5;  //La capacite de fabriquer differe
	}
	public Ouvrier(Ouvrier o) {
		//Constructeur par copie
		super.nom = o.nom;
		super.age = o.nom;
		super.nassurance = o.nassurance;
		capaciteTravail = o.capaciteTravail;
	}
	public void produire() {
		/*Role : fabriqu� des meubles en utilisant le bois
		 * retourne false si le Bois est insufisant, true sinon.
		 */
		if(Usine.getBois() >= 10) {
			while(Usine.getBois() >= 10 && Usine.getIndexMeubles() < capaciteTravail) {	
				//fabrication d'un meuble
				Usine.setBois(Usine.getBois() - 10);
				Usine.setIndexMeubles(Usine.getIndexMeubles()+1);
				Usine.getMeubles()[Usine.getIndexMeubles()] = new Ressource("Meuble", 1);
				
			}
		}//Sinon bois insuffisant .
		
	}
	public int getCapaciteTravail() {
		return capaciteTravail;
	}

	public void setCapaciteTravail(int capaciteTravail) {
		this.capaciteTravail = capaciteTravail;
	}
}
