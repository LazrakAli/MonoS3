public abstract class APattes extends Animal{
    private int nb_pattes;

    public APattes(String n,int age,int nbp){
        super(n,age);
        nb_pattes=nbp;
    }

    public APattes(String n,int nbp){
        super(n);
        nb_pattes=nbp;
    }
    public abstract void crier();
    public String toString(){
        return super.toString()+" nombres_de_pattes:"+nb_pattes;
    }
}