public class Trio{
    Personne[] trio=new Personne[3];
    public static int compteur=0;
    public int numero;

    public Trio(){
        compteur++;
        numero=compteur;
        for (int i=0;i<trio.length;i++)
            trio[i]=new Personne();
    }

    public static String getNbTrio(){
        return "Nous avons créé(s) en tout "+compteur+" Trio(s)";
    }

    public String toString(){
        String cr="Trio "+numero+ " : ";
        for (Personne y : trio)
            cr+=y+" ";
        return cr;
    }
}