@CTC-1
Feature: Login with provided credentials
  Scenario Outline: User try to log in with username and password
    Given user navigate "https://www.saucedemo.com/"
    Then enters username as <username> and password as <password>
    And user checks the validity <validity>

    Examples:
      | username        | password     | validity |
      | standard_user   | secret_sauce | true     |
      | standards_user1 | secret_sauce | false    |
      | standard_user   | soy_sauce    | false    |
      | standard_user@  | hot_sauce    | false    |

