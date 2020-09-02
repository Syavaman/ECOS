package TopHeadingsAndRedirection;

import BrowsersAndListeners.Browser;
import PageObject.Constants;
import PageObject.TopHeadings.TopHeadings;
import PageObject.Users.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopHeadingsAndRedirectionTests extends Browser {
    private TopHeadings topHeadings;
    private Constants constant;

    @BeforeClass
    public void setUp(){
        WebDriver webDriver = Browser.getInstance();
        constant = new Constants();
        topHeadings = new TopHeadings(driver);
        topHeadings.logIn();
    }

    @BeforeMethod
    public void basePageForTest(){
    topHeadings.openPage(Constants.DashboardUrl);
    }

    @Test
    public void checkNotifications() {
        topHeadings.clickHeadersButton();
        String notificationHeader = topHeadings.getNotificationsHeader();
        Assert.assertEquals("Notifications", notificationHeader, "Notification tab has not been opened");
        topHeadings.clickHeadersButton();
        WebElement notifHead = topHeadings.getNotificationElement();
        Assert.assertFalse(notifHead.isDisplayed(), "Notification tab has not been closed");
    }


    @Test
    public void checkNewPolicyRedirection (){
        topHeadings.checkQuickLinksRedirection(topHeadings.getQuickLinksNewPolicy());
        Assert.assertTrue(topHeadings.getQuickLinksNewPolicyMenu().isDisplayed(), "New Policy menu from QuickLinks was not displayed");
    }

    @Test
    public void checkAssignPolicyRedirection (){
        topHeadings.checkQuickLinksRedirection(topHeadings.getQuickLinksAssignPolicy());
        Assert.assertTrue(topHeadings.getQuickLinksAssignPolicyMenu().isDisplayed(), "Assign Policy menu from QuickLinks was not displayed");
    }

    @Test
    public void checkAddTenantRedirection (){
        topHeadings.checkQuickLinksRedirection(topHeadings.getQuickLinksAddTenant());
        Assert.assertTrue(topHeadings.getQuickLinksAddTenantMenu().isDisplayed(), "Add Tenant menu from QuickLinks was not displayed");
    }

    @Test
    public void checkProtectUsersRedirection (){
        topHeadings.checkQuickLinksRedirection(topHeadings.getQuickLinksProtectUsers());
        Assert.assertTrue(topHeadings.getQuickLinksProtectUsersMenu().isDisplayed(), "Protect users menu from QuickLinks was not displayed");
    }

    @Test
    public  void checkKnowledgeBaseHelpRedirection(){
        topHeadings.helpRedirections(topHeadings.getHelpKnowledgeBasePage());
        Assert.assertTrue(topHeadings.getHelpKnowledgeBasePageVerifier().isDisplayed(), "Eset KnowledgeBase has not been opened");
        topHeadings.closeHelpRedirectionPage();
    }

    @Test
    public  void checkSupportForumHelpRedirection(){
        topHeadings.helpRedirections(topHeadings.getHelpSupportForumPage());
        Assert.assertTrue(topHeadings.getHelpSupportForumPageVerifier().isDisplayed(), "Eset Support Forum Page has not been opened");
        topHeadings.closeHelpRedirectionPage();
    }
    @Test
    public  void checkSubmitFeedBackHelpRedirection(){
        topHeadings.helpRedirections(topHeadings.getHelpSubmitFeedBack());
        Assert.assertTrue(topHeadings.getHelpSubmitFeedBackMenu().isDisplayed(), "Eset Support Forum Page has not been opened");
    }

    @Test
    public void checkProfileNameHeader(){
        topHeadings.getProfileHeader().click();
        Assert.assertEquals(topHeadings.getProfileEmail(),constant.accountName, "Name of account is not correct" );
    }


    @AfterClass
    public void tearDown (){
        Browser.killDriverInstance();
    }
}
