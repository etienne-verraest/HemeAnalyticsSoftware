package heme.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> getSymptoms();

	/** 
	 * This method counts symptoms given in a text file
	 * @param symptomsList
	 * @return HashMap<String, Integer>
	 */
	HashMap<String, Integer> countSymptoms(List<String> symptomsList);
	
	/** 
	 * This method sorts symptoms given in a HashMap
	 * @param symptomsList
	 * @return TreeMap<String, Integer>
	 */
	TreeMap<String, Integer> sortSymptoms(HashMap<String, Integer> symptomsList);

	/** 
	 * This method writes counted and ordered symptoms on a file
	 */
	void writeSymptomToFile(TreeMap<String, Integer> symptomsList) throws IOException;
}
