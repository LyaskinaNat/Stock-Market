# Calculate the GBCE All Share Index using the geometric mean of prices for all stocks

  @regression
  Feature: Geometric Mean Calculation for all stocks

  Scenario Outline: Calculate Geometric Mean for all prices for all stocks

    Given   I am on Simple Stock page
    And  I made <numberOfTrades> trades for <stock> stock with the following data

    |  Price   |  Quantity   |
    |   100    |     90      |
    |   110    |     100     |
    |   105    |     121     |
    |   60     |     201     |
    |   65     |     199     |
    |   68     |     280     |
    |   100    |     85      |
    |   107    |     80      |
    |   110    |     86      |
    |   200    |     55      |


    Then I see calculated Geometric Mean for all prices for <stock> Stock in My Stock section

  Examples:

    |  stock    |  numberOfTrades   |
    |   TEA     |        1          |
    |   POP     |        2          |
    |   ALE     |        3          |
    |   GIN     |        5          |
    |   JOE     |        10         |