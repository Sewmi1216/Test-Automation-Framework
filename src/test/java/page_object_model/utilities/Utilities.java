package page_object_model.utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Utilities {
    protected BrowserFactory browserFactory;

    @BeforeTest
    public void initializeBrowser () {
        browserFactory = BrowserFactory.getBrowserFactoryMethod();
    }
    @AfterTest
    public void closeBrowser () {
        browserFactory.getDriver().quit();
    }
}
