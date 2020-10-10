import java.util.Arrays;

public class PosAvg implements Comparable<MesoStation>{
	
	private static final int DISTANCE_TO_AVG = 2;
	private static final int AVGS_ARRAY_LENGTH = 2;
	private static final int FIRST_AVG_INDEX = 0;
	private static final int SECOND_AVG_INDEX = 1;
	
	private MesoStation station; 
	private int indexOfStation; //index value of station in Mesonet starting from 1
	private MesoStation[][] arrayOfAvg;
	
	public PosAvg(String stID) {
		station = new MesoStation(stID);	
		
		this.findIndex();
		this.getAvgIndexStations();
	}
	
	public String indexOfStation() {
		return "" + indexOfStation;
	}
	
	public int getIndexOfStation() {
		return indexOfStation;
	}

	private void findIndex() {
		indexOfStation = 1;
		for(MesoStation stations : MesoInherit.STATIONS) {
			if(this.compareTo(stations) == 0) {
				break;
			}
			indexOfStation++;
		}
	}
	
	private void getAvgIndexStations() {
		if (isIndexSkipable()) {
			return;
		}
		
		arrayOfAvg = new MesoStation[DISTANCE_TO_AVG][AVGS_ARRAY_LENGTH];
		
		for (int i = 1; i <= DISTANCE_TO_AVG; i++) {
			arrayOfAvg[i - 1][FIRST_AVG_INDEX] =  MesoInherit.STATIONS[indexOfStation - 1 - i];
			arrayOfAvg[i - 1][SECOND_AVG_INDEX] =  MesoInherit.STATIONS[indexOfStation - 1 + i];
			//System.out.println("Avg pair #" + i + " values found:");
			//System.out.print(MesoInherit.STATIONS[indexOfStation - 1 - i].getStID());
			//System.out.println(" and " + MesoInherit.STATIONS[indexOfStation - 1 + i].getStID() + '\n');
		}
	}
	
	public MesoStation[] getFirstAvgPair() {
		return Arrays.copyOf(arrayOfAvg[0], AVGS_ARRAY_LENGTH);
	}
	
	public MesoStation[] getSecondAvgPair() {
		return Arrays.copyOf(arrayOfAvg[1], AVGS_ARRAY_LENGTH);
	}
	
	public boolean isIndexSkipable(){
		//System.out.println("is position within array #" + indexOfStation + " skipable?");
		if (indexOfStation > DISTANCE_TO_AVG) {
			if (indexOfStation < (MesoInherit.STATIONS.length - DISTANCE_TO_AVG)) {
				//System.out.println("no, continuing instructions" + '\n');
				return false;
			}
		}
		//System.out.println("yes, stoping instructions" + '\n');
		return true;
	}

	@Override
	public int compareTo(MesoStation o) {
		return station.getStID().compareTo(o.getStID());
	}

	public String toString() {
		String formated = "This index is average of ";
		
		for (int i = 0 ; i < DISTANCE_TO_AVG; i++) {
			formated += String.format("%s and %s, ", arrayOfAvg[i][FIRST_AVG_INDEX].getStID(), 
					arrayOfAvg[i][SECOND_AVG_INDEX].getStID());
		}
		
		formated += "and so on.";
		
		return formated;
	}
}
