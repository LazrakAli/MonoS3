public class Voiture extends AMoteur{
    private int nbPlace;

    public Voiture(String Mq,int tr,int nbplace){
        super(Mq,tr);
        this.nbPlace=nbplace;
    } 

    public String toString(){
        return "La voiture "+super.toString()+" possede "+nbPlace+" place(s)";
    }

    public void transporter(int nbPers,int km){
        if(nbPers>nbPlace){
            System.out.println("Il y'a plus de personnes que de place!");
        }
        else {
            //consomation moyenne en km est de 0.08
            if (super.NvEssence < km*0.08){
                System.out.println("La voiture "+super.imatricu+" n'a plus d'essence !");
            }
            else {
                System.out.println("La voiture "+super.imatricu+" transporte "+nbPers+" personnes sur "+km+" km");
                super.Dparcourue+=km;
            }
        }
    }

}