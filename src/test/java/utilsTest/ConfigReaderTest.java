package utilsTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReaderTest {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream input = ConfigReaderTest.class.getClassLoader().getResourceAsStream("config.properties");

            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("Unable to find config.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading config.properties: " + e.getMessage());
        }
    }

    public static String getTestPlatformUrl(String name) {
        return properties.getProperty(name);
    }

    public static String getUsername(String name) {
        return properties.getProperty(name);
    }

    public static String getPassword(String name) {
        return properties.getProperty(name);
    }
}
