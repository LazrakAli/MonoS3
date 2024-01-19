package EX52;

import java.util.ArrayList;

public class Panier extends ArrayList<Ramassable>{
    private double PoidsMax;

    public Panier(double PM){
        this.PoidsMax=PM;
    }

    public double getPoids(){
        double totalPoids=0;
        for(Ramassable r: this){
            totalPoids+= r.getPoids();
        }
        return totalPoids;
    }

    @Override
    public boolean add(Ramassable r){
        if( r.getPoids()<= (PoidsMax-r.getPoids()) ){
            System.out.println(r.toString()+" est ajouté au panier.");
			super.add(r);
			return true;
        } else {
            System.out.println(r.toString()+" n'est pas rajouté au panier.");
			return false;
        }
    }

    public int compterToxique() {
		int total = 0;
		for(Ramassable r : this) {
			if(r instanceof Toxic) {
				total ++;
			}
		}
		return total;
	}

    @Override
	public String toString() {
		return "Panier contenant " + this.size() + " objets, dont " + this.compterToxique()
		+" toxique (" + Math.round(this.getPoids()*10.0)/10.0 + "kg sur " + this.PoidsMax + "kg).";
	}

}