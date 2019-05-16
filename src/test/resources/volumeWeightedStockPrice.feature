# For a given stock,  calculate Volume Weighted Stock Price based on trades in past 15 minutes

  Feature: Volume Weighted Stock Price Calculation for a given stocks

  Background:

    Given   I am on Simple Stock page

  @regression
  Scenario Outline: Calculate Volume Weighted Stock Price for a given stock

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

    Then I see calculated Volume Weighted Stock Price for <stock> stock for all trades

    Examples:

      |  stock    |  numberOfTrades   |
      |   TEA     |        1          |
      |   POP     |        2          |
      |   ALE     |        3          |
      |   GIN     |        5          |
      |   JOE     |        10         |



  Scenario: Calculate Volume Weighted Stock Price for a given stock for trades in past 15 min

    And  I made trades with the following data
      |  Stock    |  Price   |  Quantity   |
      |   TEA     |   100    |     20      |


    And I wait 16 min

    And  I made trades with the following data
      |  Stock    |  Price   |  Quantity   |
      |   TEA     |   150    |     50      |


    Then I see calculated Volume Weighted Stock Price for a given stock for trades in past 15 min









