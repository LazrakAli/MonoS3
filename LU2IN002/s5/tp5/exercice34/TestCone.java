public class TestCone{
    public static void main(String[] args){
        System.out.println(Cone.getNbCones());
        Cone c=new Cone();
        Cone c1=new Cone(3,5);
        System.out.println(c.toString());
        System.out.println(c1.toString());
        System.out.println(Cone.getNbCones());
    }
}