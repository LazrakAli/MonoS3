

public class Point {
	private int posx;
	private int posy;
	
	public Point() {
		this.posx = ((int) Math.random()*90);
		this.posy = ((int) Math.random()*90);
		}
	public Point(int x, int y) {
		this.posx=x;
		this.posy=y;
		}
	public int getPosx() {
		return posx;}
		
	public int getPosy() {
		return posy;}
		
	public void setPosx(int Posx) {
		this.posx=Posx;
		}
		
	public void setPosy(int Posy) {
		this.posy=Posy;
		}
	
	public String toString() {
		return "("+posx+","+posy+")";
		}
		
	public double distance(int newx,int newy) {
		 return Math.sqrt((posx-newx)*(posx-newx)+(posy-newy)*(posy-newy));
		 }
	
	public void deplaceToi(int newx,int newy) {
		setPosx(newx);
		setPosy(newy);
	}
	
}




















		
