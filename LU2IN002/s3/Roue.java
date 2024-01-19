

public class Roue {
	private int diametre;
	
	public Roue(int a) {
		this.diametre=a;
		}
	public Roue() {
		this(60);
		}
	public String toString() {
	return "la grande roue a un dimatre de "+diametre+"\n";
	}
}
