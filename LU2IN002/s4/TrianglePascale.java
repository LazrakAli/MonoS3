

public class TrianglePascale {
	int [][] tp;
	
	public TrianglePascale(int x) {
		int[][] tp= new int[x][];
		for (int i=0;i<tp.length;i++) {
			tp[i]=new int [i+1];
			}
		}
	public void remplirTriangle() {
		for (int i=0;i<tp.length;i++) {
			for (int j=0;j<tp.length;j++){
				if (i==0 || i==j) {
					tp[i][j]=1;
					}
				else {
					tp[i][j]=(tp[i-1][j-1]+tp[i-1][j]);
					}
				}
			}
		}
	public String toString() {
		String s="[";
		for (int i=0;i<tp.length;i++) {
			for (int j=0;j<tp.length;j++){
				if (j==0) {
					s=s+"\n";
					s=s+tp[i][j];
					}
				else 
					s=s+" ";
					s=s+tp[i][j];}
				}
		return s;
		}	
	}

	
	
	
	
	
	
	
	
	
