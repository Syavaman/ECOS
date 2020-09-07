package Dashboard;

import BrowsersAndListeners.Browser;
import PageObject.Constants;
import PageObject.Dashboard.DashBoard;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        dashboard.openPage(Constants.dashboardUrl);
    }

    @Test
    public void checkPresenceOfTimePeriods() {
        SoftAssert soft = new SoftAssert();
        dashboard.getTimePeriodTile().click();
        soft.assertEquals(dashboard.getTimePeriod24Hours(), "Last 24 hours", "Time Period `Last 24 hours` is not present");
        soft.assertEquals(dashboard.getTimePeriod7Days(), "Last 7 days", "Time Period `Last 7 days` is not present");
        soft.assertEquals(dashboard.getTimePeriod30Days(), "Last 30 days", "Time Period `Last 7 days` is not present");
        soft.assertAll();

    }

    @Test
    public void checkPresenceOfOverviewTabTiles() {
        SoftAssert soft = new SoftAssert();
        dashboard.clickOverviewTabBttn();
        soft.assertTrue(dashboard.getLicenseUsageOverviewTile().isDisplayed(), "License Usage Tile is not present");
        soft.assertTrue(dashboard.getTopSpamRecipientsOverviewTile().isDisplayed(), "Top Spam Recipients Tile is not present");
        soft.assertTrue(dashboard.getTopMalwareRecipientsOverviewTile().isDisplayed(), "Top Malware Recipients Tile is not present");
        soft.assertTrue(dashboard.getTopPhishingRecipientsOverviewTile().isDisplayed(), "Top Phishing Recipients Tile is not present");
        soft.assertTrue(dashboard.getTopSuspiciousOneDriveAccountsOverviewTile().isDisplayed(), "OneDrive Tile is not present");
        soft.assertAll();
    }

    @Test
    public void checkPresenceOfExchangeOnlineTiles() {
        SoftAssert soft = new SoftAssert();
        dashboard.clickExchangeOnlineTabBttn();
        soft.assertTrue(dashboard.getSpamTrafficExchangeOnlineTile().isDisplayed(), "Spam Traffic table is not present");
        soft.assertTrue(dashboard.getMalwareTrafficExchangeOnlineTile().isDisplayed(), "Malware Traffic table is not present");
        soft.assertTrue(dashboard.getPhishingTrafficExchangeOnlineTile().isDisplayed(), "Phishing Traffic table is not present");
        soft.assertAll();
    }

    @Test
    public void checkPresenceOfOnedriveTile(){
        dashboard.clickOneDriveTabBttn();
        Assert.assertTrue(dashboard.getMalwareTrafficOnedriveTile().isDisplayed(), "Malware traffic table is not present");
    }

    @AfterClass
    public void tearDown() {
        Browser.killDriverInstance();
    }

}


