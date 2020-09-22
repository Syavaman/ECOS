package LogsTests;

import BrowsersAndListeners.Browser;
import PageObject.Constants;
import PageObject.Logs.Logs;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
    public void checkSpam() {
        log.sendAndCheckDetectionOfLetter("Spam");
        String spamResult = log.getValueFromCell(1, "Scan result");
        Assert.assertEquals(spamResult, "Spam");
    }

    @Test
    public void checkPhishing() {
        log.sendAndCheckDetectionOfLetter("Phishing");
        String phishingResult = log.getValueFromCell(1, "Scan result");
        Assert.assertEquals(phishingResult, "Phishing");
    }
    @Test
    public void checkMalware() {
        log.sendAndCheckDetectionOfLetter("Malware");
        String malwareResult = log.getValueFromCell(1, "Scan result");
        Assert.assertEquals(malwareResult, "Malware");
    }


    @AfterClass
    public void tearDown() {
        Browser.killDriverInstance();
    }

}
