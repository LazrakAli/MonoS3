package classDonne;

public class TestSimulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulation s = new Simulation(10, 20);//5 bucherons et 5 ouvriers, 20 arbres 
		
		// s.afficherTerrain();
		while(s.recoltes()) {//Faire des recoltes juqu'a couper toutes les arbres du terrain.
			s.production();
			s.afficherTerrain();
			s.afficherStat();
		}
		s.afficherTerrain();
		s.production();
		s.recoltes();
	}
}

