import java.util.ArrayList;

public class Menagerie{
    private ArrayList<Animal> tab;
    private int nb_animal=0;

    public Menagerie(){
        tab=new ArrayList<Animal>();
    }

    public void ajouter(Animal a){
        tab.add(a);
        nb_animal++;
    }

    public void midi(){
        for(Animal a: tab)
            a.crier();
    }

    public void vieillirTous(){
        for(Animal a:tab){
            a.vieillir();
        }
    }

    public String toString(){
        String n="";
        for(Animal a: tab){
            n+=a.toString()+"\n";
        }
        return n;
    }

//Methode Main------------------------------------------------------------

public static void main(String[] args){
    
    Menagerie m=new Menagerie();
    m.ajouter(new Vache());
    m.ajouter(new Boa());

    m.midi();
}
}