public class Maison extends Logement{
    private double surfaceTerrain;
    private String addresse;

    public Maison(double sT,String ad){
        if (sT<5)
            surfaceTerrain=0;
        else 
            surfaceTerrain=sT;
        addresse=ad;
    }

    public void setLoyer(double l){
        loyer=l;
    }

    public void setCharges(double l){
        charges=l;
    }
    
    public double SurfaceTotal(){
        double r=surfaceTerrain;
        for (Piece p : super.pieces){
            r+=p.getSurface();
        }
        return r;
    }

    public String toString(){
        if (surfaceTerrain!=0)
            return "Maison situe au ["+addresse+"] de ["+SurfaceTotal()+"] m2  {sur terrain de ["+surfaceTerrain+"] m2}"+super.toString();
        else 
            return "Maison situe au ["+addresse+"] de ["+SurfaceTotal()+"] m2 "+super.toString();
    }
}