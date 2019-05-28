package learnjava.practice.designpatterns.structural;

//Proxy design pattern -  Structural design Pattern
public class ProxyDesignPattenExample {
	public static void main(String[] args) {
		Verification v = new IdVerification();
		System.out.println(v.verify());

	}

}
