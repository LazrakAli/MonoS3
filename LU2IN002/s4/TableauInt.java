
public class TableauInt{
	private int[] tab = new int[10];
	
	public TableauInt () {
		for (int i=0;i<tab.length;i++)
			tab[i]= (int) (Math.random()*100);
		}
	public TableauInt(int j) {
		for (int i=0;i<tab.length;i++)
			tab[i]=j+i;
		}
		
		
	public String toString () {
		return "["+tab[0]+","+tab[1]+","+tab[2]+","+tab[3]+","+tab[4]+","+tab[5]+","+tab[6]+","+tab[7]+","+tab[8]+","+tab[9]+"]";
		}
	
	public int rangMax() {
		return tab.length;
		}
	public int somme(){
	int c=0;
	for (int i:tab)
		c+=i;
	return c;
	}
}
