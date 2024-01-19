public class Ellipse extends Figure2D{
    protected double longueur_a;
    protected double longueur_b;

    public Ellipse(double a,double b){
        longueur_a=a;
        longueur_b=b;
    }

    public double surface(){
        return Math.PI*longueur_a*longueur_b;
    }

    public double perimetre(){
        return Math.PI*2*Math.sqrt((longueur_a*longueur_a+longueur_b*longueur_b)/2);
    }
}