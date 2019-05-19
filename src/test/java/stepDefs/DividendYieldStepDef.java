package stepDefs;

import cucumber.api.java.en.Then;
import static utils.DriverFactory.*;


public class DividendYieldStepDef {

    @Then("^I see Dividend Yield for (.+) Stock in My Stock section based on stock type$")
    public void i_see_Dividend_Yield_for_Stock_in_My_Stock_section_based_on_stock_type(String stock) throws Throwable {


        switch (stock) {
            case "TEA":
                myStockPage.assertDisplayedValue(stock, myStockPage.dividendYieldIndex, testData.expectedDividendYield_TEA);
                break;

            case "POP":
                myStockPage.assertDisplayedValue(stock, myStockPage.dividendYieldIndex, testData.expectedDividendYield_POP);
                break;

            case "ALE":
                myStockPage.assertDisplayedValue(stock, myStockPage.dividendYieldIndex, testData.expectedDividendYield_ALE);
                break;

            case "GIN":
                myStockPage.assertDisplayedValue(stock, myStockPage.dividendYieldIndex, testData.expectedDividendYield_GIN);
                break;

            case "JOE":
                myStockPage.assertDisplayedValue(stock, myStockPage.dividendYieldIndex, testData.expectedDividendYield_JOE);
                break;
        }

    }

    @Then("I see Dividend Yield for a given Stock in My Stock section based on last trade price")
    public void i_see_Dividend_Yield_for_Stock_in_My_Stock_section_based_on_last_trade_price() throws Throwable {

        myStockPage.assertDisplayedValue("POP", 1, testData.expectedDividendYield_POP_last);


    }
}

