package EX52;
import java.util.ArrayList;

public class Foret{
    private Object[][] tableau;

    public Foret(int n){
        //Terrain carre
        tableau = new Object[n][n];
    }

    boolean placer(Object b){
        int x=(int)(Math.random()*(tableau.length));
        int y=(int)(Math.random()*(tableau.length));
        if (tableau[x][y]==null){
            tableau[x][y]=b;
            return true;
        }
        return false;
    }

    ArrayList<Champignon> ramasserChampignons(){
        ArrayList<Champignon> champ=new ArrayList<Champignon>();
        for(int i=0;i<tableau.length;i++){
            for(int y=0;y<tableau.length;y++){
                if (tableau[i][y] instanceof Champignon){
                    champ.add((Champignon)tableau[i][y]);
                    tableau[i][y]=null;
                }
            }
        }
        return champ;
    }

    ArrayList<Object> ramasserTout(){
        ArrayList<Object> champ=new ArrayList<Object>();
        for(int i=0;i<tableau.length;i++){
            for(int y=0;y<tableau.length;y++){
                if (tableau[i][y] instanceof Ramassable && !(tableau[i][y] instanceof Toxic)){
                    champ.add(tableau[i][y]);
                    tableau[i][y]=null;
                }
            }
        }
        return champ;
    }


    public String toString(){
        String s="";
        for (int i=0;i<tableau.length;i++){
            s+="|";
            for(int y=0;y<tableau.length;y++){
                if(tableau[i][y]==null)
                    s+=" ";
                else
                    s+=tableau[i][y].toString().charAt(0);
            }
            s+="|\n";
        }
        return s;
    }

    public void ramasser(Panier p){		
		for(int i=0 ; i<tableau.length ; i++) {
			for (int j=0 ; j<tableau.length ; j++) {
				Object obj = tableau[i][j];
				if(obj == null) {continue;}
				if(obj instanceof Ramassable) {
					p.add((Ramassable)obj);
					System.out.println(p);
				}
			}
		}
	}

}