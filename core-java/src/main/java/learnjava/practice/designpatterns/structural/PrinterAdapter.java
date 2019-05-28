package learnjava.practice.designpatterns.structural;

public class PrinterAdapter extends SavePdf implements Printer {

	@Override
	public void print() {
		savePdf();
	}

}
