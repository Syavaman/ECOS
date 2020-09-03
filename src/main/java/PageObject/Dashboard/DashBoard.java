package PageObject.Dashboard;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoard extends BasePage {
    public DashBoard(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@class='css-bg1rzq-control select__control']")
    private WebElement timePeriodTile;
    @FindBy (xpath = "//div[@id='react-select-2-option-0']")
    private WebElement timePeriod24Hours;
    @FindBy (xpath = "//div[@id='react-select-2-option-1']")
    private WebElement timePeriod7Days;
    @FindBy (xpath = "//div[@id='react-select-2-option-2']")
    private WebElement timePeriod30Days;


    public WebElement getTimePeriodTile (){return timePeriodTile;}
    public String getTimePeriod24Hours(){return timePeriod24Hours.getText();}
    public String getTimePeriod7Days(){return timePeriod7Days.getText();}
    public String getTimePeriod30Days(){return timePeriod30Days.getText();}

}