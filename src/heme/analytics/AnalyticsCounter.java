package heme.analytics;

import java.util.LinkedHashMap;
import java.util.List;

/** 
 * AnalyticsCounter analyzes a a list with various symptoms. 
 * It counts occurrences and sort them by alphabetical order.
 * Then a result.out file is created at the end of the analysis.
 * 
 * @author Etienne Verraest
 * @version 1.0
 */

public class AnalyticsCounter
{
	private static List<String> symptoms;
	private static LinkedHashMap<String, Integer> symptomsMap;
	
	public static void main(String args[]) throws Exception 
	{
		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("ressources" + System.getProperty("file.separator") + "symptoms.txt");
		
		symptoms = file.getSymptoms();
		symptomsMap = file.countSymptoms(symptoms);
		
		file.writeSymptomToFile(symptomsMap);
		
	}
}
