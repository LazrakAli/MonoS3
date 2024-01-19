public class SansMoteur extends Vehicule{

    public SansMoteur(String marque){
        super(marque);
    }

    public String toString(){
        return super.toString()+" sans moteur";
    }

    public void rouler(double distance){
        Dparcourue+=distance;
        System.out.println(toString()+" a roulé "+distance+"km");
    }
}