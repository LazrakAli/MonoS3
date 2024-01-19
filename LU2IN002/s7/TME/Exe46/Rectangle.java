public class Rectangle extends Figure2D{
    protected double longueur;
    protected double largeur;

    public Rectangle(double lo,double la){
        longueur=lo;
        largeur=la;
    }

    public double surface(){
        return longueur*largeur;
    }

    public double perimetre(){
        return longueur*2+largeur*2;
    }
}