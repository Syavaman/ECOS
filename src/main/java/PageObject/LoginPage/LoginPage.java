package PageObject.LoginPage;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.Set;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//div[@id='btn-login']")
    private WebElement logInButton;
    @FindBy(xpath = "//a[contains(text(),'Forgotten password')]")
    private WebElement forgottenPassword;
    @FindBy(linkText = "Help")
    private WebElement helpPage;
    @FindBy(xpath = "//div[contains(text(),'Close')]")
    private WebElement closeCookiePolicy;
    @FindBy(xpath = "//div[@id='cookie-accept']")
    private WebElement cookieTable;
    @FindBy(xpath = "//h1[contains(text(),'Log in')]")
    private WebElement logInHeading;
    @FindBy(xpath = "//span[contains(text(),'Invalid password or email.')]")
    private WebElement errorInvPassLog;
    @FindBy(xpath = "//span[contains(text(),'Email is required')]")
    private WebElement errorEmptyEmail;
    @FindBy(xpath = "//span[contains(text(),'Password is required')]")
    private WebElement errorEmptyPassword;
    @FindBy(xpath = "//h1[contains(text(),'Forgotten password')]")
    private WebElement forgottenPasswordHeading;
    @FindBy(linkText = "ESET Online Help")
    private WebElement helpPageHeading;
    @FindBy(xpath = "//div[contains(text(),'Logout')]")
    private WebElement LogOut;


    public String getFPH() {
        return forgottenPasswordHeading.getText();
    }

    public String getHPH() {
        return helpPageHeading.getText();
    }

    public LoginPage typeUserName(String username) {

        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLogInButton() {
        logInButton.click();
        return this;
    }

    public WebElement cookieTable() {
        return cookieTable;
    }

    public WebElement logOutBttn() {
        return LogOut;
    }

    public LoginPage clickPasswordField() {
        passwordField.click();
        return this;
    }

    public LoginPage logIn(String username, String password) {
        this.typePassword(password);
        this.typeUserName(username);
        this.clickLogInButton();
        return this;
    }

    public String getHeadingText() {
        return logInHeading.getText();
    }

    public String geterrorInvPassLog() {
        return errorInvPassLog.getText();
    }

    public String geterrorEmptyEmail() {
        return errorEmptyEmail.getText();
    }

    public String geterrorEmptyPassword() {
        return errorEmptyPassword.getText();
    }

    public LoginPage CloseCookie() {
        closeCookiePolicy.click();
        return this;
    }

    public LoginPage ForgottenPasswordPage() {
        forgottenPassword.click();
        if (forgottenPassword.isDisplayed()) {
            forgottenPassword.click();
        }
        return this;
    }

    public LoginPage ClickHelpPageButton() {
        CloseCookie();
        String handle = driver.getWindowHandle();
        System.out.println(handle);
        helpPage.click();
        Set handles = driver.getWindowHandles();
        for (String handle1 : driver.getWindowHandles()) {
            System.out.println(handles);
            System.out.println(handle1);
            driver.switchTo().window(handle1);
        }
        return this;
    }
}
