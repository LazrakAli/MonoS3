
public class Tab2d{
	private int[][] tab;
	
	public Tab2d (int x) {
		int[][] tab=new int[x][];
		for (int i=0;i<tab.length;i++) {
			tab[i]= new int[i+1];
			for (int j=0;j<tab[i].length;j++)
				tab[i][j]=i+1;
			}
		}
	public void Affichage() {
		for (int b=0;b<tab.length;b++) {
			for (int c=0;c<tab[b].length;c++)
			System.out.println(tab[b][c]);
			}
		}
	}
