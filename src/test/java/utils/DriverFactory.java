package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;


public class DriverFactory {
    public static WebDriver driver;
    public static MyStockPage myStockPage;
    public static TradePage tradePage;
    public static TestData testData;

    public WebDriver getChromeDriver() {

        try {

            String exePath = "src/test/drivers/chromedriverMac";
            System.setProperty("webdriver.chrome.driver", exePath);
            driver = new ChromeDriver();



        } catch (Exception e) {
            System.out.println("Error when opening aa browser: " + e.getMessage());

        }
        finally {
            myStockPage = PageFactory.initElements(driver, MyStockPage.class);
            tradePage = PageFactory.initElements(driver, TradePage.class);
            testData = PageFactory.initElements(driver, TestData.class);

        }
        return driver;
    }


}


