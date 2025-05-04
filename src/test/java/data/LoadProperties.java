package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    // Load properties from a file or environment variable
public static Properties userData=LoadProperties(System.getProperty("user.dir") + "\\src\\test\\java\\data\\signUpData.properties");
private static Properties LoadProperties(String path) {
    Properties properties = new Properties();
    try {
        FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);
    } catch (FileNotFoundException e) {

        System.out.println("error eccured " + e.getMessage());

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return properties;
}

}
