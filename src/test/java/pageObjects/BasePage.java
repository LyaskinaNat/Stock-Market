package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BasePage extends DriverFactory {

    protected WebDriverWait wait;

    public BasePage() {
        this.wait = new WebDriverWait(driver, 5);

    }


    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }


    public static String getExpectedValue(String expectedValue) {

        try {

            Properties prop = new Properties();
            File file = new File("config/testData.properties");
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
            return prop.getProperty(expectedValue);
        } catch (Exception e) {
            System.out.println("Cannot read " + expectedValue + " from Test Data file");
            Assert.fail("Cannot read " + expectedValue + " from Test Data file, Exception: " + e.getMessage());
            return e.getMessage();
        }




    }

}

