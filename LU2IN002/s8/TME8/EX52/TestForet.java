package EX52;


public class TestForet {

	public static void main(String[] args) {
		Foret f = new Foret(10);
		
		for(int i = 0 ; i<10 ; i++) {
			Object obj;
			double x = Math.random();
            if(x<=0.1)
				obj = new ChampignonToxic("Amanite");
            else if (x<=0.3)
				obj = new Champignon("Champigon");
            else
				obj = new Arbre("Pins");
			
			while(!f.placer(obj)) {}
		}
		
		System.out.println(f.toString());
		
		Panier p = new Panier(8);
		f.ramasser(p);

	}

}

