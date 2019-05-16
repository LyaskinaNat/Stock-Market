package pageObjects;

import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class TradePage extends BasePage {

    //Make a trade section
    @FindBy(name = "stockSymbol")
    public WebElement oSelect;

    @FindBy(name = "price")
    public WebElement price;

    @FindBy(name = "quantity")
    public WebElement quantity;

    @FindBy(name = "submit-button")
    public WebElement submit;


    //Recent Trades section
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[1]")
    public WebElement timeStampKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")
    public WebElement timeStampValue1;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[1]")
    public WebElement timeStampValue2;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[2]")
    public WebElement stockKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]")
    public WebElement stockValue1;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]")
    public WebElement stockValue2;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[3]")
    public WebElement priceKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]")
    public WebElement priceValue1;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[3]")
    public WebElement priceValue2;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[4]")
    public WebElement quantityKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]")
    public WebElement quantityValue1;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[4]")
    public WebElement quantityValue2;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[5]")
    public WebElement buySellKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]")
    public WebElement buySellValue1;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[5]")
    public WebElement buySellValue2;

    public TradePage() {
        super();

    }

    public TradePage assertValuePopulated (WebElement element) {
        if (WaitUntilWebElementIsVisible(element)) {

            String actualValue = element.getText();
            System.out.println("Recorded trade data is successfully populated, Data value: " + actualValue);
            System.out.print(System.lineSeparator());
            Assert.assertFalse("Data for " + element + " is not populated", actualValue.isEmpty());
        }
        return new TradePage();

    }

    public MyStockPage makeTrades (String stock, DataTable dt, int numberOfTrades) {
        List<List<String>> list = dt.asLists(String.class);
        Select oSelect = new Select(tradePage.oSelect);
        try {
            for (int i = 1; i <= numberOfTrades; i++) {
                oSelect.selectByVisibleText(stock);
                tradePage.price.sendKeys(list.get(i).get(0));
                tradePage.quantity.sendKeys(list.get(i).get(1));
                tradePage.submit.click();
            }
        } catch (Exception e) {
             Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());

        }
        return new MyStockPage();
    }

    public MyStockPage makeTradesForDifferentStocks (DataTable dt) {
        List<List<String>> list = dt.asLists(String.class);
         try {
            for (int i = 1; i < list.size(); i++) {

                Select oSelect = new Select(tradePage.oSelect);
                oSelect.selectByVisibleText(list.get(i).get(0));
                tradePage.price.sendKeys(list.get(i).get(1));
                tradePage.quantity.sendKeys(list.get(i).get(2));
                tradePage.submit.click();
            }
        } catch (Exception e) {
            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());

        }
        return new MyStockPage();
    }
}
