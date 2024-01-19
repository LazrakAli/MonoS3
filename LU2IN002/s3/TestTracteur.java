

public class TestTracteur {
	public static void main(String[] args){
		Roue gr1= new Roue(120);
		Roue gr2= new Roue(120);
		Roue gr3= new Roue();
		Roue gr4= new Roue();
		
		Cabine c1 = new Cabine(3,"bleu");
		System.out.println(""+gr1+c1);
		c1.setCouleur("rouge");
		
		System.out.println(""+gr1+c1);
		}
}

