package learnjava.practice.designpatterns.structural;
//proxy class added for additional security
public class IdVerification implements Verification {
	AccontDetailsVerification acv = new AccontDetailsVerification();

	@Override
	public boolean verify() {
	//logic for verifying id
		if(true) {
			System.out.println("Logic for Personal Id  Verification");
			return acv.verify();
		}
		return false;
	}

}
