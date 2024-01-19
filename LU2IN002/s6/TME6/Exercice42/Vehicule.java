public class Vehicule{
    protected final int imatricu;
    private static int cpt=0;
    private final String marque;
    protected int Dparcourue=0;

    public Vehicule(String Marque){
        this.marque=Marque;
        cpt++;
        imatricu=cpt;
    }


    public String toString(){
        return imatricu+" de marque "+marque;
    }
}