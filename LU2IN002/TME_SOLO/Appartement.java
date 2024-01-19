public class Appartement extends Logement{
    private double surfaceBalcon;

    public Appartement(double srf){
        surfaceBalcon=srf;
    }

    public double SurfaceTotal(){
        double r=surfaceBalcon;
        for (Piece p : super.pieces){
            r+=p.getSurface();
        }
        return r;
    }

    public void setLoyer(double l){
        loyer=l;
    }

    public void setCharges(double l){
        charges=l;
    }

    public String toString(){
        if (surfaceBalcon!=0)
            return "Appartement de ["+SurfaceTotal()+"] m2 {avec balcon de ["+surfaceBalcon+"} m2}"+super.toString();
        else
            return "Appartement de ["+SurfaceTotal()+"] m2 "+super.toString();
    }
}