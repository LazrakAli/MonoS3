public class VectN {
    private int [] tab;

    private VectN(int n){
        this.tab=new int[n];
    }

    public VectN(int n,int valMax){
        this(n);
        for (int i=0;i<tab.length;i++){
            tab[i]=(int)(Math.random()*(valMax+1));
        }
    }

    public VectN(){
        this(5);
        for (int i=0;i<tab.length;i++){
            tab[i]=(int)(Math.random()*10);
        }
    }

    public VectN(int a,int b,int c){
        this(3);
        tab[0]=a;
        tab[1]=b;
        tab[2]=c;
    }

    public int Somme(){
        int i=0;
        for (int value:tab){
            i+=value;
        }
        return i;
    }

	public String toString(){
		String s ="[";
		int i;
		for(i = 0; i<tab.length-1; i++){
			s = s + tab[i] + ", ";
		}
		s = s + tab[i] + "]";
		return s;
    }

    //on cree un nouveau tab de la meme taille que celui qu'on veut copier et on recopie ses valeur dans le nouveau
    public int [] getTab(){
        int []newtab=new int [tab.length];
        for(int i=0;i<tab.length;i++){
            newtab[i]=tab[i];
        }
        return newtab;
    }
}
