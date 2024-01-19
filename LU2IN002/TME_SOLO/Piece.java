public class Piece{
    private String description;
    private double surface;

    public Piece(String desc,double srf){
        description=desc;
        surface=srf;
    }

    public Piece(String desc){
        this(desc,0);
    }

    public String getDesc() {return description;}
    public double getSurface(){return surface;}
}