package assignment8;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSONToMap {

  public static Map<String, String[]> parse(String file) throws IOException {
    JSONObject root = new JSONObject(FileUtils.readFileToString(new File(file), "utf-8"));
    String[] keys = JSONObject.getNames(root);
    Map<String, String[]> data = new HashMap<>();

    for (String key: keys) {
      Object value = root.get(key);
      if (value instanceof String) {
        putDataWithLowercaseKey(data, key, new String[]{(String) value});
      } else if (value instanceof JSONArray) {
        JSONArray jsonValues = (JSONArray) value;
        String[] values = new String[jsonValues.length()];
        for (int i = 0; i < values.length; i++) {
          values[i] = jsonValues.getString(i);
        }
        putDataWithLowercaseKey(data, key, values);
      }
    }
    return data;
  }

  private static void putDataWithLowercaseKey(Map<String, String[]> data, String key, String[] values) {
    data.put(key.toLowerCase(), values);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
