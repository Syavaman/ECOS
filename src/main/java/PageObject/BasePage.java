package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//div[@id='btn-login']")
    private WebElement logInButton;
    @FindBy (xpath = "//a[@id='1']")
    private WebElement DashHeader;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openPage() {
        driver.get(Constants.urlAdress);
    }

    public void openPage (String URL){driver.get(URL);}

    public BasePage logIn (){
        openPage();
        usernameField.sendKeys(Constants.accountName);
        passwordField.sendKeys(Constants.passwordName);
        logInButton.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='1']")));
        return this;
    };


}
