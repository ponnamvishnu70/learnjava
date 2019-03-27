package learnjava.practice.dateandtime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Set;
//Lot of things to do
public class DataTimeExample {
	public static void main(String[] args) {
		//To get current date
		LocalDate date = LocalDate.now();
		//Get tomorrow date
		LocalDate tomorrowdate = LocalDate.now().plusDays(1);
		//To get a local date object from a string
		LocalDate date1 = LocalDate.parse("2007-12-03");
		
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println(allZoneIds);
		System.out.println(date1.getMonth());
		System.out.println(date1.getMonthValue());
		
	}

}
