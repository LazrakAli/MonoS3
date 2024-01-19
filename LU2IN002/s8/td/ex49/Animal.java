public abstract class Animal{
    private String nom;
    private int age;


    public Animal(String n,int age){
        nom=n;
        this.age=age;

    }

    public Animal(String n){
        this(n,1);
    }

    public abstract void crier();

    public void vieillir(){
        age++;
    }
    
    public String toString(){
        return "nom:"+nom+" age:"+age;
    }
}