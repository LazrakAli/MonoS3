public class Projet{
    private final String nom;
    private final Trio trio;
    private static int cpt=0;

    public Projet(String nom){
        this.nom=nom;
        trio=new Trio();
        cpt++;
    }

    public static String getNbProjet(){
        return "Nous avons créé(s) en tout "+cpt+" Projet(s)";
    } 

    public String toString(){
        return "Projet "+nom+" "+trio.toString();
    }
}