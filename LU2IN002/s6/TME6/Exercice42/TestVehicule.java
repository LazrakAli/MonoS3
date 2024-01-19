public class TestVehicule{
    public static void main(String[] args){
    
    //----------------------------------velo
    System.out.println("\n=====-Velo-=====\n");
        Velo v=new Velo("MyVTT",17);
        v.rouler(10);
        System.out.println(v.toString());
        v.transporter("Paris","Lyon");


    //----------------------------------voiture

        System.out.println("\n=====-VOITURE-=====\n");
        Voiture V=new Voiture("BMW",59,5);
        V.approvisionner(70);
        V.transporter(4,100);
        System.out.println(V.toString());
    //----------------------------------Camion

        System.out.println("\n=====-CAMION-=====\n");
        Camion c=new Camion("Volvo",500,20);
        c.approvisionner(850);
        c.transporter("tuiles",500);
        System.out.println(c.toString());
    
 
    //----------------------------------tableau de 3 vehilucles

    Vehicule[] parking=new Vehicule[3];
    parking[0]=v;
    parking[1]=V;
    parking[2]=c;
    //On peut factoriser la methode transporter en mettant une premiere methode dans la classe Amoteur de signature
        //void transport(int km);


    }
}