package service;

import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key){
        return new String(resourceBundle.getString(key).getBytes(StandardCharsets.UTF_8));
    }
}
