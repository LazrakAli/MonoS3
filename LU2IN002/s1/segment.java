

public class segment{
	private int x;
	private int y;
	public segment(int extX,int extY) {
		this.x=extX;
		this.y=extY;
		}
	public int longeur() {
	if (x<=y) {
		return (y-x);
		}
	else {
		return (x-y);
		}
	}
	public String toString() {
	return "la longeur du segment est "+ longeur();
	}

}
	
