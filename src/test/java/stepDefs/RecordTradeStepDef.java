package stepDefs;

import cucumber.api.java.en.Then;
import static utils.DriverFactory.*;

public class RecordTradeStepDef {

    @Then("The trade record has (.+) header")
    public void the_trade_record_has_the_following_headers(String header) {

        String expectedKey = (header);

        switch (header) {

            case "Transaction Date":
                myStockPage.assertDisplayedValue(tradePage.timeStampKey, expectedKey);
                break;

            case "Stock":
                myStockPage.assertDisplayedValue(tradePage.stockKey, expectedKey);
                break;

            case "Price":
                myStockPage.assertDisplayedValue(tradePage.priceKey, expectedKey);
                break;

            case "No. Shares Purchased":
                myStockPage.assertDisplayedValue(tradePage.quantityKey, expectedKey);
                break;

            case "Buy or Sell":
                myStockPage.assertDisplayedValue(tradePage.buySellKey, expectedKey);
                break;

        }


    }


    @Then("^The trade records have trade data populated in (.+) fields$")
    public void the_trade_records_has_trade_data_populated_in_fields(String header) {

        switch (header) {

            case "Transaction Date":
                tradePage.assertValuePopulated(tradePage.timeStampValue1);
                tradePage.assertValuePopulated(tradePage.timeStampValue2);
                break;

            case "Stock":
                tradePage.assertValuePopulated(tradePage.stockValue1);
                tradePage.assertValuePopulated(tradePage.stockValue2);
                break;

            case "Price":
                tradePage.assertValuePopulated(tradePage.priceValue1);
                tradePage.assertValuePopulated(tradePage.priceValue2);
                break;

            case "No. Shares Purchased":
                tradePage.assertValuePopulated(tradePage.quantityValue1);
                tradePage.assertValuePopulated(tradePage.quantityValue2);
                break;

            case "Buy or Sell":
                tradePage.assertValuePopulated(tradePage.buySellValue1);
                tradePage.assertValuePopulated(tradePage.buySellValue2);
                break;

        }

    }
}





