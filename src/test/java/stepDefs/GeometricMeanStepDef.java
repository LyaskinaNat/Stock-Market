package stepDefs;

import cucumber.api.java.en.Then;
import static utils.DriverFactory.*;


public class GeometricMeanStepDef {

    @Then("I see calculated Geometric Mean for all prices for (.+) Stock in My Stock section")
    public void i_see_calculated_Geometric_Mean_for_all_prices_for_Stock_in_My_Stock_section(String stock) throws Throwable {

        switch (stock) {
            case "TEA":
                myStockPage.assertDisplayedValue(stock, myStockPage.geometricMeandIndex, "expectedGeoMean_TEA");
                break;

            case "POP":
                myStockPage.assertDisplayedValue(stock, myStockPage.geometricMeandIndex, "expectedGeoMean_POP");
                break;

            case "ALE":
                myStockPage.assertDisplayedValue(stock, myStockPage.geometricMeandIndex, "expectedGeoMean_ALE");
                break;

            case "GIN":
                myStockPage.assertDisplayedValue(stock, myStockPage.geometricMeandIndex, "expectedGeoMean_GIN");
                break;

            case "JOE":
                myStockPage.assertDisplayedValue(stock, myStockPage.geometricMeandIndex, "expectedGeoMean_JOE");
                break;
        }

    }


}




