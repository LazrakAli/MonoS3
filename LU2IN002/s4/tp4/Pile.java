public class Pile{
    private Machin[] pile;
    private int TailleMax;
    private static int TailleActu=0;

    public Pile(int n){
        pile= new Machin[n];
        this.TailleMax=n-1;
        for(int i=0;i<pile.length;i++){
            pile[i]=null;
        }
    }

    public int getTailleactu(){
        return TailleActu;
    }

    public boolean estVide(){
        return TailleActu==0;
    }

    public boolean estPleine(){
        return TailleActu==TailleMax;
    }

    public void empiler(Machin m){
        if (this.estPleine()){
            System.out.println("desole, la pile est pleine");
            return;
        }else{
            pile[TailleActu]=m;
            TailleActu++;
        }
    }

    public void depiler(){
        if (this.estVide()){
            System.out.println("desole, la pile est vide");
            return;
        }else{
            pile[TailleActu]=null;
            TailleActu--;

        }
    }

	public String toString(){
		String s ="";
		for(int i = 0; i<pile.length; i++){
			if(pile[i] != null){
				s = s + pile[i].toString() + "\n";	
			}else{
				return s;
			}	
		}
		return s;
	}
}

