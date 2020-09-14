package PageObject.Users;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static PageObject.Users.UsersInfo.*;

import static PageObject.Users.UsersInfo.emailNameOfTestedUser;
import static PageObject.Users.UsersInfo.nameOfTestedUser;


public class Users extends BasePage {
    public Users(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[contains(text(),'"+nameOfTestedUser+"')]")
    private WebElement nameOfAutomatedTestUser;
    @FindBy (xpath = "//div[@id='2']")
    private WebElement nameOfAutomatedTestUserInOverview;
    @FindBy (xpath = "//span[contains(text(),'"+emailNameOfTestedUser+"')]")
    private WebElement emailNameOfAutomatedTestUserInOverview;
    @FindBy(xpath = "//span[contains(text(),'"+jobTitleOfTestedUser+"')]")
    private WebElement jobTitleOfAutomatedTestUserInOverview;
    @FindBy (xpath = "//span[contains(text(),'"+departmentOfTestedUser+"')]")
    private WebElement departmentOfAutomatedTestUserInOverview;
    @FindBy (xpath = "//span[contains(text(),'"+phoneNumberOfTestedUser+"')]")
    private WebElement phoneNumberOfAutomatedTestUserInOverview;

    public Users navigateToUserInfo() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(nameOfAutomatedTestUser, nameOfTestedUser));
        nameOfAutomatedTestUser.click();
        return this;
    }

    public String getNameOfAutomatedTestUserInOverview() {
        return nameOfAutomatedTestUserInOverview.getText();
    }

    public WebElement getEmailNameOfAutomatedTestUserInOverview() {
        return emailNameOfAutomatedTestUserInOverview;
    }

    public WebElement getJobTitleOfAutomatedTestUserInOverview() {
        return jobTitleOfAutomatedTestUserInOverview;
    }

    public WebElement getDepartmentOfAutomatedTestUserInOverview() {
        return departmentOfAutomatedTestUserInOverview;
    }

    public WebElement getPhoneNumberOfAutomatedTestUserInOverview() {
        return phoneNumberOfAutomatedTestUserInOverview;
    }




}

