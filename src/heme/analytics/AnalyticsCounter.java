package heme.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

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
	private static HashMap<String, Integer> symptomsHashMap;
	private static TreeMap<String, Integer> symptomsOrderedMap;
	
	public static void main(String args[]) throws Exception 
	{
		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("C:\\Users\\108770706\\eclipse-workspace\\HemeAnalyticsSoftware\\ressources\\symptoms.txt");
		
		symptoms = file.getSymptoms();
		symptomsHashMap = file.countSymptoms(symptoms);
		symptomsOrderedMap = file.sortSymptoms(symptomsHashMap);
		
		file.writeSymptomToFile(symptomsOrderedMap);
		
	}
}
