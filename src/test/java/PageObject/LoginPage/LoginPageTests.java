package PageObject.LoginPage;
import BrowsersAndListeners.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTests extends Browser {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        WebDriver webDriver = Browser.getInstance();
        loginPage = new LoginPage(driver);
        loginPage.openPage();
    }
    @Test(priority = 1)
    public void checkHelpPageRedirection() {
        loginPage.ClickHelpPageButton();
        String test1 = loginPage.getHPH();
        Assert.assertEquals("ESET Online Help", test1, "Help page has not been opened");
    }

    @Test(priority = 1)
    public void InvalidLogin() {
        loginPage.logIn("testInval@ukr.net", "testInvalidPassword");
        String error = loginPage.geterrorInvPassLog();
        Assert.assertEquals("Invalid password or email.", error, "Error header about entering invalid credentials was not shown");

    }

    @Test(priority = 1)
    public void EmptyEmail() {
        loginPage.typePassword("Passw0rd123_");
        loginPage.clickLogInButton();
        String error = loginPage.geterrorEmptyEmail();
        Assert.assertEquals("Email is required", error, "Header `Email is required` has not appeared ");
    }

    @Test(priority = 1)
    public void EmptyPassword() {
        loginPage.typeUserName("test123@email.com");
        loginPage.clickPasswordField();
        loginPage.clickLogInButton();
        String error = loginPage.geterrorEmptyPassword();
        Assert.assertEquals("Password is required", error, "Header `Password is required` has not appeared ");
    }


    @Test(priority = 1)
    public void checkForgottenPassword() {
        loginPage.ForgottenPasswordPage();
        String text = loginPage.getFPH();
        Assert.assertEquals("Forgotten password", text, "Forgotten password link has not been opened");
    }

    @Test(priority = 2)
    public void checkValidLogIn(){
        loginPage.logIn();
        Assert.assertTrue(loginPage.logOutBttn().isDisplayed(),"User was not logged in");
    }

    @Test(priority = 3)
    public void checkLogOut(){
        loginPage.logOutBttn().click();
        Assert.assertEquals("Log in",loginPage.getHeadingText(), "User was not Logged Out");
    }



@AfterClass
    public void tearDown (){
        Browser.killDriverInstance();
}
}
