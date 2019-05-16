  # For a given stock, record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price

  # Trade record validation

  @regression
  Feature: Record a trade

  Background:

    Given   I am on Simple Stock page

  Scenario Outline: Recorded trade contains required headers

    And  I made trades with the following data
      |  Stock    |  Price   |  Quantity   |
      |   TEA     |   100    |     20      |
      |   POP     |   150    |     100     |

    Then The trade record has <header> header

    Examples:

      |      header        |
      | Transaction Date   |
      |      Stock         |
      |      Price         |
      |No. Shares Purchased|
      |    Buy or Sell     |


  Scenario Outline: Recorded trades are populated with trade data

    And  I made trades with the following data
      |  Stock    |  Price   |  Quantity   |
      |   TEA     |   100    |     20      |
      |   POP     |   150    |     100     |

    Then The trade records have trade data populated in <header> fields

    Examples:

      |      header        |
      | Transaction Date   |
      |      Stock         |
      |      Price         |
      |No. Shares Purchased|
      |    Buy or Sell     |

# User input validation

   Scenario Outline: Recorded trade cannot be submitted if some input fields are empty

     And  I attempt to made a trade with <missingInput> missing input

     When I click on Submit button

    Then Trade with missing <missingInput> input is not recorded

    Examples:

      |    missingInput    |
      |       Stock        |
      |       Price        |
      |      Quantity      |

# User input validation - Edge case

    Scenario Outline: Recorded trade cannot be submitted if some input fields are entered and then deleted

      And I enter all required inputs to make a trade
      And  I then delete <missingInput> input

      When I click on Submit button

      Then Trade with missing <missingInput> input is not recorded

      Examples:

        |    missingInput    |
        |       Stock        |
        |       Price        |
        |      Quantity      |

