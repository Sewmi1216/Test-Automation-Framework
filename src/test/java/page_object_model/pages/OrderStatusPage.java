package page_object_model.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderStatusPage extends BasePage{
    public OrderStatusPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='referenceID']")
    public WebElement searchBar;

    public void typeTextToSearchBar(String searchText) {
        searchBar.sendKeys(searchText);
    }
}
