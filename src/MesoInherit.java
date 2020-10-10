import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class MesoInherit extends MesoAbstract{

	public final static MesoStation[] STATIONS = converToMesoStation(getStations());
	
	private final static int STARTING_LINE = 3;
	private final static String FILE_NAME = "Mesonet.txt";
	
	public MesoInherit() {
		
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
			System.out.print("Creating MesoStation #" + index + ": ");
			array[index] = new MesoStation(station);
			System.out.println("" + array[index].getStID());
			index++;
		}
		
		return array;
	}
		
	@Override
	int[] calAverage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	char letterAverage() {
		// TODO Auto-generated method stub
		return 0;
	}
   
}