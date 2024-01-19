import java.util.ArrayList;

public abstract class Logement {
    protected double loyer;
    protected double charges;
    protected ArrayList<Piece> pieces=new ArrayList<Piece>();

    public void ajouterPiece(Piece p){
        pieces.add(p);
    }


    public abstract void setLoyer(double l);

    public abstract void setCharges(double l);
    
    public String toString(){
        return "(loyer : ["+loyer+"], charge : ["+charges+"])";
    }
}