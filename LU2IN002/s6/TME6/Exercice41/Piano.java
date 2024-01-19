public class Piano extends Instrument{
    private final int nbTouches=88;

    public Piano(int poids,int prix){
        super(poids,prix);
    }

    public String toString(){
        return "Piano 88 touches "+super.toString();
    }
    public void jouer(){
        System.out.println("Le piano "+nbTouches+" touches joue");
    }
}