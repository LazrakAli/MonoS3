
public class Villageois {
	private String nom;
	private double poids;
	private boolean malade;
	
	public Villageois(String nomVillageois) {
	
	this.nom = nomVillageois;
	this.poids = (Math.random()*100)+50;
	this.malade = (Math.random()*100 <= 20);
	}
	
	public String getNom() {
	return nom;
	}
	
	public double getPoids() {
	return poids;
	}
	
	public boolean getMalade() {
	return malade;
	}
	
	public double poidsSouleve() {
	if (malade)
		return (poids/4) ;
	else 
		return (poids/3) ;
	}
		
	
	
	public String toString() {
	if (malade)
		return "nom:"+ nom + ", poids:" + String.format("%.2f",poids) + ", malade:"+"oui" +  ", peut soulever:"+String.format("%.2f",poidsSouleve()) +'\n';
	else 
		return "nom:"+ nom + ", poids:" + String.format("%.2f",poids) + ", malade:"+"non" +  ", peut soulever:"+String.format("%.2f",poidsSouleve()) +'\n';
	}
}
