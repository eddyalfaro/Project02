
import java.time.DayOfWeek;
import java.time.YearMonth;

/**
 * DateTimeInherit is a class that inherits the class named, DateTimeAbstract  
 */

public class DateTimeInherit extends DateTimeAbstract {
	
	private static final int FIRST_DAY = 1;
	
	private int month;
	private int year;
	
	private String firstDayWeek;
	private String lastDayWeek;
	
	private YearMonth yearMonthPair;
	
	public DateTimeInherit() {
		
	}
	
	@Override
	public void daysOfAnyMonth(int monthOfYear, int theYear) {
		month = monthOfYear;
		year = theYear;
		
		yearMonthPair = YearMonth.of(year, month);
		DayOfWeek firstDayMonth = yearMonthPair.atDay(FIRST_DAY).getDayOfWeek();
		DayOfWeek lastDayMonth = yearMonthPair.atEndOfMonth().getDayOfWeek();
		
		//System.out.println(firstDayMonth.getDayOfWeek().toString());
		firstDayWeek = firstDayMonth.toString();
		lastDayWeek = lastDayMonth.toString();
		
		System.out.println(toString());
	}
	
	public String toString() {
		String output = "In the year " + year + ", for the " + month + "th month: the first day is " + 
				firstDayWeek + " and the last day is " + lastDayWeek;
		
		return output;
	}

	
}