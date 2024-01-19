

public class AdresseWeb{

	private String protocole;
	private String domaine;
	private String chemin;
	
	public AdresseWeb(String proto ,String dom , String chem) {
	this.protocole=proto;
	this.domaine=dom;
	this.chemin=chem;
	}
	
	
	public AdresseWeb( String dom, String chem) {
	this("http//",dom,chem);
	}
	
	public  AdresseWeb(String dom) {
	this("http//",dom,"/");
	}
	
	public String toString() {
	return protocole+domaine+chemin;
	}
}
