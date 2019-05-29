package learnjava.practice.designpatterns.behavioral;

public class Manager extends Employee {

	public void printName() {

		System.out.println("Manager -------------");
		super.printName();
		System.out.println("Reportees -------------");
		reportees.forEach(employee -> employee.printName());
	}
}
