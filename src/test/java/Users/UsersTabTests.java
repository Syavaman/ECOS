package Users;

import BrowsersAndListeners.Browser;
import PageObject.Constants;
import PageObject.Users.Users;
import PageObject.Users.UsersInfo;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UsersTabTests extends Browser {
    private Users user;
    private Constants constant;
    private UsersInfo userInfo;

    @BeforeClass
    public void setUp(){
        WebDriver webDriver = Browser.getInstance();
        constant = new Constants();
        user = new Users(driver);
        userInfo = new UsersInfo();
        user.logIn();
    }

    @BeforeMethod
    public void basePageForTest(){
        user.openPage(Constants.usersUrl);
    }

    @Test
    public void checkUsersInfo(){
        user.navigateToUserInfo();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(user.getNameOfAutomatedTestUserInOverview().equals(userInfo.nameOfTestedUser),"Problem with displaying name of tested user");
        soft.assertTrue(user.getEmailNameOfAutomatedTestUserInOverview().isDisplayed(),"Problem with displaying email of tested user");
        soft.assertTrue(user.getJobTitleOfAutomatedTestUserInOverview().isDisplayed(),"Problem with displaying job title of tested user");
        soft.assertTrue(user.getDepartmentOfAutomatedTestUserInOverview().isDisplayed(),"Problem with displaying department of tested user");
        soft.assertTrue(user.getPhoneNumberOfAutomatedTestUserInOverview().isDisplayed(),"Problem with displaying phone number of tested user");
        soft.assertAll("Some info is not shown properly");
    }



    @AfterClass
    public void tearDown (){
        Browser.killDriverInstance();
    }
}
