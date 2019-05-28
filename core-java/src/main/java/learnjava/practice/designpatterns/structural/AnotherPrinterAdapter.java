package learnjava.practice.designpatterns.structural;

public class AnotherPrinterAdapter implements Printer {
	Email email;

	AnotherPrinterAdapter(Email e) {
		this.email = e;
	}

	@Override
	public void print() {
		email.sendEmail();

	}

}
