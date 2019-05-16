  # For a given stock, given any price as input, calculate  the P/E Ratio

  @regression
  Feature: P/E Ratio Calculation

    Background:

      Given   I am on Simple Stock page

    Scenario Outline: P/E Ratio Calculation for a given stock

      And  I made <numberOfTrades> trades for <stock> stock with the following data

        |  Price   |  Quantity   |
        |   150    |     20      |
        |   100    |     20      |
        |   130    |     20      |
        |   60     |     85      |
        |   250    |     120     |


      Then I see the P/E Ratio for <stock> Stock in My Stock section calculated

      Examples:

        |  stock    |  numberOfTrades   |
        |   TEA     |        1          |
        |   POP     |        1          |
        |   ALE     |        1          |
        |   GIN     |        1          |
        |   JOE     |        1          |

    Scenario: P/E Ratio Calculation for a given stock based on last trade price

      And  I made trades with the following data
        |  Stock    |  Price   |  Quantity   |
        |   POP     |   100    |     20      |
        |   POP     |   180    |     100     |


      Then I see the P/E Ratio for a given Stock in My Stock section based on last trade price
