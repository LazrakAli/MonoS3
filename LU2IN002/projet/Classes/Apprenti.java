package classDonne;

public class Apprenti extends Ouvrier{
	/*Role : Apprendre le metier pour devenir ouvrier */
	private int experience = 0;

	public Apprenti() {
		super();
	}

	public Apprenti(String nom, String age, int nassurance, int capaciteTravail) {
		super(nom, age, nassurance, capaciteTravail);
	}
	public void produire() {
		/*L'apprenti ne fabrique pas des meubles ,il prend de l'experience */ 
		experience += 10;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
}
