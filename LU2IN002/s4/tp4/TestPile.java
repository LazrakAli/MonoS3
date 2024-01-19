public class TestPile{
    public static void main(String[] args){
        Pile p1=new Pile(3);
        Machin m1=new Machin("Machin1");
        Machin m2=new Machin("Machin2");
        Machin m3=new Machin("Machin3");
        Machin m4=new Machin("Machin4");
        Machin m5=new Machin("Machin5");

        p1.empiler(m1);
        p1.empiler(m2);
        p1.empiler(m3);
        System.out.println(p1.toString());
        p1.depiler();
        p1.empiler(m4);
        p1.empiler(m5);
        System.out.println(p1.toString());
        p1.depiler();
        p1.depiler();
        p1.depiler();
        p1.depiler();
        System.out.println(p1.toString());
    }
}