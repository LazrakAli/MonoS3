public class TestEtudiants{
    public static void main(String[] args) {
        Etudiant e = null;
        for (int i = 0; i < args.length; i++) {
            try {
                int note = Integer.parseInt(args[i]);
                if (e != null) {
                    e.entrerNote(note);
                } else {
                    System.out.println("Pas d'etudiant existant, la note "+ note + " est ignorée");
                }
            } catch (NumberFormatException ex) {
                e = new Etudiant(args[i]);
            } catch (TabNotesPleinException tnpe) {
                System.out.println("Impossible d'entrer la note : le tableau de notes de l'etudiant " + e.getNom() + " est plein");
            }
        }
        System.out.println("les "+Etudiant.getListEtudiants().size()+" etudiants : " + Etudiant.getListEtudiants());
    }    
        
}
