package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChocolatePage extends BasePage{

    public ChocolatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Women']")
    public WebElement selectWomen;

    public void clickWomen() {
        selectWomen.click();
    }

}
