import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser {
    private File fileName;
    private Map<String,String> map = new HashMap<>();

    public ConfigParser(File fileName) {
        this.fileName = fileName;
    }

//    Public get method to grant access to the private Map
    public String get(String key) {
        System.out.println("key  <==>  Value");
        return key + "  =  "+ map.get(key)+"\n";
    }


//    A method use to read configuration files and parse to map
//    Try -With Resource block was used to manage errors because of its Auto closable capability
//    BufferedReader was used to read file because of its efficiency of over inputStreamReader
    public String executeApp() {
        try (
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                        String[] strArr = line.split("="); //Individual lines were splited across = sign to create an array

                        if(strArr.length == 2) { //filtered out arrays based on length condition (ie: [application] length is 1
                            if (map.containsKey(strArr[0])) {
                                continue;
                            }
                            if("name".equals(strArr[0]) || "context-url".equals(strArr[0]) || "port".equals(strArr[0])) {
                                map.put("application."+strArr[0],strArr[1]);
                            }else {
                                map.put(strArr[0],strArr[1]);
                            }
                        }
                }
                    System.out.println();

                    System.out.println("File Read Successfully.... \n");
        }catch (IOException ex) {
            System.out.println("An Error Occurred");
        }
        return "Read Successfully";
    }


//    Method use for displaying persed contents in map
    public String viewFileContent() {
        System.out.println("______________________________________");
        System.out.println("Running Environment: "+map.get("mode"));
        System.out.println("____________________________________");
        System.out.println("Keys <------> Values");
        System.out.println("___________________________________");
        for (Map.Entry<String,String> map : map.entrySet()) {
            System.out.println(map.getKey() + "  =  " + map.getValue());
        }
        return "Displayed successfully";
    }
}












