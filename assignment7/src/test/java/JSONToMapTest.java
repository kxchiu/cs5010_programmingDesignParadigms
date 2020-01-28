import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

public class JSONToMapTest {

  @Test
  public void parse() throws IOException {
    String[] files = new File("grammars").list();
    Map<String, String[]> map = JSONToMap.parse("grammars" + File.separator + files[0]);
    String s = "";
    for (Entry<String, String[]> entry : map.entrySet()) {
      s += "Key = " + entry.getKey() + ", Value = " + Arrays.toString(entry.getValue());
    }

    Map<String, String[]> map1 = JSONToMap.parse("grammars" + File.separator + files[0]);
    String s1 = "";
    for (Entry<String, String[]> entry : map1.entrySet()) {
      s1 += "Key = " + entry.getKey() + ", Value = " + Arrays.toString(entry.getValue());
    }
    assertEquals(s, s1);
  }
}