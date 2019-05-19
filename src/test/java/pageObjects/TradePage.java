package pageObjects;

import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class TradePage extends BasePage {

    //Make a trade section
    @FindBy(name = "stockSymbol")
    public WebElement selectStock;

    @FindBy(name = "price")
    public WebElement price;

    @FindBy(name = "quantity")
    public WebElement quantity;

//  @FindBy(name = "buySell")
//  public WebElement buySellIndicator;

    @FindBy(name = "submit-button")
    public WebElement submit;


    //Recent Trades section

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[1]")
    public WebElement timeStampKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")
    public WebElement timeStampValue;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[2]")
    public WebElement stockKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]")
    public WebElement stockValue;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[3]")
    public WebElement priceKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]")
    public WebElement priceValue;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[4]")
    public WebElement quantityKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]")
    public WebElement quantityValue;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[5]")
    public WebElement buySellKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]")
    public WebElement buySellValue;

    public String recentTradesTableRows = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr";


    public TradePage() {
        super();

    }

    public TradePage makeTrades (String stock, DataTable dt, int numberOfTrades) {
        List<List<String>> list = dt.asLists(String.class);
        Select oSelect = new Select(selectStock);
        try {
            for (int i = 1; i <= numberOfTrades; i++) {
                oSelect.selectByVisibleText(stock);
                price.sendKeys(list.get(i).get(0));
                quantity.sendKeys(list.get(i).get(1));
 //             buySell.sendKeys(list.get(i).get(2));
                submit.click();
            }
        } catch (Exception e) {
             Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());

        }
        return new TradePage();
    }

    public TradePage makeTradesForDifferentStocks (DataTable dt) {
        List<List<String>> list = dt.asLists(String.class);
         try {
            for (int i = 1; i < list.size(); i++) {

                Select oSelect = new Select(selectStock);
                oSelect.selectByVisibleText(list.get(i).get(0));
                price.sendKeys(list.get(i).get(1));
                quantity.sendKeys(list.get(i).get(2));
 //             buySell.sendKeys(list.get(i).get(3));
                submit.click();
            }

        } catch (Exception e) {
            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());

        }
        return new TradePage();
    }

    public TradePage CustomInputsForTrade (String stock, String price, String quantity/*,String buyOrSell*/) {

        try {
            Select oSelect = new Select(selectStock);
            oSelect.selectByVisibleText(stock);
            tradePage.price.sendKeys(price);
            tradePage.quantity.sendKeys(quantity);
//          tradePage.buySell.sendKeys(buySell);
        } catch (Exception e) {
            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());

        }
        return new TradePage();
    }

    public TradePage deleteTradeInput (String testCase) {
        if (testCase.equals("Stock")) {
            Select oSelect = new Select(tradePage.selectStock);
            oSelect.selectByVisibleText("Choose Stock");
        } else if (testCase.equals("Price")) {
            tradePage.price.sendKeys("");

        } else if (testCase.equals("Quantity")) {
            tradePage.quantity.sendKeys("");
        }

        //    } else if (testCase.equals("BuyOrell")) {
        //      tradePage.buyOrSell.sendKeys("");
        //    }

        return new TradePage();
    }



    public TradePage assertDisplayedValueTrades(WebElement element, String expectedValue) {
        if (WaitUntilWebElementIsVisible(element)) {

            String actualValue = element.getText();
            System.out.println("Expected Value: " + expectedValue + ", Actual Value: " + actualValue);
            System.out.print(System.lineSeparator());
            Assert.assertEquals("Test failed. Actual value: " + actualValue + " doesn't match the expected value: " + expectedValue, expectedValue, actualValue);

        }
        return new TradePage();

    }

    public TradePage assertValuePopulatedTrades (WebElement element) {
        if (WaitUntilWebElementIsVisible(element)) {

            String actualValue = element.getText();
            System.out.println("Recorded trade data is successfully populated, Data value: " + actualValue);
            System.out.print(System.lineSeparator());
            Assert.assertFalse("Data for " + element + " is not populated", actualValue.isEmpty());
        }
        return new TradePage();

    }

    public TradePage assertNumberOfTradesRecorded (Integer numberOfTrades, String stock) {
        List<WebElement> rows = driver.findElements(By.xpath(tradePage.recentTradesTableRows));
        int count = rows.size();
        System.out.println("Expected number of recorded Trades  for " + stock + " is: " + numberOfTrades + ", Actual number of recorded Trades for " + stock + " is: " + count);
        Assert.assertTrue("Number of trade recorded (" + count + ") is different from number of trades made (" + numberOfTrades + ")", numberOfTrades.equals(count));

        return new TradePage();

    }

    public TradePage tradeRecordExists (String missingInput, String expectedRecord) {
        String actualRecord = tradePage.timeStampValue.getText();
        Assert.assertEquals("Trade with missing " + missingInput + " input was recorded without the required data", expectedRecord, actualRecord);
        return new TradePage();
    }
}
