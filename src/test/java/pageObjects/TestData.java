package pageObjects;

public class TestData {

    // Test assertion data

    // Expected P/E Ratio values
    public String expectedPERatio_TEA = "0";
    public String expectedPERatio_POP = "18.75";
    public String expectedPERatio_ALE = "6.521739130434782";
    public String expectedPERatio_GIN = "18.75";
    public String expectedPERatio_JOE = "11.538461538461538";

    // Expected P/E Ratio values based on last trade price
    public String expectedPERatio_POP_last = "22.5";



    //Expected Dividend Yield values for each stock
    public String expectedDividendYield_TEA = "0";
    public String expectedDividendYield_POP = "0.05333333333333334";
    public String expectedDividendYield_ALE = "0.15333333333333332";
    public String expectedDividendYield_GIN = "1.3333333333333333";
    public String expectedDividendYield_JOE = "0.08666666666666667";

    // Expected Dividend Yield values based on last trade price
    public String expectedDividendYield_POP_last = "0.044444444444444446";


    //Expected Geometric Mean values
    public String expectedGeoMean_TEA = "100";
    public String expectedGeoMean_POP = "104.88088481701516";
    public String expectedGeoMean_ALE = "104.92057485622675";
    public String expectedGeoMean_GIN = "85.25685698845406";
    public String expectedGeoMean_JOE = "96.78235738018093";

    //Expected Volume Weighted Stock Price values for all trades
    public String expectedVolumeWeightedStockPrice_TEA = "100";
    public String expectedVolumeWeightedStockPrice_POP = "105.26315789473684";
    public String expectedVolumeWeightedStockPrice_ALE = "105.16077170418006";
    public String expectedVolumeWeightedStockPrice_GIN = "81.15330520393812";
    public String expectedVolumeWeightedStockPrice_JOE = "88.09560524286816";

    //Expected Volume Weighted Stock Price values for trades in last 15 min
    public String expectedVolumeWeightedStockPrice15_TEA = "150";


}

