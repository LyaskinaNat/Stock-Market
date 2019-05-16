package stepDefs;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverFactory;


public class MainHooks extends DriverFactory {

    @Before

    public void setup() {
        driver = getChromeDriver();

    }


    @After

    public void tearDownAndScreenShotOnFailure(Scenario scenario) {

        try {


                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;

            } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenShotOnFailure, Exception:" + e.getMessage());
        }
    }

}




