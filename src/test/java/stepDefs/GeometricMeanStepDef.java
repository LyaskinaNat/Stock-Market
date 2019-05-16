package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static utils.DriverFactory.*;


public class GeometricMeanStepDef {

    @And("I made multiple trades for (.+) stock with the following data")
    public void i_made_multiple_trades_for_stock_with_the_following_data(Integer numberOfTrades, String stock, DataTable dt) {

        try {
            switch (stock) {
                case "TEA":
                    tradePage.makeTrades("TEA", dt, numberOfTrades);
                    break;

                case "POP":
                    tradePage.makeTrades("POP", dt, numberOfTrades);
                    break;

                case "ALE":
                    tradePage.makeTrades("ALE", dt, numberOfTrades);
                    break;


                case "GIN":
                    tradePage.makeTrades("GIN", dt, numberOfTrades);
                    break;

                case "JOE":
                    tradePage.makeTrades("JOE", dt, numberOfTrades);
                    break;

            }
        }   catch (Exception e) {
            System.out.println("Unable to locate WebElement or/and send keys to it ");
            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());
        }

    }

    @Then("I see calculated Geometric Mean for all prices for (.+) Stock in My Stock section")
    public void i_see_calculated_Geometric_Mean_for_all_prices_for_Stock_in_My_Stock_section(String stock) throws Throwable {

        switch (stock) {
            case "TEA":
                myStockPage.assertDisplayedValue(myStockPage.geoMeanElement_TEA, testData.expectedGeoMean_TEA);
                break;

            case "POP":
                myStockPage.assertDisplayedValue(myStockPage.geoMeanElement_POP, testData.expectedGeoMean_POP);
                break;

            case "ALE":
                myStockPage.assertDisplayedValue(myStockPage.geoMeanElement_ALE, testData.expectedGeoMean_ALE);
                break;

            case "GIN":
                myStockPage.assertDisplayedValue(myStockPage.geoMeanElement_GIN, testData.expectedGeoMean_GIN);
                break;

            case "JOE":
                myStockPage.assertDisplayedValue(myStockPage.geoMeanElement_JOE, testData.expectedGeoMean_JOE);
                break;
        }

    }

//    @Then("I see calculated Geometric Mean for all prices for TEA Stock in My Stock section")
//    public void i_see_calculated_Geometric_Mean_for_all_prices_for_TEA_Stock_in_My_Stock_section() throws Throwable {
//
//        myStockPage.assertDisplayedValue(myStockPage.geoMeanElement_TEA, testData.expectedGeoMean_TEA);
//
//    }
//
//    @Then("I see calculated Geometric Mean for all prices for POP Stock in My Stock section")
//    public void i_see_calculated_Geometric_Mean_for_all_prices_for_POP_Stock_in_My_Stock_section() throws Throwable {
//
//        myStockPage.assertDisplayedValue(myStockPage.geoMeanElement_POP, testData.expectedGeoMean_POP);
//
//    }
//
//    @Then("I see calculated Geometric Mean for all prices for ALE Stock in My Stock section")
//    public void i_see_calculated_Geometric_Mean_for_all_prices_for_ALE_Stock_in_My_Stock_section() throws Throwable {
//
//        myStockPage.assertDisplayedValue(myStockPage.geoMeanElement_ALE, testData.expectedGeoMean_ALE);
//
//    }
//
//    @Then("I see calculated Geometric Mean for all prices for GIN Stock in My Stock section")
//    public void i_see_calculated_Geometric_Mean_for_all_prices_for_GIN_Stock_in_My_Stock_section() throws Throwable {
//
//        myStockPage.assertDisplayedValue(myStockPage.geoMeanElement_GIN, testData.expectedGeoMean_GIN);
//
//    }
//
//    @Then("I see calculated Geometric Mean for all prices for JOE Stock in My Stock section")
//    public void i_see_calculated_Geometric_Mean_for_all_prices_for_JOE_Stock_in_My_Stock_section() throws Throwable {
//
//        myStockPage.assertDisplayedValue(myStockPage.geoMeanElement_JOE, testData.expectedGeoMean_JOE);
//
//    }
}




