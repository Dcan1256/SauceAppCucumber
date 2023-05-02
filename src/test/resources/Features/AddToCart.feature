@CTC-1
Feature:Adding items in to the shopping cart

  Scenario Outline: Cart manipulation
    Given user navigate "https://www.saucedemo.com/"
    And  enters username as <username> and password as <password>
    Then user validates we are in the main page by the header "Products"
    Then user adding all 6 item into the cart
    And user is removing all 6 elements recently added

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |




