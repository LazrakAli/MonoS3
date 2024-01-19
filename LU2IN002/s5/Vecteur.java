public class Vecteur {
    private double x,y,z;
    public Vecteur(double x, double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public Vecteur(Vecteur v1, Vecteur v2){
        this(v1.x+v2.x,v1.y+v2.y,v1.z+v2.z);
    }

    public Vecteur(){
        this(Math.random()*10,Math.random()*10,Math.random()*10);
    }

    public Vecteur SommeDe2Vecteur(Vecteur v1, Vecteur v2){
        Vecteur v= new Vecteur(v1,v2);
        return v;
    }

    public String toString() {
        return "(" +x+ ", " +y+", " +z+ ")";
    }
}