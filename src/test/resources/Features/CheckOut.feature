@CTC-1
Feature: Full Check-out
  Scenario: User logging in adding items and checking out after all
    Given user navigate "https://www.saucedemo.com/"
    And user enters username as "standard_user" and password as "secret_sauce"
    Then user validates we are in the main page by the header "Products"
    Then user adding all 6 item into the cart
    And user click go to cart button
    Then user validates the 6 item in their cart again and clicks checkout button
    Then user filling checkout information with First-Last name and Zip code as "name","surname","66666"
    Then user checking the prices are correct or not and clicks finish button
    Then verify checkout is completed successfully

