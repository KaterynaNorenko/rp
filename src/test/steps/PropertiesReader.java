package steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties properties = new Properties();

    FileInputStream fileInputStream = null;

    public PropertiesReader(String propertyFileName) throws IOException {
        String propertyFilePath = "configuration/" + propertyFileName;
        try {
            fileInputStream = new FileInputStream(propertyFilePath);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(propertyFileName + " was not found at " + propertyFilePath);
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    public String getUrl(String urlName) {
        String url = properties.getProperty(urlName);
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException(urlName + " is not specified in the configuration.properties file");
        }
    }
}
