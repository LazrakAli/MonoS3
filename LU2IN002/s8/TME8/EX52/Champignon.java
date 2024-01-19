package EX52;

public class Champignon implements Ramassable{
    private String nom;
    private double Poids;

    public Champignon(String nom){
        this.nom=nom;
        Poids=Math.random()*3;
    }

    public double getPoids(){
        return Poids;
    }

    public String toString(){
        return nom+" "+Poids+"kg";
    }
}