public class Cone {
    private double r;
    private double h;
    private final double PI=3.14159;
    private static int nbCones=0;

    public Cone(double r, double h){
        this.r=r;
        this.h=h;
        nbCones++;
    }

    public Cone(){
        this((0.1+Math.random()*10),(0.1+Math.random()*10));
    }

    public double getVolume(){
        double V=(1/3d)*PI*(r*r)*h;
        return V;
    }

    public String toString(){
        return String.format("Cone r=%.3f h=%.3f V=%f",r,h,getVolume());
    }

    public static int getNbCones(){
        return nbCones;
    }

}