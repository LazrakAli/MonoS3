

public class TestVillageois {
	public static void main (String[] args) {
		Villageois v1= new Villageois("Ali");
		Villageois v2= new Villageois("Amine");
		Villageois v3= new Villageois("Théo");
		Villageois v4= new Villageois("Nathan");
		
		double d = v1.poidsSouleve()+v2.poidsSouleve() + v3.poidsSouleve()+v4.poidsSouleve();
		
		boolean t = d>=100;
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		if (t)
			System.out.println("Le rocher peut etre deplacé");
		else 
			System.out.println("Il ne pourrat pas etre déplacé");
	}
}
