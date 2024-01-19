
public class TestCoureur{
	public static void main(String[] argv) {
	Coureur c1 = new Coureur(891);
	Coureur c2 = new Coureur(991);
	Coureur c3 = new Coureur();
	Coureur c4 = new Coureur();
	

	c1.courir();
	c1.passeTemoin(c2);
	
	
	
	c2.courir();
	c2.passeTemoin(c3);

	
	
	c3.courir();
	c3.passeTemoin(c4);
	
	
	c4.courir(); 
		
	
	double r=c1.getTempsAu100()+c2.getTempsAu100()+c3.getTempsAu100()+c4.getTempsAu100();
	System.out.println("Notre temps est de "+r+"s");
	}
}
