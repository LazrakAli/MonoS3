
public class TestAdresseWeb {
	public static void main(String[] argv) {
	AdresseWeb c1= new AdresseWeb ("http://","www.supersite.fr","/rep1/rep2/index.html");
	AdresseWeb c2 = new AdresseWeb( "www.site.fr","/dir/page1.html");
	AdresseWeb c3 = new AdresseWeb("www.mavanime.co");
	System.out.println(c1);
	System.out.println(c2);
	System.out.println(c3);
	}
}
