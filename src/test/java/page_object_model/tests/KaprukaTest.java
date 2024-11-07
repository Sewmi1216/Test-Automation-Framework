package page_object_model.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object_model.pages.*;
import page_object_model.testData.DataProviderClass;
import page_object_model.utilities.Utilities;

public class KaprukaTest extends Utilities {

    private static final Logger logger = LogManager.getLogger(KaprukaTest.class);
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        homePage = basePage.loadUrl("https://www.kapruka.com/");
    }

    @Test(dataProvider = "searchData", dataProviderClass = DataProviderClass.class)
    public void searchByItem(String searchItem) {
        logger.info("Starting test for search item: " + searchItem);

        try {
            homePage.typeTextToSearchBar(searchItem);
            Assert.assertTrue(homePage.isSearchResultDisplayed(searchItem), "Search result not displayed for item: " + searchItem);
            logger.info("Test completed successfully for search item: " + searchItem);

        } catch (Exception e) {
            logger.error("Exception encountered: " + e.getMessage(), e);
            Assert.fail("Test failed due to an exception for search item: " + searchItem);
        }
    }

    @Test
    public void searchChocolates() {
        try {
            homePage.clickCategory();
            logger.info("Navigated to category page");

            homePage.clickChocolates();
            ChocolatePage chocolatePage = homePage.clickKaprukaChocolates();
            chocolatePage.clickWomen();
            Assert.assertTrue(homePage.isCategoryDataDisplayed(), "Chocolate data not displayed");
            logger.info("Completed search for chocolates.");

        } catch (Exception e) {
            logger.error("Exception encountered: " + e.getMessage(), e);
            Assert.fail("Test failed due to an exception in searchChocolates test");
        }
    }

    @Test
    public void searchComboGiftPacks() {
        try {
            homePage.clickCategory();
            ComboGiftPackPage comboGiftPackPage = homePage.clickComboGiftPacks();
            comboGiftPackPage.clickChocoGift();
            Assert.assertTrue(homePage.isCategoryDataDisplayed(), "Combo Gift Packs data not displayed");
            logger.info("Completed search for combo gift packs.");

        } catch (Exception e) {
            logger.error("Exception encountered: " + e.getMessage(), e);
            Assert.fail("Test failed due to an exception in searchComboGiftPacks test");
        }
    }

    @Test
    public void searchFlowers() {
        try {
            homePage.clickCategory();
            FlowerPage flowerPage = homePage.clickFlowerShop();
            flowerPage.clickBirthdayFlowers();
            Assert.assertTrue(homePage.isCategoryDataDisplayed(), "Birthday flowers not displayed");
            logger.info("Completed search for birthday flowers.");

        } catch (Exception e) {
            logger.error("Exception encountered: " + e.getMessage(), e);
            Assert.fail("Test failed due to an exception in searchFlowers test");
        }
    }

    @Test(dataProvider = "SearchRefNo", dataProviderClass = DataProviderClass.class)
    public void checkOrderStatus(String searchNumber) {
        try {
            OrderStatusPage orderStatusPage = homePage.clickOrderStatus();
            orderStatusPage.typeTextToSearchBar(searchNumber.toString());
            orderStatusPage.clickShowOrderStatusBtn();

        } catch (Exception e) {
            logger.error("Exception encountered: " + e.getMessage(), e);
            Assert.fail("Test failed due to an exception in checkOrderStatus test");
        }
    }

    @Test
    public void searchFoods() {
        try {
            homePage.clickCategory();
            homePage.scrollPage(50, 0);
            FoodPage foodPage = homePage.clickFoods();
            Assert.assertTrue(homePage.isFoodDisplayed(), "Foods not displayed");
            logger.info("Completed search for foods");

        } catch (Exception e) {
            logger.error("Exception encountered: " + e.getMessage(), e);
            Assert.fail("Test failed due to an exception in searchFoods test");
        }
    }

}
