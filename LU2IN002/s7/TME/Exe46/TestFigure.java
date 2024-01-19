import java.util.ArrayList;

public class TestFigure{
    public static void main(String[] args){
        ArrayList<Figure2D> tab=new ArrayList<Figure2D>();
        tab.add(new Cercle(2));
        tab.add(new Ellipse(2,3));
        tab.add(new Rectangle(5,2));
        tab.add(new Carre(3));

        for (Figure2D f : tab ){
            System.out.println(f.getClass());
            System.out.println("surface "+f.surface());
            System.out.println("perimetre "+f.perimetre());
            System.out.println("\n");
        }
    }
}