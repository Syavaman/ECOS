package PageObject.TopHeadings;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class TopHeadings extends BasePage {
    public TopHeadings(WebDriver driver) {
        super(driver);
    }

    private String ecosPage = driver.getWindowHandle();

    @FindBy(xpath = "//a[@id='header-notifications']")
    private WebElement notificationButton;
    @FindBy(xpath = "//h5[contains(text(),'Notifications')]")
    private WebElement notificationWindowHeader;

    @FindBy(xpath = "//a[@id='header-quick-links']")
    private WebElement quickLinksDropDownMenu;
    @FindBy(xpath = "//div[contains(text(),'Add tenant...')]")
    private WebElement quickLinksAddTenant;
    @FindBy(xpath = "//button[@id='provide-consent-button']")
    private WebElement quickLinksAddTenantMenu;
    @FindBy(xpath = "//div[contains(text(),'Protect users...')]")
    private WebElement quickLinksProtectUsers;
    @FindBy(xpath = "//button[@id='protect-button']")
    private WebElement quickLinksProtectUsersMenu;
    @FindBy(xpath = "//div[contains(text(),'New policy...')]")
    private WebElement quickLinksNewPolicy;
    @FindBy(xpath = "//a[contains(text(),'Create new policy')]")
    private WebElement quickLinksNewPolicyMenu;
    @FindBy(xpath = "//div[contains(text(),'Assign policy...')]")
    private WebElement quickLinksAssignPolicy;
    @FindBy(xpath = "//h5[contains(text(),'Policies')]")
    private WebElement quickLinksAssignPolicyMenu;

    @FindBy(xpath = "//a[@id='header-help']")
    private WebElement helpDropDownMenu;
    @FindBy(xpath = "//div[contains(text(),'Knowledgebase')]")
    private WebElement helpKnowledgeBasePage;
    @FindBy(xpath = "//input[@placeholder='Search the ESET Knowledgebase']")
    private WebElement helpKnowledgeBasePageVerifier;
    @FindBy(xpath = "//div[contains(text(),'Support forum')]")
    private WebElement helpSupportForumPage;
    @FindBy(xpath = "//a[contains(text(),'Forums')]")
    private WebElement helpSupportForumPageForumVerifier;
    @FindBy(xpath = "//div[contains(text(),'Submit feedback')]")
    private WebElement helpSubmitFeedBack;
    @FindBy(xpath = "//div[@class='Modal__title--2b5VMoBy8y']")
    private WebElement helpSubmitFeedBackMenu;

    @FindBy(xpath = "//a[@id='header-profile']")
    private WebElement profileHeader;
    @FindBy(xpath = "//div/b")
    private WebElement profileEmail;


    public String getNotificationsHeader() {
        return notificationWindowHeader.getText();
    }

    public WebElement getNotificationElement() {
        return notificationWindowHeader;
    }

    public TopHeadings clickHeadersButton() {
        notificationButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public TopHeadings checkQuickLinksRedirection(WebElement test) {
        quickLinksDropDownMenu.click();
        test.click();
        return this;
    }

    public WebElement getQuickLinksDropDownMenu() {
        return quickLinksDropDownMenu;
    }

    public WebElement getQuickLinksNewPolicy() {
        return quickLinksNewPolicy;
    }

    public WebElement getQuickLinksNewPolicyMenu() {
        return quickLinksNewPolicyMenu;
    }

    public WebElement getQuickLinksAssignPolicy() {
        return quickLinksAssignPolicy;
    }

    public WebElement getQuickLinksAssignPolicyMenu() {
        return quickLinksAssignPolicyMenu;
    }

    public WebElement getQuickLinksAddTenant() {
        return quickLinksAddTenant;
    }

    public WebElement getQuickLinksAddTenantMenu() {
        return quickLinksAddTenantMenu;
    }

    public WebElement getQuickLinksProtectUsers() {
        return quickLinksProtectUsers;
    }

    public WebElement getQuickLinksProtectUsersMenu() {
        return quickLinksProtectUsersMenu;
    }

    public TopHeadings helpRedirections(WebElement helpUrl) {

        helpDropDownMenu.click();
        helpUrl.click();
        Set handles = driver.getWindowHandles();
        for (String handle1 : driver.getWindowHandles()) {
            System.out.println(handles);
            System.out.println(handle1);
            driver.switchTo().window(handle1);
        }
        return this;
    }

    public TopHeadings closeHelpRedirectionPage() {
        driver.close();
        driver.switchTo().window(ecosPage);
        return this;
    }

    public WebElement getHelpKnowledgeBasePage() {
        return helpKnowledgeBasePage;
    }

    public WebElement getHelpKnowledgeBasePageVerifier() {
        return helpKnowledgeBasePageVerifier;
    }

    public WebElement getHelpSupportForumPage() {
        return helpSupportForumPage;
    }

    public WebElement getHelpSupportForumPageVerifier() {
        return helpSupportForumPageForumVerifier;
    }

    public WebElement getHelpSubmitFeedBack() {
        return helpSubmitFeedBack;
    }

    public WebElement getHelpSubmitFeedBackMenu() {
        return helpSubmitFeedBackMenu;
    }


    public WebElement getProfileHeader() {
        return profileHeader;
    }

    public String getProfileEmail() {
        return profileEmail.getText();
    }

}
