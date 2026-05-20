package utils;

import java.io.FileInputStream;
import java.util.Properties;

// ConfigReader: read values from config.properties file
public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);
        } catch (Exception e) {
            System.out.println("Could not load config.properties: " + e.getMessage());
        }
    }

    // get a value from the file
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
