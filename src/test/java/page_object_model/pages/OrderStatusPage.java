package page_object_model.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrderStatusPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public OrderStatusPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='referenceID']")
    public WebElement searchBar;

    @FindBy(xpath = "//input[@value='Show My Order Status']")
    private WebElement showOrderStatusButton;

    @FindBy(xpath = "//font[@color='red' and text()='You have entered an invalid reference number']")
    private WebElement invalidReferenceMessage;

    public void clickShowOrderStatusBtn() {
        logger.info("Clicking on the 'Show my Order status' button.");
        showOrderStatusButton.click();
        Assert.assertTrue(invalidReferenceMessage.isDisplayed(), "Error message for invalid reference number is not displayed.");
        Assert.assertEquals(invalidReferenceMessage.getText(), "You have entered an invalid reference number", "The error message text is incorrect.");
    }

    public void typeTextToSearchBar(String searchText) {
        searchBar.sendKeys(searchText);
    }


}
