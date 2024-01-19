

public class Cabine {
	private int volume;
	private String couleur;
	
	public Cabine(int v,String Coul) {
		this.volume=v;
		this.couleur=Coul;
		} 
		
	public String setCouleur(String coul) {
		this.couleur=coul;
		return coul;
		}
		
	public String toString() {
		return "Volume :"+volume+ " Couleur :"+couleur;
		}
}
	
