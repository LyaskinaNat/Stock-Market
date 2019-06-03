package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class MyStockPage extends BasePage {

    public Integer dividendYieldIndex = 1;
    public Integer PERatiodIndex = 2;
    public Integer geometricMeandIndex = 3;
    public Integer volumeWeightedStockPriceIndex = 4;


    public String myStockTableRows = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr";

    public MyStockPage() {
    super();
 }

 public MyStockPage goToAppHomePage() {
  try {
   driver.get("https://nick-dave-turner.github.io/stock-trade-app");

  }   catch (Exception e) {
   Assert.fail("Unable to open App Home page, Exception: " + e.getMessage());
  }

  return new MyStockPage();

 }

 public MyStockPage assertDisplayedValue (String stock, int index, String testDataKey) {
     List<WebElement> rows = driver.findElements(By.xpath(myStockPage.myStockTableRows));
     rows.forEach((row) -> {
         String rowText = row.getText();
         String expectedValue = getExpectedValue(testDataKey);
         if (rowText.contains(stock)) {
             String strArray[] = rowText.split(" ");
             String actualValue = strArray[index];
             System.out.println("Expected Value: " + expectedValue + ", Actual Value: " + actualValue);
             System.out.print(System.lineSeparator());
             Assert.assertEquals("Test failed. Actual value: " + actualValue + " doesn't match the expected value: " + expectedValue, expectedValue, actualValue);
         }

         });

     return new MyStockPage();
 }

}

