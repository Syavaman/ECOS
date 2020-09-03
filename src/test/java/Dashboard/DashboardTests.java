package Dashboard;

import BrowsersAndListeners.Browser;
import PageObject.Constants;
import PageObject.Dashboard.DashBoard;
import PageObject.TopHeadings.TopHeadings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DashboardTests extends Browser {
    private DashBoard dashboard;
    private Constants constant;

    @BeforeClass
    public void setUp() {
        WebDriver webDriver = Browser.getInstance();
        constant = new Constants();
        dashboard = new DashBoard(driver);
        dashboard.logIn();
    }

    @BeforeMethod
    public void basePageForTest() {
        dashboard.openPage(Constants.DashboardUrl);
    }

    @Test
    public void checkPresenceOfTimePeriods(){
        SoftAssert soft = new SoftAssert();
        dashboard.getTimePeriodTile().click();
        soft.assertEquals(dashboard.getTimePeriod24Hours(),"Last 24 hours");
        soft.assertEquals(dashboard.getTimePeriod7Days(), "Last 7 days");
        soft.assertEquals(dashboard.getTimePeriod30Days(),"Last 30 days");
        soft.assertAll();

    }

    @AfterClass
    public void tearDown() {
        Browser.killDriverInstance();
    }

}


