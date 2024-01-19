package classDonne;

public class Agent {
	protected static int id;
	protected String nom;
	protected String age;
	protected int nassurance;
	
	public Agent() {
		id++;
	}

	
	public Agent(String nom, String age, int nassurance) {
		super();
		nom = nom;
		this.age = age;
		nassurance = nassurance;
		id++;
	}


	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Agent.id = id;
	}

	
	
	
}
