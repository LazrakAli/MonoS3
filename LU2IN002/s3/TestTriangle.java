

public class TestTriangle{
	public static void main(String[] args) {
		Point p1 = new Point(1,3);
		Point p2 = new Point(3,5);
		Point p3 = new Point(2,4);
		System.out.println("p1: "+p1);
		System.out.println(p2);
		System.out.println(p3);
		double x = p1.distance(p3.getPosx(),p3.getPosy());
		System.out.println("distance entre et p3 est "+x);
		
		}
}
		
		
		
