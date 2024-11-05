package page_object_model.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    static BrowserFactory browserFactory;

    ThreadLocal<WebDriver> threadLocal = ThreadLocal.withInitial(()->{
        WebDriver webDriver= null;
        String browserType = System.getProperty("browser", "chrome");
        switch(browserType){
            case "chrome":
                webDriver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                webDriver = WebDriverManager.firefoxdriver().create();
                break;
            case "edge":
                webDriver = WebDriverManager.edgedriver().create();
                break;
            default:
                new RuntimeException("The browser is not defined");
        }
        webDriver.manage().window().maximize();
        return webDriver;
    });
    private BrowserFactory() {}

    public static BrowserFactory getBrowserFactoryMethod(){
        if(browserFactory == null){
            browserFactory = new BrowserFactory();
        }
        return browserFactory;
    }

    public WebDriver getDriver(){
        return threadLocal.get();
    }

}
