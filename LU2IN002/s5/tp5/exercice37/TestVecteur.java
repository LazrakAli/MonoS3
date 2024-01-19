public class TestVecteur
{
    public static void main(String[] args)
    {
        Vecteur v1 = new Vecteur();
        Vecteur v2 = new Vecteur();

        System.out.println(v1.Somme(v2));
        System.out.println(Vecteur.Somme(v1, v2));

        
    }
}