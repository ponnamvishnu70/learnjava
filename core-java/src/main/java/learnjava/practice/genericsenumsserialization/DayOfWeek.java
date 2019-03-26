package learnjava.practice.genericsenumsserialization;

public enum DayOfWeek {

	MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);
	int value;

	private DayOfWeek(int val) {
		System.out.println(val);
		// TODO Auto-generated constructor stub
	}

	public int setValue(int value) {
		return value;
	}

	public int getValue() {
		return value;
	}

}
