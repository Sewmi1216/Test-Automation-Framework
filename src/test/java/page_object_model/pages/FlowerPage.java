package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlowerPage extends BasePage {
    public FlowerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Shop For Birthday Flowers']")
    public WebElement selectBirthdayFlowers;

    public void clickBirthdayFlowers() {
        selectBirthdayFlowers.click();
    }
}
