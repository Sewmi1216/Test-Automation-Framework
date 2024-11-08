package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComboGiftPackPage extends BasePage {

    public ComboGiftPackPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Shop For Choco Gift b(51)b']")
    public WebElement selectChocoGift;

    public void clickChocoGift() {
        selectChocoGift.click();
    }

}
