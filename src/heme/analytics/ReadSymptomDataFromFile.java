package heme.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implementation de l'interface ISymptomReader
 * @see ISymptomReader.java
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	@Override
	public HashMap<String, Integer> countSymptoms(List<String> symptomsList) {
		HashMap<String, Integer> symptomsHashMap = new HashMap<String, Integer>();
		
		for(String symptom : symptomsList) {
			if(symptomsHashMap.containsKey(symptom)) {
				symptomsHashMap.put(symptom, symptomsHashMap.get(symptom) + 1);
			} else {
				symptomsHashMap.put(symptom, 1);
			}
		}
		
		return symptomsHashMap;
	}
	
	@Override
	public TreeMap<String, Integer> sortSymptoms(HashMap<String, Integer> symptomsList) {
		TreeMap<String, Integer> sortedSymptomsTreeMap = new TreeMap<String, Integer>(symptomsList);
		return sortedSymptomsTreeMap;
	}
	
	@Override
	public void writeSymptomToFile(TreeMap<String, Integer> symptomsList) throws IOException {
		FileWriter writer = new FileWriter("ressources/result.out");
		for(Map.Entry<String, Integer> entry : symptomsList.entrySet()) {
			writer.write(entry.getKey() + " = " + entry.getValue() + "\n");
		}
		writer.close();
	}
}
