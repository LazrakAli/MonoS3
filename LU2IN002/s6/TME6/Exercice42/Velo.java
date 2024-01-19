public class Velo extends SansMoteur{
    private int nbVitesse;

    public Velo(String mrq,int nbv){
        super(mrq);
        nbVitesse=nbv;
    }

    public String toString(){
        return "Vélo "+super.toString()+" 17 vitesses";
    }

    public void transporter(String depart,String arrivee){
        System.out.println("Le Vélo "+super.imatricu+" se deplace de "+depart+" à "+arrivee);
    }
}