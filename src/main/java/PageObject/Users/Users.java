package PageObject.Users;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users extends BasePage {
    public Users(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='TableFilterWrapper__tableHolder--26ko93LqZL']")
    private WebElement usersTable;

    private WebElement userTableElement;
    private WebDriver driver;

    public List<WebElement> getRows() {
        List<WebElement> rows = userTableElement.findElements(By.xpath("//div[contains(@id,\"list-of-users_row\")]"));
        return rows;
    }

    public List<WebElement> getHeadings() {
        WebElement headingsRow = userTableElement.findElement(By.xpath("//div[@class='TableHeaderScrolledParts__headerColumnsRow--12gmTRSxmy']"));
        List<WebElement> headingColumns = headingsRow.findElements(By.xpath("//div[contains(@class,\"TableHeader_\")]"));
        return headingColumns;
    }

    public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath("//div"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    public String getValueFromCell(int rowNumber, int columnNumber) {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber).get(columnNumber);
        return cell.getText();
    }

    public List<Map<String, WebElement>> getRowsWithColumnsByHeading() {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingColumns = getHeadings();
        for (List<WebElement> row : rowsWithColumns) {
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingColumns.size(); i++) {
                String heading = headingColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);
        }
        return rowsWithColumnsByHeadings;
    }

    public String getValueFromCell(int rowNumber, String columnName) {
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeading();
        return getRowsWithColumnsByHeading().get(rowNumber).get(columnName).getText();
    }
}

