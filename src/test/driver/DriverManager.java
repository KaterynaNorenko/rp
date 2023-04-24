package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Optional;

public class DriverManager {
    private static final String CHROME_DRIVER_PATH_MAC_OS = "src/test/resources/chromedriver";
    private static final String CHROME_DRIVER_PATH_LINUX = "/usr/local/bin/chromedriver";
    private static final Duration IMPLICIT_WAIT_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(60);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Linux")
                                                      ? CHROME_DRIVER_PATH_LINUX
                                                      : CHROME_DRIVER_PATH_MAC_OS);
        WebDriver driver = new ChromeDriver(Capabilities.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            setupDriver();
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(WebDriver::quit);
        driverThreadLocal.remove();
    }
}
