package sequentialSolution;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a file writer that reads the processed data and writes into separate CSV
 * file.
 */
public class Writer {

	/**
	 * Constructs a new Writer object.
	 */
	public Writer() {
	}

	/**
	 * Reads from the processed data and writes to the output files.
	 * @param dataMap the HashMap with the processed data.
	 * @throws IOException when unable to write files
	 */
	public void writeOutput(HashMap<String, Map<Integer, Integer>> dataMap, Path outputDir)
			throws IOException {
		// Create the output directory if DNE.
		if (!Files.exists(outputDir)) {
			Files.createDirectory(outputDir);
		}
		// Loop through each [code_module]_[code_presentation] key.
		for (HashMap.Entry<String, Map<Integer, Integer>> entry : dataMap.entrySet()) {
			// Get the key and set to file name
			String fileName = entry.getKey();
			String newLine = System.getProperty("line.separator");
			FileWriter file = new FileWriter(outputDir + "\\" + fileName + ".csv");
			file.write("date,total_clicks" + newLine);

			// Get the processed data: [Date]-[Sum of Clicks] key-value pair, and write to file.
			Map<Integer, Integer> clicksByDate = entry.getValue();
			for (Map.Entry<Integer, Integer> dataEntry : clicksByDate.entrySet()) {
				file.write(dataEntry.getKey() + "," + dataEntry.getValue() + newLine);
			}
			file.close();
		}
	}
}
