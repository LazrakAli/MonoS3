public class Machin{
    private String nom;
    private int valeur;

    public Machin(String nom,int valeur){
        this.nom=nom;
        this.valeur=valeur;
    }
    public Machin(String nom){
        this(nom,(int)(Math.random()*21));
    }

    public Machin(){
        this("Unamed Machine",(int)(Math.random()*21));
    }

    public String toString(){
        return nom+" "+valeur;
    }
}