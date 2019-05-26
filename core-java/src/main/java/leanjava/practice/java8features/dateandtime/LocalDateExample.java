package leanjava.practice.java8features.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateExample {

	
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		LocalTime time = LocalTime.now();
		System.out.println(time);
		int dd= date.getDayOfMonth();
		System.out.println(dd);
		int mm = date.getMonthValue();
		System.out.println(mm);
		int yyyy = date.getYear();
		System.out.println(yyyy);
		System.out.printf("%d-%d-%d",dd,mm,yyyy);
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println(ldt.getSecond());		
		LocalDateTime ldtime = LocalDateTime.of(2018, 12, 15, 9, 30);
		//so many overloaded methods LocalDateTime.of 
		System.out.println(ldtime);
		LocalDate bday = LocalDate.of(1990,9, 06);
		Period numofdays = Period.between(bday, date);
		System.out.println(numofdays);
		boolean y = Year.isLeap(2019);
		System.out.println(y);
		System.out.println(ChronoUnit.DAYS.between(bday, date));
		ZoneId zid = ZoneId.systemDefault();
		System.out.println(zid);
		ZoneId zidpst = ZoneId.systemDefault().of("America/Los_Angeles");
	    ZonedDateTime zdt = ZonedDateTime.now(zidpst);
	    System.out.println(zdt);
	}
	
}
