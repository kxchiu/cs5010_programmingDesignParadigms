package sequentialSolution;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the main driver class that controls the file reader and writer in the
 * sequential solution style.
 */
public class Main {
	private static CsvReader csvReader;
	private static Writer writer;
	// A HashMap data structure that stores [course_num, [date, clicks]]
	private static HashMap<String, Map<Integer, Integer>> dataMap;

	public static void main(String[] args) throws IOException {
		String arg = "anonymisedData";
		Path courseInfo = Paths.get(arg + "\\" + "courses.csv");
		Path courseData = Paths.get(arg + "/studentVle.csv");
		Path outputDir = Paths.get("output");

		csvReader = new CsvReader();
		dataMap = csvReader.readFile(courseData);

		writer = new Writer();
		writer.writeOutput(dataMap, outputDir);
	}
}
