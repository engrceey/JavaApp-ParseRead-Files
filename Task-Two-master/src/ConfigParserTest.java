import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

class ConfigParserTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Exercute method for reading file and persing to map")
    void executeApp() {
        File name_of_file = new File("config.txt");
        ConfigParser configParser = new ConfigParser(name_of_file);
        Assertions.assertEquals(configParser.executeApp(),"Read Successfully");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("View method use for displaying map contents")
    void viewFileContent() {
        File name_of_file = new File("config.txt");
        ConfigParser configParser = new ConfigParser(name_of_file);
        Assertions.assertEquals(configParser.viewFileContent(),"Displayed successfully");
    }
}