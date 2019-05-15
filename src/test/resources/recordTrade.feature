  # For a given stock, record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price

Feature: Record a trade

  Background:

    Given   I am on Simple Stock page
    And  I made trades with the following data
      |  Stock    |  Price   |  Quantity   |
      |   TEA     |   100    |     20      |
      |   POP     |   150    |     100     |


  Scenario Outline: Recorded trade contains required headers

    Then The trade record has <header> header

    Examples:

       |      header        |
       | Transaction Date   |
       |      Stock         |
       |      Price         |
       |No. Shares Purchased|
       |    Buy or Sell     |


  Scenario Outline: Recorded trades are populated with trade data

    Then The trade records have trade data populated in <header> fields

    Examples:

      |      header        |
      | Transaction Date   |
      |      Stock         |
      |      Price         |
      |No. Shares Purchased|
      |    Buy or Sell     |