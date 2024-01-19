public class AMoteur extends Vehicule{
    public int TailleReservoire;
    public int NvEssence=0;

    public AMoteur(String marque,int tr){
        super(marque);
        TailleReservoire=tr;
    }

    public void approvisionner(double nb_litre){
        if ((int)nb_litre<=(TailleReservoire-NvEssence)){
            NvEssence+=(int)nb_litre;
        }else if (TailleReservoire==NvEssence){
            System.out.println("Le reservoire du vehicule est déjà plein");
        }else{
            System.out.println("Nous avons mis "+(TailleReservoire-NvEssence)+"L dans le reservoire, les "+(nb_litre-(TailleReservoire-NvEssence))+"L restant vous sont remboursé");
            NvEssence=TailleReservoire;     
        }
    }

    public boolean enPanne(){
        return NvEssence==0;
    }

    public String toString(){
        return super.toString()+" a Moteur ";
    }
}