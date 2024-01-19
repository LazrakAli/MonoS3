public class Alea {

    private Alea(){}

    public static char lettre(){
        return (char)(int)('a'+Math.random()*26);
    }
    public static String chaine(){
        String ch="";
        int i=0;
        while (i<10){
            ch+=lettre();
            i++;
        }
        return ch;
    }

}