public class Vecteur{
    private double x,y,z;
    
    public Vecteur(double c1,double c2,double c3){
        x=c1;y=c2;z=c3;
    }
    public Vecteur(){
        this(Math.random()*10,Math.random()*10,Math.random()*10);
    }

    public Vecteur Somme(Vecteur v){
        return new Vecteur(this.x+v.x,this.y+v.y,this.z+v.z);
    }
    public static Vecteur Somme(Vecteur v1, Vecteur v2){
        return new Vecteur(v1.x+v2.x,v1.y+v2.y,v1.z+v2.z);
    }

    public String toString(){
        return "("+x+", "+y+", "+z+")";
    }
}