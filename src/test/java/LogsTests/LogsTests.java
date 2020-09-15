package LogsTests;

import BrowsersAndListeners.Browser;
import PageObject.Constants;
import PageObject.Logs.Logs;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogsTests extends Browser {
    private Logs log;

    @BeforeClass
    public void setUp() {
        WebDriver webDriver = Browser.getInstance();
        log = new Logs(driver);
        log.logIn();
    }

    @BeforeMethod
    public void basePageForTest() {
        log.openPage(Constants.logsUrlEmail);
    }

    @Test
    public void checkInfo() {
log.getValueFromCell(1,"Scan result");
        System.out.println(log.getValueFromCell(1,"Scan result"));
    }


    @AfterClass
    public void tearDown() {
        Browser.killDriverInstance();
    }

}
