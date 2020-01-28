package assignment8;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class GrammarUtil {

  private static String[] files;
  private static String JSON_FOLDER;
  private static List<Map<String, String[]>> jsonToMapList = new ArrayList();

  public static String initiate() throws IOException {
    JSON_FOLDER = "grammars";
    files = new File(JSON_FOLDER).list();
    System.out.println(files.toString());
    for (String filename: files) {
      jsonToMapList.add(JSONToMap.parse(JSON_FOLDER + File.separator + filename));
    }
    return askToSelectJson(jsonToMapList);
  }

  private static String askToSelectJson(List<Map<String, String[]>> jsonToMapList) {
    return sentencesOfJSON(jsonToMapList.get(0));
  }

  private static boolean responseIsInvalid(String response) {
    return !responseIsValid(response);
  }

  private static boolean responseIsValid(String response) {
    return responseIsQ(response) || responseIsWithinIndexRange(response);
  }

  private static boolean responseIsQ(String response) {
    return response.equals(EnumStrings.NO.getLiteral());
  }

  private static boolean responseIsWithinIndexRange(String response) {
    Integer index = new Integer(response);
    return index >= 1 && index <= files.length;
  }

  private static String recursiveReplacer(Map<String, String[]> map, String line) {
    String[] words = line.split(" ");
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (isPlaceholder(word)) {
        word = word.substring(1, word.length() - 1).toLowerCase();
        if (!map.containsKey(word)) {
          throw new IllegalArgumentException("No non-terminal key: " + word);
        }
        word = recursiveReplacer(map, map.get(word)[new Random().nextInt(map.get(word).length)]);
      }
      words[i] = word;
    }
    return String.join(" ", words);
  }

  private static String modifyForPunctuations(String[] words, int i, String word) {
    if (word.equals(".") || word.equals(",")) {
      words[i-1] = words[i-1] + word;
      word = "";
    }
    return word;
  }

  private static boolean isPlaceholder(String word) {
    return word.startsWith("<") && word.endsWith(">");
  }

  private static String replacePlaceholders(Map<String, String[]> map) {
    String line = map.get(EnumGrammarKeys.START.getKey())[0];
//    return iterativeReplacer(map, line);
    return recursiveReplacer(map, line);
  }

  private static String iterativeReplacer(Map<String, String[]> map, String line) {
    while (line.contains(EnumStrings.PLACEHOLDER_OPENER.getLiteral()) && line.contains(EnumStrings.PLACEHOLDER_CLOSER.getLiteral())) {
      Integer startIndex = line.indexOf(EnumStrings.PLACEHOLDER_OPENER.getLiteral());
      Integer endIndex = line.indexOf(EnumStrings.PLACEHOLDER_CLOSER.getLiteral());
      String token = line.substring(startIndex + 1, endIndex).toLowerCase();
      String selected;
      if (map.containsKey(token)) {
        selected = map.get(token)[new Random().nextInt(map.get(token).length)];
      } else {
        throw new IllegalArgumentException("No non-terminal key: " + token);
      }
      String before = line.substring(0, startIndex);
      String after = line.substring(endIndex + 1);
      line = before + selected + after;
    }
    return line;
  }

  private static String sentencesOfJSON(Map<String, String[]> stringMap) {
    String string = replacePlaceholders(stringMap);
    string = string.replaceAll("\\s\\.", ".");
    string = string.replaceAll("\\s,", ",");
    string = string.replaceAll("\\s'", "'");
    return string;
  }

  private static boolean responseIsNeitherYOrN(String response) {
    return !response.equals(EnumStrings.YES.getLiteral()) && !response.equals(EnumStrings.NO.getLiteral());
  }

  private static void printFiles(List<Map<String, String[]>> files) {
    for (int i = 0; i < files.size(); i++) {
      System.out.println((i + 1) + ". " + files.get(i).getOrDefault(EnumGrammarKeys.GRAMMAR_TITLE.getKey(),
          new String[]{EnumStrings.NO_TITLE.getLiteral()})[0]);
    }
  }

}
