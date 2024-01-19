public class TestProjet{
    public static void main(String[] args){

        System.out.println("Nous avons créé(s) "+Personne.getNbPersonnes()+" Personne(s)");
//-----------------------------------------------------
        Personne p1=new Personne();
        Personne p2=new Personne();
        Projet prj=new Projet("P3X-774");
//-----------------------------------------------------
        Projet prj1=new Projet("P3R-233");

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(prj.toString());
        System.out.println(prj1.toString());
        System.out.println(Trio.getNbTrio());
        System.out.println(Projet.getNbProjet());
        System.out.println("Nous avons cree(s) "+Personne.getNbPersonnes()+" Personne(s)");
    }
}