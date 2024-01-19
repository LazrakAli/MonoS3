import java.util.ArrayList;

public class Etudiant {
    private String nom;
    private int[] notes;
    private int nbNotes;
    private static ArrayList<Etudiant> listEtudiants = new ArrayList<Etudiant>();

    public Etudiant(String nom) {
        this.nom = nom;
        this.notes = new int[5];
        this.nbNotes = 0;
        listEtudiants.add(this);
    }

    public void entrerNote(int note) throws TabNotesPleinException {
        if (nbNotes == 5) {
            throw new TabNotesPleinException();
        }
        notes[nbNotes] = note;
        nbNotes++;
    }

    public String getNom(){
        return nom;
    }
    public String toString() {
        String res = nom + " : [";
        for (int i = 0; i < nbNotes; i++) {
            res += notes[i];
            if (i < nbNotes - 1) {
                res += ", ";
            }
        }
        res += "]";
        return res;
    }
    
    public static ArrayList<Etudiant> getListEtudiants(){
        return listEtudiants;
    }
}
