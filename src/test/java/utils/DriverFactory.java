package utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;


public class DriverFactory {
    public static WebDriver driver;
    public static String appUrl;
    public static String browser;
    public static MyStockPage myStockPage;
    public static TradePage tradePage;


    public static WebDriver getDriver() {

        browser = ReadConfig.getConfigData("config/testEnv.properties", "browser");
        String exePath;
        try {

            switch (browser) {
                case "chrome":
                    exePath = "src/test/drivers/chromedriverMac";
                    System.setProperty("webdriver.chrome.driver", exePath);
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    exePath = "src/test/drivers/geckodriver.exe";
                    System.setProperty("webdriver.firefox.driver", exePath);
                    driver = new FirefoxDriver();
                    break;

                    default:
                        exePath = "src/test/drivers/chromedriverMac";
                        System.setProperty("webdriver.chrome.driver", exePath);
                        driver = new ChromeDriver();
                        break;
            }


        } catch (Exception e) {
            System.out.println("Error when opening a browser: " + e.getMessage());

        }
        finally {
            myStockPage = PageFactory.initElements(driver, MyStockPage.class);
            tradePage = PageFactory.initElements(driver, TradePage.class);


        }
        return driver;
    }

    public static void goToAppHomePage() {

        appUrl = ReadConfig.getConfigData("config/testEnv.properties", "appURL");

        try {
            driver.get(appUrl);

        }   catch (Exception e) {
            Assert.fail("Unable to open App Home page, Exception: " + e.getMessage());
        }

   //     return new MyStockPage();

    }

/*    public WebDriver getChromeDriver() {

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
    }*/


}


