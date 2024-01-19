public class TestOrchestre{
    public static void main(String[] args){
        Piano p=new Piano(300,700);
        Guitare g=new Guitare(2,180);

        Orchestre o=new Orchestre(2);
        o.ajouterInstrument(p);
        o.ajouterInstrument(g);
        
        //41.5)A.dans le code actuel il n'y a pas de methode jouer dans l'instrument 
        o.jouer();
        //41.5)B.car il y'a une redefinition de la methode dans les fils de instument

        //41.6)nous devons modifier aucune class seulement en ajouter
    }   
}