public class Vache extends APattes{
    private int Quantite_Lait;
    private final String son="Meuhhhh";

    public Vache(int age){
        super("Vache",age,4);
        Quantite_Lait=((int) (Math.random()*51));
    }

    public Vache(){
        super("Vache",4);
        Quantite_Lait=((int) (Math.random()*51));
    }

    public void crier(){
        System.out.println(son);
    }

    public String toString(){
        return super.toString()+" produit_hebdomadaire "+Quantite_Lait+"L";
    }
}