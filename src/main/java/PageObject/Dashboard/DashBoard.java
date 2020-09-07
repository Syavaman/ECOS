package PageObject.Dashboard;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DashBoard extends BasePage {
    public DashBoard(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='css-bg1rzq-control select__control']")
    private WebElement timePeriodTile;
    @FindBy(xpath = "//div[@id='react-select-2-option-0']")
    private WebElement timePeriod24Hours;
    @FindBy(xpath = "//div[@id='react-select-2-option-1']")
    private WebElement timePeriod7Days;
    @FindBy(xpath = "//div[@id='react-select-2-option-2']")
    private WebElement timePeriod30Days;

    @FindBy(xpath = "//div[contains(@class, 'TabNavItem') and text() = 'Overview']")
    private WebElement overviewTabBttn;
    @FindBy(xpath = "//div[contains(@class, 'TabNavItem') and text() = 'Exchange Online']")
    private WebElement exchangeOnlineTabBttn;
    @FindBy(xpath = "//div[contains(@class, 'TabNavItem') and text() = 'Exchange Online']")
    private WebElement oneDriveTabBttn;

    @FindBy(xpath = "//p[contains(text(),'License usage')]")
    private WebElement licenseUsageOverviewTile;
    @FindBy(xpath = "//p[contains(text(),'Top spam recipients')]")
    private WebElement topSpamRecipientsOverviewTile;
    @FindBy(xpath = "//p[contains(text(),'Top malware recipients')]")
    private WebElement topMalwareRecipientsOverviewTile;
    @FindBy(xpath = "//p[contains(text(),'Top phishing recipients')]")
    private WebElement topPhishingRecipientsOverviewTile;
    @FindBy(xpath = "//p[contains(text(),'Top suspicious OneDrive accounts')]")
    private WebElement topSuspiciousOneDriveAccountsOverviewTile;

    @FindBy(xpath = "//p[contains(text(),'Spam traffic')]")
    private WebElement spamTrafficExchangeOnlineTile;
    @FindBy(xpath = "//p[contains(text(),'Malware traffic')]")
    private WebElement malwareTrafficExchangeOnlineTile;
    @FindBy(xpath = "//p[contains(text(),'Phishing traffic')]")
    private WebElement phishingTrafficExchangeOnlineTile;

    @FindBy(xpath = "//p[contains(text(),'Malware traffic')]")
    private WebElement malwareTrafficOnedriveTile;


    public WebElement getTimePeriodTile() {
        return timePeriodTile;
    }

    public String getTimePeriod24Hours() {
        return timePeriod24Hours.getText();
    }

    public String getTimePeriod7Days() {
        return timePeriod7Days.getText();
    }

    public String getTimePeriod30Days() {
        return timePeriod30Days.getText();
    }

    public DashBoard clickOverviewTabBttn() {
        overviewTabBttn.click();
        return this;
    }

    public DashBoard clickExchangeOnlineTabBttn() {
        exchangeOnlineTabBttn.click();
        return this;
    }

    public DashBoard clickOneDriveTabBttn() {
        oneDriveTabBttn.click();
        return this;
    }

    public WebElement getLicenseUsageOverviewTile() {
        return licenseUsageOverviewTile;
    }

    public WebElement getTopSpamRecipientsOverviewTile() {
        return topSpamRecipientsOverviewTile;
    }

    public WebElement getTopMalwareRecipientsOverviewTile() {
        return topMalwareRecipientsOverviewTile;
    }

    public WebElement getTopPhishingRecipientsOverviewTile() {
        return topPhishingRecipientsOverviewTile;
    }

    public WebElement getTopSuspiciousOneDriveAccountsOverviewTile() {
        return topSuspiciousOneDriveAccountsOverviewTile;
    }

    public WebElement getSpamTrafficExchangeOnlineTile() {
        return spamTrafficExchangeOnlineTile;
    }

    public WebElement getMalwareTrafficExchangeOnlineTile() {
        return malwareTrafficExchangeOnlineTile;
    }

    public WebElement getPhishingTrafficExchangeOnlineTile() {
        return phishingTrafficExchangeOnlineTile;
    }
    public WebElement getMalwareTrafficOnedriveTile() {
        return malwareTrafficOnedriveTile;
    }
}