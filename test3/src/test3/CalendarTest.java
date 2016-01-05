package test3;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
	    Date date= new Date();
	    cal.setTime(date);
	    System.out.println(cal.get(Calendar.HOUR_OF_DAY)*60+cal.get(Calendar.MINUTE));
	}    
}
