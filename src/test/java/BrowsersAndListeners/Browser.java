package BrowsersAndListeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver = null;

    public enum Browsers {chrome, firefox};

    public static WebDriver getInstance() {
        String browser = System.getProperty("browser");
        if (driver == null) {
            if (browser.equals(Browsers.firefox.name())) {
                System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equals(Browsers.chrome.name())) {
                System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else {
                throw new UnsupportedOperationException("Unknown browser " + browser);
            }
            System.out.println("Instance of driver is : " + browser);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void killDriverInstance() {
        driver.quit();
        driver = null;
        System.out.println("Browser is closed");
    }
}
