package steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocalConfigReader {

    public static Properties properties = new Properties();
    FileInputStream fileInputStream = null;

    public LocalConfigReader() throws IOException {
        String configurationPath = "credentials.properties";
        try {
            fileInputStream = new FileInputStream(configurationPath);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(configurationPath + " was not found");
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    public static String getReportPortalLogin() {
        String login = properties.getProperty("reportPortalLogin");
        if (login != null)
            return login;
        else
            throw new RuntimeException("Report Portal login is not specified in the credentials.properties file.");
    }

    public static String getReportPortalPassword() {
        String password = properties.getProperty("reportPortalPassword");
        if (password != null)
            return password;
        else
            throw new RuntimeException("Report Portal password not specified in the credentials.properties file.");
    }
}
