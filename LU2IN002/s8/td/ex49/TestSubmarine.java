public class TestSubmarine {
    public static void main(String[] args) {
        Ocean oc=new Ocean();
        oc.ajouter(new Merlu());
        oc.ajouter(new Dauphin());
        oc.ajouter(new SousMarin());

        oc.deplacer();
        
    }
}
