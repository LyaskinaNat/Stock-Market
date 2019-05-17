package stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

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

    @And("^I attempt to made a trade with (.+) missing input$")
    public void i_attempt_to_made_a_trade_with_Stock_missing_input(String missingInput) throws  Throwable {
        Select oSelect = new Select(tradePage.selectStock);
        switch (missingInput) {

            case "Stock":
                tradePage.CustomInputsForTrade("Choose Stock", "100", "80" /*, "Buy"*/);
                break;

            case "Price":
                tradePage.CustomInputsForTrade("TEA", "", "80" /*, "Buy"*/);
                break;

            case "Quantity":
                tradePage.CustomInputsForTrade("TEA", "100", "" /*, "Buy"*/);
                break;

 //        case "BuyOrSell":
 //             tradePage.CustomInputsForTrade("TEA", "100", "80", "");
 //             break;

        }

    }

    @And("^I enter all required inputs to make a trade$")
    public void i_enter_all_required_inputs_to_make_a_trade() {
        tradePage.CustomInputsForTrade("POP", "150", "300" /*, "Buy"*/);

    }

    @And("^I then delete (.+) input$")
    public void i_then_delete_Stock_input(String missingInput) {
        switch (missingInput) {
            case "Stock":
                Select oSelect = new Select(tradePage.selectStock);
                oSelect.selectByVisibleText("Choose Stock");
                break;

            case "Price":
                tradePage.price.sendKeys("");
                break;

            case "Quantity":
                tradePage.quantity.sendKeys("");
                break;

  //        case "BuyOrSell":
  //            tradePage.buyOrSell.sendKeys("");
  //            break;

        }
    }

    @When("^I click on Submit button$")
    public void i_click_on_Submit_button() {
        tradePage.submit.click();

    }

    @Then("^Trade with missing (.+) input is not recorded$")
    public void trade_is_not_recorded(String missingInput) {

        String tradeRecordActual = tradePage.timeStampValue1.getText();

        switch (missingInput) {
            case "Stock":

                Assert.assertEquals("Trade with missing " + missingInput + " input was recorded without the required data", testData.tradeRecordExpected, tradeRecordActual);
                break;

            case "Price":

                Assert.assertEquals("Trade with missing " + missingInput + " input was recorded without the required data", testData.tradeRecordExpected, tradeRecordActual);
                break;

            case "Quantity":

                Assert.assertEquals("Trade with missing " + missingInput + " input was recorded without the required data", testData.tradeRecordExpected, tradeRecordActual);
                break;

  //          case "BuyOrSell":
  //
  //            Assert.assertEquals("Trade with missing " + missingInput + " input was recorded without the required data", testData.tradeRecordExpected, tradeRecordActual);
  //            break;

        }

    }

}





