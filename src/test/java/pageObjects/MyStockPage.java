package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyStockPage extends BasePage {

    // Dividend Yield Placeholders
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]")
    public WebElement DividendYieldElement_TEA;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]")
    public WebElement DividendYieldElement_POP;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[2]")
    public WebElement DividendYieldElement_ALE;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[2]")
    public WebElement DividendYieldElement_GIN;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[5]/td[2]")
    public WebElement DividendYieldElement_JOE;


    // P/E Ratio Placeholders
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]")
    public WebElement PERatioElement_TEA;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[3]")
    public WebElement PERatioElement_POP;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[3]")
    public WebElement PERatioElement_ALE;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[3]")
    public WebElement PERatioElement_GIN;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[5]/td[3]")
    public WebElement PERatioElement_JOE;

    // Volume Weighted Stock Price Placeholders
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]")
    public WebElement volumeWeightedStockPriceElement_TEA;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[5]")
    public WebElement volumeWeightedStockPriceElement_POP;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[5]")
    public WebElement volumeWeightedStockPriceElement_ALE;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[5]")
    public WebElement volumeWeightedStockPriceElement_GIN;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[5]/td[5]")
    public WebElement volumeWeightedStockPriceElement_JOE;

    // Geometric Mean Placeholders
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]")
    public WebElement geoMeanElement_TEA;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[4]")
    public WebElement geoMeanElement_POP;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[4]")
    public WebElement geoMeanElement_ALE;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[4]")
    public WebElement geoMeanElement_GIN;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr[5]/td[4]")
    public WebElement geoMeanElement_JOE;

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

  public MyStockPage assertDisplayedValue(WebElement element, String expectedValue) {
         if (WaitUntilWebElementIsVisible(element)) {

             String actualValue = element.getText();
             System.out.println("Expected Value: " + expectedValue + ", Actual Value: " + actualValue);
             System.out.print(System.lineSeparator());
             Assert.assertEquals(expectedValue, actualValue);
         }
         return new MyStockPage();

 }

}

