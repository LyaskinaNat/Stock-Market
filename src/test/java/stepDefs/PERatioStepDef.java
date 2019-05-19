package stepDefs;

import cucumber.api.java.en.Then;
import static utils.DriverFactory.*;

public class PERatioStepDef {


    @Then("^I see the P/E Ratio for (.+) Stock in My Stock section calculated$")
    public void i_see_the_P_E_Ratio_for_Stock_in_My_Stock_section_calculated(String stock) throws Throwable {

        switch (stock) {
            case "TEA":
                myStockPage.assertDisplayedValue(stock, myStockPage.PERatiodIndex, testData.expectedPERatio_TEA);
                break;

            case "POP":
                myStockPage.assertDisplayedValue(stock, myStockPage.PERatiodIndex, testData.expectedPERatio_POP);
                break;

            case "ALE":
                myStockPage.assertDisplayedValue(stock, myStockPage.PERatiodIndex, testData.expectedPERatio_ALE);
                break;

            case "GIN":
                myStockPage.assertDisplayedValue(stock, myStockPage.PERatiodIndex, testData.expectedPERatio_GIN);
                break;

            case "JOE":
                myStockPage.assertDisplayedValue(stock, myStockPage.PERatiodIndex, testData.expectedPERatio_JOE);
                break;
        }
    }

    @Then("I see the P/E Ratio for a given Stock in My Stock section based on last trade price")
    public void i_see_the_P_E_Ratio_for_Stock_in_My_Stock_section_calculated_based_on_last_trade_price() throws Throwable {

        myStockPage.assertDisplayedValue("POP", myStockPage.PERatiodIndex, testData.expectedPERatio_POP_last);


    }

}
