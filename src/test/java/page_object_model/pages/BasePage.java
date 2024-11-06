package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver = null;

    public BasePage(WebDriver driver) {

        this.driver = driver;
    }

    public HomePage loadUrl(String url) {
        driver.get(url);
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void scrollPage(int x, int y) {

        new Actions(driver).scrollByAmount(x, y).perform();
    }
}
