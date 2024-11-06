package page_object_model.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Chocolates']")
    public WebElement selectChocolates;

    @FindBy(xpath = "//span[text()='Kapruka Chocolates']")
    public WebElement selectKaprukaChocolates;

    @FindBy(xpath = "//span[text()='Combo Gift Packs']")
    public WebElement selectComboGiftPacks;

    @FindBy(xpath = "//span[text()='Flower Shop']")
    public WebElement selectFlowerShop;

    @FindBy(xpath = "//a[@aria-label='Check Order Status']")
    public WebElement selectOrderStatus;

    @FindBy(xpath = "//input[@id='search_bar_id']")
    public WebElement searchBar;

    @FindBy(xpath = "//div[text()='All Categories']")
    public WebElement dropDown;

    @FindBy(xpath = "//div[@class='CatalogueV2Design']")
    private WebElement searchResultsContainer;

    public void typeTextToSearchBar(String searchText) {
        logger.info("Typing text into the search bar: " + searchText);
        searchBar.sendKeys(searchText + Keys.ENTER);
    }

    public void clickCategory() {
        logger.info("Clicking on the 'All Categories' dropdown.");
        dropDown.click();
    }

    public void clickChocolates() {
        logger.info("Selecting 'Chocolates' category.");
        selectChocolates.click();
    }

    public ComboGiftPackPage clickComboGiftPacks() {
        logger.info("Navigating to 'Combo Gift Packs' page.");
        selectComboGiftPacks.click();
        return PageFactory.initElements(driver, ComboGiftPackPage.class);
    }

    public ChocolatePage clickKaprukaChocolates() {
        logger.info("Navigating to 'Kapruka Chocolates' page.");
        selectKaprukaChocolates.click();
        return PageFactory.initElements(driver, ChocolatePage.class);
    }

    public FlowerPage clickFlowerShop() {
        logger.info("Navigating to 'Flower Shop' page.");
        selectFlowerShop.click();
        return PageFactory.initElements(driver, FlowerPage.class);
    }

    public OrderStatusPage clickOrderStatus() {
        logger.info("Navigating to 'Order Status' page.");
        selectOrderStatus.click();
        return PageFactory.initElements(driver, OrderStatusPage.class);
    }

    public boolean isSearchResultDisplayed(String searchItem) {
        try {
            logger.info("Verifying if search results are displayed for: " + searchItem);
            return searchResultsContainer.isDisplayed() &&
                    searchResultsContainer.getText().contains(searchItem);
        } catch (Exception e) {
            logger.error("Error verifying search results for item: " + searchItem, e);
            return false;
        }
    }
    public boolean isCategoryDataDisplayed() {
        try {
            return searchResultsContainer.isDisplayed();
        } catch (Exception e) {
            logger.error("Error verifying category data", e);
            return false;
        }
    }

}
