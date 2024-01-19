public class TestEntierBorne{
    public static void main(String[] args){
        try{
            EntierBorne ebX=new EntierBorne((int)(Math.random()*301-150));
            EntierBorne ebY=new EntierBorne((int)(Math.random()*301-150));
            EntierBorne ebXplusY=ebX.somme(ebY);
            EntierBorne EbXDiviseEbY=ebX.divPar(ebY);
            System.out.println("ebX = " + ebX);
            System.out.println("ebY = " + ebY);
            System.out.println("Somme (ebX,ebY) = "+ebXplusY);
            System.out.println("Divisison (ebX/ebY) = "+EbXDiviseEbY);
        }catch(HorsBornesException e){
            System.out.println("Une exception HorsBornesException s'est produite : " + e.getMessage());
        }catch(DivisionParZeroException e){
            
        }
    }
}