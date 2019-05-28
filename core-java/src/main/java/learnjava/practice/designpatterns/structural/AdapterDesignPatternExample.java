package learnjava.practice.designpatterns.structural;

//AdapterDesignPattern is a structural design
public class AdapterDesignPatternExample {
	
	public static void main(String[] args) {
		// Adapter Design Pattern -- INHERITANCE
		Printer p = new A4Print();
		p.print();
		Printer psave = new PrinterAdapter();
		psave.print();
		// Adapter Design Pattern -- Composition
		Email e = new Email();
		Printer pemail = new AnotherPrinterAdapter(e);
		pemail.print();
		}

}
