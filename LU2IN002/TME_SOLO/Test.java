import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
    
    Maison m1=new Maison(20,"2 rue de la Paix,75015");
    m1.setLoyer(2000);
    m1.setCharges(100);
    m1.ajouterPiece(new Piece("Chambre",12));
    m1.ajouterPiece(new Piece("Chambre",13));
    m1.ajouterPiece(new Piece("sejour",20));
    m1.ajouterPiece(new Piece("Salle de bain",3));
    m1.ajouterPiece(new Piece("Cuisine",6));

    Appartement a1=new Appartement(0);
    a1.setLoyer(1600);
    a1.setCharges(50);
    a1.ajouterPiece(new Piece("Chambre",12));
    a1.ajouterPiece(new Piece("Chambre",11));
    a1.ajouterPiece(new Piece("Cahmbre",10));
    a1.ajouterPiece(new Piece("Salle de bain",4));
    a1.ajouterPiece(new Piece("Sejour",25));

    ArrayList<Object> TAB=new ArrayList<Object>();
    TAB.add(m1);
    TAB.add(a1);
    for (Object l: TAB)
        System.out.println(l.toString());    
    }
}