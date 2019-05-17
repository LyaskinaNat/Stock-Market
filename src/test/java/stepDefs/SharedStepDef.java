package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static utils.DriverFactory.*;


public class SharedStepDef {
    @Given("I am on Simple Stock page")
    public void i_am_on_Simple_Stock_page()  {
        myStockPage.goToAppHomePage();

    }

    @When("I made trades with the following data")
    public void i_made_trades_with_the_following_data(DataTable dt)  {

        tradePage.makeTradesForDifferentStocks (dt);

    }

    @When("I made (.+) trades for (.+) stock with the following data")
    public void i_made_trades_for_stock_with_the_following_data(Integer numberOfTrades, String stock, DataTable dt) {

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

    }
}



