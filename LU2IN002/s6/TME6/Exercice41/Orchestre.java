public class Orchestre {
    private int nbMaxInstrument;
    private Instrument[] tab;
    private static int cpt=0;

    public Orchestre(int nbM){
        nbMaxInstrument=nbM;
        tab=new Instrument[nbMaxInstrument];
    }

    public void ajouterInstrument(Instrument x){
        if (cpt>=nbMaxInstrument){
            System.out.println("L'orchestre est déjà complet");
        }
        else {
            tab[cpt]=x;
            cpt++;
        }
    }
    public void jouer(){
        for(Instrument i: tab)
            i.jouer();
    }
}