package PageObject.Logs;

import PageObject.BasePage;
import PageObject.SendMail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;


public class Logs extends BasePage {
    public Logs(WebDriver driver) {
        super(driver);
    }

    SendMail mail;


    @FindBy(xpath = "//div[contains(text(),'Exchange Online')]")
    private WebElement exchangeOnlineLogsTab;
    @FindBy(css = "#filter-refresh-icon")
    private WebElement refreshButton;


    public int numberOfColumn(String nameOfColumn) {
        HashMap<String, Integer> namesOfTheColumns = new HashMap<String, Integer>();
        namesOfTheColumns.put("Details", 0);
        namesOfTheColumns.put("Date", 1);
        namesOfTheColumns.put("Mailbox", 2);
        namesOfTheColumns.put("From", 3);
        namesOfTheColumns.put("To", 4);
        namesOfTheColumns.put("Subject", 5);
        namesOfTheColumns.put("Scan result", 6);
        int columNumber = namesOfTheColumns.get(nameOfColumn);
        return columNumber;
    }

    public String getValueFromCell(int row, String L) {
        int columnNumber = numberOfColumn(L);
        int rowNumber = row - 1;
        String valueResultName = driver.findElement(By.xpath("//div[@id='r:" + rowNumber + ", c:" + columnNumber + "']/div")).getText();
        return valueResultName;
    }


    public Logs sendAndCheckDetectionOfLetter(String typeOfLetter) {
        mail = new SendMail();
        mail.sendMail(typeOfLetter);
        refreshButton.click();
        String threat = typeOfLetter;
        WebElement checkedElement = driver.findElement(By.xpath("//div[@id='r:0, c:6']//div"));
        Wait<WebDriver> wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(checkedElement, typeOfLetter));
        return this;
    }

}


