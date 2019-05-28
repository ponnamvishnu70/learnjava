package learnjava.practice.misc;

enum MonthDays {
	MONTH31DAYS("January", "March", "May", "July", "August", "October", "December"), 
	MONTH30DAYS("February", "April","June", "September", "November");
	public String[] months;

	MonthDays(String... strings) {		
		this.months = strings;
	}

	public String[] getMonths() {
		return this.months;
	}

}

public class EnumExample {
	public static void main(String[] args) {
		System.out.println(MonthDays.MONTH30DAYS.getMonths()[0]);
		System.out.println(MonthDays.MONTH31DAYS.getMonths()[2]);
	}

}
