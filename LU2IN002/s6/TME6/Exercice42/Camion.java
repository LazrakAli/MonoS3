public class Camion extends AMoteur{
    private int VolumeTransportable;

    public Camion(String Mq,int tr,int VolumeTransportable){
        super(Mq,tr);
        this.VolumeTransportable=VolumeTransportable;
    } 

    public String toString(){
        return "Le camion "+super.toString()+"a une capacité de "+VolumeTransportable+" m^3 Transportable";
    }

    public void transporter(String materiel,int km){
    
    //consomation moyenne en km est de 0.08
    if (super.NvEssence < km*0.08){
        System.out.println("Le camion "+super.imatricu+" n'a plus d'essence !");
    }
    else {
        System.out.println("Le camion "+super.imatricu+" a transporté des "+materiel+" sur "+km+" km");
        super.Dparcourue+=km;
    }

    }

}