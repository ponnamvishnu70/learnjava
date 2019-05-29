package learnjava.practice.designpatterns.behavioral;

//Composite key --Behavioral Design Pattern
import javax.naming.OperationNotSupportedException;

public class CompositeDesignPatternExample {

	public static void main(String[] args) {
		Developer dev1 = new Developer();
		Developer dev2 = new Developer();
		Developer dev3 = new Developer();
		dev1.setName("vishnu");
		dev2.setName("ponnam");
		dev3.setName("vishnu1");
		Manager manager = new Manager();
		manager.setName("ponnam vishnu");
		try {
			manager.addReportee(dev1);
			manager.addReportee(dev2);
			manager.addReportee(dev3);
		} catch (OperationNotSupportedException onse) {
			onse.printStackTrace();
		}
		manager.printName();
	}

}
