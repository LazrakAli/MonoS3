import java.utils.ArrayList;

public class Ocean {
    private ArrayList<Submarine> sub = new ArrayList<Submarine>();
    
    public void ajouter(Submarine S){
        sub.add(s);
    }

    public void deplacer(){
        for (Submarine s : sub)
            s.seDeplacer();
    }
}