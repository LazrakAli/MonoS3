package EX52;
public class ChampignonToxic extends Champignon implements Toxic{
    private String nom;
    private double Poids;

    public ChampignonToxic(String nom){
        super(nom);
    }

    public double getPoids(){
        return Poids;
    }

    public String toString(){
        return nom+" "+Poids+"kg";
    }
}
