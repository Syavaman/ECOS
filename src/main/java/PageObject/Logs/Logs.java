package PageObject.Logs;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;


public class Logs extends BasePage {
    public Logs(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[contains(text(),'Exchange Online')]")
    private WebElement exchangeOnlineLogsTab;


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


}


