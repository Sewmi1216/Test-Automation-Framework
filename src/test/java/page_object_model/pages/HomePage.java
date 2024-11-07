package page_object_model.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(xpath = "//span[text()='Food / Restaurants']")
    public WebElement selectFood;

    @FindBy(xpath = "//a[@aria-label='Check Order Status']")
    public WebElement selectOrderStatus;

    @FindBy(xpath = "//input[@id='search_bar_id']")
    public WebElement searchBar;

    @FindBy(xpath = "//div[text()='All Categories']")
    public WebElement dropDown;

    @FindBy(xpath = "//div[@class='CatalogueV2Design']")
    private WebElement searchResultsContainer;

    @FindBy(xpath = "//div[@class='food_content_set']")
    private WebElement foodContainer;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selectComboGiftPacks));
        logger.info("Navigating to 'Combo Gift Packs' page.");
        selectComboGiftPacks.click();
        return PageFactory.initElements(driver, ComboGiftPackPage.class);
    }

    public ChocolatePage clickKaprukaChocolates() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selectKaprukaChocolates));
        logger.info("Navigating to 'Kapruka Chocolates' page.");
        selectKaprukaChocolates.click();
        return PageFactory.initElements(driver, ChocolatePage.class);
    }

    public FlowerPage clickFlowerShop() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selectFlowerShop));
        logger.info("Navigating to 'Flower Shop' page.");
        selectFlowerShop.click();
        return PageFactory.initElements(driver, FlowerPage.class);
    }

    public OrderStatusPage clickOrderStatus() {
        logger.info("Navigating to 'Order Status' page.");
        selectOrderStatus.click();
        return PageFactory.initElements(driver, OrderStatusPage.class);
    }
    public FoodPage clickFoods() {
        logger.info("Navigating to 'Foods' page.");
        selectFood.click();
        return PageFactory.initElements(driver, FoodPage.class);
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
    public boolean isFoodDisplayed() {
        try {
            return foodContainer.isDisplayed();
        } catch (Exception e) {
            logger.error("Error verifying food data", e);
            return false;
        }
    }

}
