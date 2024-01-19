public class Instrument{
    private int poids,prix;

    public Instrument(int poids,int prix){
        this.poids=poids;
        this.prix=prix;
    }
    public void jouer(){
        System.out.println("L'instrument joue");
    }

    public String toString(){
        return "poids : "+poids+" kg, prix : "+prix+" euros";
    }
}