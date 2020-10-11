
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class MesoInherit extends MesoAbstract{

	protected final static MesoStation[] STATIONS = converToMesoStation(getStations());
	
	private final static int CEILING_INDEX = 0;
	private final static int FLOOR_INDEX = 1;
	private final static int AVG_INDEX = 2;
	private final static int STARTING_LINE = 3;
	
	private final static String FILE_NAME = "Mesonet.txt";
	
	private MesoStation station;
	private double avgValue;
	private char avgCharacter;
	private int roundAvg;
	
	public MesoInherit(MesoStation station) {
		this.station = station;	
		averageStID();
		
		roundAvg = roundNumber(avgValue);
		avgCharacter = (char) roundAvg;
	}
	
	private static String[] readFile(String fileName) {
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(fileName));//opens file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Stream<String> lineStream = reader.lines(); //pushes the lines of the files into a stream of strings
		String[] linesReadInFile = lineStream.toArray(String[]::new); //turns the stream of strings into an array
		
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		lineStream.close();
		
		return linesReadInFile;
	}
	
	private static String[] getStations() {
		String[] linesReadInFile = readFile(FILE_NAME);//calls to read file and obtain he lines in the file
		
		for(int i = 0; i < linesReadInFile.length; i++) {
			linesReadInFile[i] = linesReadInFile[i].trim();//takes leading and ending blank spaces from each line
			linesReadInFile[i] = linesReadInFile[i].split(" ",2)[0];//splits into two the line using as a delimiter a blank space and assigns the first value of the line before a space
			linesReadInFile[i] = linesReadInFile[i].trim();//trims down the obtained value from the line
		}
		
		return Arrays.copyOfRange(linesReadInFile, STARTING_LINE, linesReadInFile.length);//returns a copy of the array trimming it to the start of the STIDs
	}
	
	private static MesoStation[] converToMesoStation(String[] stations) {
		MesoStation[] array = new MesoStation[stations.length]; 		
		int index = 0;
		
		for (String station : stations) {
			//System.out.print("Creating MesoStation #" + index + ": ");
			array[index] = new MesoStation(station);
			//System.out.println("" + array[index].getStID());
			index++;
		}
		
		return array;
	}
		
	@Override
	public int[] calAverage() {
		int[] avgValues = new int[station.getStID().length()];	
		
		avgValues[CEILING_INDEX] = (int) (avgValue + 1);
		avgValues[FLOOR_INDEX] = (int) avgValue;
		avgValues[AVG_INDEX] = roundAvg;
		
		return avgValues;
	}
	
	private void averageStID() {
		char[] stationCharacters = station.getStID().toCharArray();
		
		int sum = 0;
		
		for (char c : stationCharacters) {
			sum += c;
			//System.out.println("Character '" + c + "' with ASCII value: " + (int) c );
		}
		
		//System.out.println("Sum of Characters: " + sum);
		
		avgValue = sum / ((double) stationCharacters.length);
		//System.out.println("Avg value: " + avgValue + '\n');
	}

	public int roundNumber(double value) {	
		//System.out.println("value to round: " + value);
		int up = (int) (100 * value);
		int down = ((int) value) * 100;
		int residue = up % down;
		
		//System.out.println("100th decimal numbers: " + residue);
		if (residue < 75) {
			return (int) value;
		}else {
			return (int) (value + 1);
		}
	}
	
	@Override
	public char letterAverage() {
		return avgCharacter;
	}
   
}