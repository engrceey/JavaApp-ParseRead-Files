import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

//        Print Statements for app direction
        System.out.println();
        System.out.println("Welcome Change Work Environment Through Command Line Argument:\n" +
                "Production   = java Main.java\n" +
                "Staging      = java Main.java staging \n" +
                "Development  = java Main.java development");

//        IF statement to determine the file to Read
        String selectedArguments = "";
            if (args.length == 0 || "production".equals(args[0].toLowerCase())) {
                selectedArguments = "src/config.txt";
            } else if ("staging".equals(args[0].toLowerCase())) {
                selectedArguments = "src/config-staging.txt";
            } else if ("development".equals(args[0].toLowerCase())) {
                selectedArguments = "src/config-dev.txt";
            }else {
                throw new IOException("Incorrect input");
            }


        File name_of_file = constructPath(selectedArguments);

//      ConfigParser Instance used to access file
        ConfigParser configParser = new ConfigParser(name_of_file);
        configParser.executeApp();
        configParser.viewFileContent();
        System.out.println();

        //    To get values of keys pass key into the method
//        Scanner is used for better user experience
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter key below get value");
            System.out.println("-------------------------");
            String key = scanner.next();
            scanner.nextLine();
            System.out.println(configParser.get(key));
        }catch (Exception ex) {
            System.out.println("Incorrect input");
        }


    }

    //    A method used to set file path for compiling
    public static File constructPath(String path) {
        File relPath = new File(path);
        String absPath = relPath.getAbsolutePath();
        path = absPath.substring(0, absPath.indexOf("src")) + path;
        return new File(path);
    }
}
