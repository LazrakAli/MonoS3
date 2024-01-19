public class Guitare extends Instrument{
    private String type="classique";

    public Guitare(int poids,int prix){
        super(poids,prix);
    }

    public String toString(){
        return "Guitare  "+type+" "+super.toString();
    }

    public void jouer(){
        System.out.println("La guitare "+type+" joue");
    }
}