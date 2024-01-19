
public class Coureur{
	private int numDossard;
	private double tempsAu100;
	private boolean possedeTemoin;
	
	public Coureur(int Doss) {
	this.numDossard=Doss;
	tempsAu100=12+(Math.random()*4);
	possedeTemoin = false;
	}
	public Coureur() {
	this((int) (1+Math.random()*999));
	}

	public int getNumDossard() {
	return numDossard;}
	
	public double getTempsAu100() {
	return tempsAu100;
	}
	
	public void getPossedeTemoin(boolean b) {
	if (b) 
		b=false ;
	b=true;
	}
	
	public boolean setPossedeTemoin() {
	return possedeTemoin;
	}
	
	public void passeTemoin(Coureur c) {
	System.out.println("moi,coureur: "+numDossard+", je passe le témoin au coureur: " +c.getNumDossard());
	}
	
	public void courir() { 
	System.out.println("je suis le coureur " +numDossard+" et je cours");
	}
	
	public String toString() {
	return "Coureur: "+numDossard+" TempsAU100 : "+tempsAu100+" possedeTemoin: " + possedeTemoin+"\n";}
	
}
	
