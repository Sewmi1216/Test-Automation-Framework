package page_object_model.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //    @FindBy(xpath = "//button[@dfd-value-term='Fresh Flowers']")
//    public WebElement selectDropDown;
//
//    @FindBy(xpath = "//a[text()='New Arrivals']")
//    public WebElement selectNewArrivals;
//
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

    String visibleText = "";


    public void typeTextToSearchBar(String searchText) {
        searchBar.sendKeys(searchText + Keys.ENTER);
    }

    //    public void selectItem(String visibleText) {
//        this.visibleText = visibleText;
//        new Select(selectDropDown).selectByVisibleText(visibleText);
//    }
//
//    public NewArrivalsPage clickNewArrivals() {
//        selectNewArrivals.click();
//        return PageFactory.initElements(driver, NewArrivalsPage.class);
//    }
//
    public void clickCategory() {
        dropDown.click();
    }
    public void clickChocolates() {
        selectChocolates.click();
    }
    public ComboGiftPackPage clickComboGiftPacks() {
        selectComboGiftPacks.click();
        return PageFactory.initElements(driver, ComboGiftPackPage.class);
    }
    public ChocolatePage clickKaprukaChocolates() {
        selectKaprukaChocolates.click();
        return PageFactory.initElements(driver, ChocolatePage.class);
    }
    public FlowerPage clickFlowerShop() {
        selectFlowerShop.click();
        return PageFactory.initElements(driver, FlowerPage.class);
    }

    public OrderStatusPage clickOrderStatus() {
        selectOrderStatus.click();
        return PageFactory.initElements(driver, OrderStatusPage.class);
    }

//    public <T> T clickButton() {
//        button.click();
//        if (visibleText.equals("Cell Phones & Accessories")) {
//            return (T) PageFactory.initElements(driver, EbayPhonePage.class);
//        } else {
//            return (T) PageFactory.initElements(driver, EbayClothesPage.class);
//        }
//    }
}
