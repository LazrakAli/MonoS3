public class TestVecteur{
    public static void main(String args[]){
        Vecteur v1=new Vecteur(1,2,3);
        Vecteur v2=new Vecteur(2,-1,4);
        Vecteur v=new Vecteur(v1,v2);
        Vecteur v3=Vecteur.SommeDe2Vecteur(v1,v2);
        System.out.println(v3.toString());
    }
}