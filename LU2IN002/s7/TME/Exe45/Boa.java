public class Boa extends SansPattes{
    private final String son="Ssssssss";

    public Boa(int age){
        super("Boa",age);
    }

    public Boa(){
        super("Boa");
    }

    public void crier(){
        System.out.println(son);
    }

    public String toString(){
        return super.toString();
    }
}