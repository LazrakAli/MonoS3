public class Personne{
    private String nom;
    private static int nbPersonnes=0;
    private static char lettre='A';

    public Personne(){
        nbPersonnes++;
        this.nom="Individu"+lettre;
        lettre++;
    }

    public static int getNbPersonnes(){
        return nbPersonnes;
    }

    public String toString(){
        return nom;
    }
}