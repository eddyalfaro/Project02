/**
 * @author Mohammad Mukhtaruzzaman
 * @version 2020-09-18
*/
import java.io.IOException;

public class Driver 
{
	public static void main(String[] args) throws IOException 
	{
		/**
	     * This Driver/Main program should be read along with the project description PDF
	     * DateTimeInherit is a class that inherits the class named, DateTimeAbstract  
	     */
		
	    DateTimeInherit dateTimeInherit = new DateTimeInherit();
    
	    /**
	     * From the given line of codes you have to identify the class name and necessary constructors/methods
	     * In the following method, the first parameter is the month and the second parameter is the year.
	     * We are going to print the first day and the last day (day of the week) of any given month of the year.
	     * Output format: for (4, 2020):
	     * In the year 2020, for the 4th month: the first day is WEDNESDAY and the last day is THURSDAY		
		 */	    
	    dateTimeInherit.daysOfAnyMonth(9, 2020);
	    dateTimeInherit.daysOfAnyMonth(10, 2020);
	    dateTimeInherit.daysOfAnyMonth(12, 2020);
	    System.out.print("\n");
	    
	    /**
	     * Description of the following codes and outputs are given in the PDF.		
		 */
	    
		String stID = "CHIC";
		
		PosAvg posAvg = new PosAvg(stID);
		System.out.println("The Index of the city is in the Mesonet: " + posAvg.indexOfStation());
		System.out.println(posAvg);
		System.out.print("\n");
		
		MesoInherit mesoInherit = new MesoInherit(new MesoStation(stID));
		
		System.out.println("Ascii Ceiling is " + mesoInherit.calAverage()[0]);
		System.out.println("Ascii Floor is " + mesoInherit.calAverage()[1]);
		System.out.println("Ascii Average is " + mesoInherit.calAverage()[2]);
		System.out.print("\n");
		
		System.out.println("Letter Avg: " + mesoInherit.letterAverage());
		System.out.print("\n");
		
		LetterAvg letterAvg = new LetterAvg(mesoInherit.letterAverage());
		System.out.println("Total number of stations starting with the letter '" + mesoInherit.letterAverage() + "' is " + letterAvg.numberOfStationWithLetterAvg() + ".");
		
		System.out.print(letterAvg);
	}
}