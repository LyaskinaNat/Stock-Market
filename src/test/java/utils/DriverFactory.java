package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;


public class DriverFactory {
    public static WebDriver driver;
    public static MyStockPage myStockPage;
    public static TradePage tradePage;


    public WebDriver getChromeDriver() {

        try {

            String exePath = "src/test/drivers/chromedriverMac";
            System.setProperty("webdriver.chrome.driver", exePath);
            driver = new ChromeDriver();



        } catch (Exception e) {
            System.out.println("Error when opening a browser: " + e.getMessage());

        }
        finally {
            myStockPage = PageFactory.initElements(driver, MyStockPage.class);
            tradePage = PageFactory.initElements(driver, TradePage.class);


        }
        return driver;
    }


}


