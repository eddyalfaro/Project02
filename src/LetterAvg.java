import java.util.Arrays;

public class LetterAvg{
	
	private static final int FIRST_LETTER = 0;
	
	private Character letter;
	private MesoStation[] stationsWithLetterAvg;

	public LetterAvg(char letter) {
		this.letter = letter;
		stationsWithLetterAvg = findStationsWithLetter(this.letter);
	}

	public int numberOfStationWithLetterAvg() {
		return stationsWithLetterAvg.length;
	}
	
	public static MesoStation[] findStationsWithLetter(Character o) {
		int lenght = MesoInherit.STATIONS.length;
		MesoStation[] stations = new MesoStation[lenght];
		int size = 0;
		
		for (MesoStation station : MesoInherit.STATIONS) {
			if (o.compareTo(station.getStID().charAt(FIRST_LETTER)) == 0) {
				stations[size] = station;
				size++;
			} else if (o.compareTo(station.getStID().charAt(FIRST_LETTER)) < 0) {
				break;
			}
		}
		
		return Arrays.copyOf(stations, size);
	}

	public String toString() {
		String formated = "These stations are:";
		
		for (MesoStation o : stationsWithLetterAvg) {
			formated += String.format(" %s", o.getStID());
		}
		
		return formated;
	}
}
