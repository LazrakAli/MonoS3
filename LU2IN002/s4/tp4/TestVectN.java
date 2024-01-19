public class TestVectN{
    public static void main(String[] args){
        VectN v1=new VectN();
        VectN v2=new VectN(1,2,3);
        VectN v3=new VectN(7,15);


        //teste de l'affichage des Vecteur sous le format voulue
        System.out.println("v1="+v1.toString());
        System.out.println("v2="+v2.toString());
        System.out.println("v3="+v3.toString());
        //teste de la fonction somme 
        System.out.println("la somme de v3 est :"+v3.Somme());
        //teste de l'acceseur (le probleme est que l'acceseur n'alloue pas un nouveau tableau )
        VectN vect=new VectN(4,5,6) ;
        int []tab=vect.getTab();
        tab [0]=100;
        System.out.println(vect);
    }
}