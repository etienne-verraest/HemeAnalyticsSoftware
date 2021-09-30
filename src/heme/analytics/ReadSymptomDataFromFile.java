package heme.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementing Interface ISymptomReader
 * @see {@link ISymptomReader}
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
				Collections.sort(result);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	@Override
	public LinkedHashMap<String, Integer> countSymptoms(List<String> symptoms) {
		LinkedHashMap<String, Integer> symptomsMap = new LinkedHashMap<String, Integer>();
		
		for(String symptom : symptoms) {
			if(symptomsMap.containsKey(symptom) == false) {
				symptomsMap.put(symptom, Collections.frequency(symptoms, symptom));
			}
		}
		return symptomsMap;
	}
	
	@Override
	public void writeSymptomToFile(LinkedHashMap<String, Integer> symptoms) throws IOException {
		FileWriter writer = new FileWriter("ressources"+ System.getProperty("file.separator") + "result.out");
		for(Map.Entry<String, Integer> entry : symptoms.entrySet()) {
			writer.write(entry.getKey() + " = " + entry.getValue() + "\n");
		}
		writer.close();
	}
}
