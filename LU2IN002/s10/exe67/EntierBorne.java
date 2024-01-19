public class EntierBorne{
    private int valeur;
    private static final int MIN=-100;
    private static final int MAX=100;

    public EntierBorne(int V) throws HorsBornesException{
        if (V > MAX || V <MIN ){
            if (V>MAX)  
                throw new HorsBornesException("Entier trop grand : "+V);
            else
                throw new HorsBornesException("Entier trop petit : "+V);
        }
        valeur=V;
    }
    public EntierBorne somme(EntierBorne eb) throws HorsBornesException {
        int somme = this.valeur + eb.valeur;
        return new EntierBorne(somme);
    }   

    public EntierBorne divPar(EntierBorne eb) throws DivisionParZeroException,HorsBornesException {
        if (eb.valeur == 0) {
            throw new DivisionParZeroException("division par zero");
        }
        int quotient = this.valeur / eb.valeur;
        return new EntierBorne(quotient);
    }
    public String toString() {
        return Integer.toString(valeur);
    }
}

