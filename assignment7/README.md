o Entry point to your program.

If you want to run Driver.java to start the program in IntelliJ, change JSON_FOLDER = args[0] to JSON_FOLDER = "grammars" in the GrammarUtil class.

o Key classes/methods

JSONToMap class returns a Map<String, String[]> map of a json file. 

GrammarUtil class creates a List<Map<String, String[]>> jsonToMapList using JSONToMap.parse(JSON_FOLDER + File.separator + filename).

o Assumption: The files in the grammar folder are all json files. 

o Steps taken to ensure correctness.

Step 1. One class is responsible for creating a map of a json file of <type> to array of words corresponding to type. Example: adj : [happy, joyful, excited]
  
Step 2. Generate a list of maps that each correspond to a json file. 

Step 3. Initiate the UI.

o Run your program from the command line by entering:

javac Driver.java <FilePath to grammars folder>

