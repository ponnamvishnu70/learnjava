package learnjava.practice.designpatterns.structural;

public class AccontDetailsVerification  implements Verification{

	@Override
	public boolean verify() {
		System.out.println("Logic for account level Verification");
		return true;
	}

}
