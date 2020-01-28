package sequentialSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a CSV-file reader that reads the CSV file and generates a HashMap of the
 * course information.
 */
public class CsvReader {
	private final Integer COURSE_MODULE = 0;
	private final Integer COURSE_PRES = 1;
	private final Integer DATE = 4;
	private final Integer CLICKS = 5;
	private HashMap<String, Map<Integer, Integer>> dataMap;

	/**
	 * Constructs a new CSV reader object.
	 */
	public CsvReader() {
		this.dataMap = new HashMap<String, Map<Integer, Integer>>();
	}

	/**
	 * Reads the CSV file and returns the processed information in a HashMap.
	 * @param courseData the given path to the course data.
	 * @return the processed course information
	 */
	public HashMap<String, Map<Integer, Integer>> readFile(Path courseData) {
		try (InputStream in = Files.newInputStream(courseData);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			String titleLine = reader.readLine();
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				String[] courseItems = line.split(",");
				String course_key = courseItems[COURSE_MODULE] + "_" + courseItems[COURSE_PRES];
				int date = Integer.valueOf(courseItems[DATE]);
				int clicks = Integer.valueOf(courseItems[CLICKS]);
				if (!this.dataMap.containsKey(course_key)) {
					// If the map does not have the course yet, add a record for it
					HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
					data.put(date, clicks);
					this.dataMap.put(course_key, data);
				} else {
					if (!this.dataMap.get(course_key).containsKey(date)) {
						// If the map has the course but does not have the record for the date, add a record
						this.dataMap.get(course_key).put(date, clicks);
					} else {
						// If the date exists in the record, add # of clicks to it
						int newClicks = this.dataMap.get(course_key).get(date) + clicks;
						this.dataMap.get(course_key).put(date, newClicks);
					}
				}
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		return this.dataMap;
	}
}
