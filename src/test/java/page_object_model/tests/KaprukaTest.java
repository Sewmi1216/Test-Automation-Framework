package page_object_model.tests;

import org.apache.logging.log4j.core.config.Order;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page_object_model.pages.*;
import page_object_model.testData.DataProviderClass;
import page_object_model.utilities.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.time.Duration;

public class KaprukaTest extends Utilities {

    private static final Logger logger = LogManager.getLogger(KaprukaTest.class);

//    @Test(dataProvider = "searchData", dataProviderClass = DataProviderClass.class)
//    public void searchByItem(String searchItem) {
//        logger.info("Starting test for search item: " + searchItem);
//
//        try {
//            // Load the base page and initiate the home page
//            BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
//            HomePage homePage = basePage.loadUrl("https://www.kapruka.com/");
//            homePage.typeTextToSearchBar(searchItem);
//
//            logger.info("Test completed successfully for search item: " + searchItem);
//
//        } catch (NullPointerException e) {
//            logger.error("NullPointerException encountered: " + e.getMessage(), e);
//            Assert.fail("Test failed due to NullPointerException for search item: " + searchItem);
//
//        } catch (Exception e) {
//            logger.error("Unexpected exception encountered: " + e.getMessage(), e);
//            Assert.fail("Test failed due to an unexpected exception for search item: " + searchItem);
//
//        }
//    }

//    @Test
//    public void searchChocolates() {
//        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
//        HomePage homePage = basePage.loadUrl("https://www.kapruka.lk/");
//
//        homePage.clickCategory();
//        logger.info("Test completed 1");
//        homePage.clickChocolates();
//        logger.info("Test completed 2");
//        ChocolatePage chocolatePage = homePage.clickKaprukaChocolates();
//        logger.info("Test completed 3");
//        chocolatePage.clickWomen();
//        logger.info("clicked Women");
//
//    }
//    @Test
//    public void searchComboGiftPacks() {
//        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
//        HomePage homePage = basePage.loadUrl("https://www.kapruka.lk/");
//        homePage.clickCategory();
//        ComboGiftPackPage comboGiftPackPage = homePage.clickComboGiftPacks();
//        logger.info("Test completed 1");
//        comboGiftPackPage.clickChocoGift();
//        logger.info("Test completed 2");
//    }
//    @Test
//    public void searchFlowers() {
//        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
//        HomePage homePage = basePage.loadUrl("https://www.kapruka.lk/");
//        homePage.clickCategory();
//        FlowerPage flowerPage = homePage. clickFlowerShop();
//        logger.info("Clicked Flower Page");
//        flowerPage.clickBirthdayFlowers();
//        logger.info("Clicked Birthday Flowers");
//    }

    @Test(dataProvider = "SearchRefNo", dataProviderClass = DataProviderClass.class)
    public void checkOrderStatus(String searchNumber){
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        HomePage homePage = basePage.loadUrl("https://www.kapruka.lk/");
        OrderStatusPage orderStatusPage = homePage.clickOrderStatus();
        logger.info("Clicked order status");
        orderStatusPage.typeTextToSearchBar(searchNumber);
//        FlowerPage flowerPage = homePage. clickFlowerShop();
//        logger.info("Clicked Flower Page");
//        flowerPage.clickBirthdayFlowers();
//        logger.info("Clicked Birthday Flowers");
    }

}
