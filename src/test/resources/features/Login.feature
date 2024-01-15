@B31G1-207
Feature: User should be able to Login

  #@B31G1-178
  Background: User is already on the login page
    Given user is on the login page

  @B31G1-198
  Scenario Outline: Verify login with different valid credentials
    When user is logs in as "<userType>"
    Then user should land on Home page with "Portal" in title
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @B31G1-208
  Scenario Outline: Verify login functionality with invalid credentials
    When user logs in with invalid "<username>" and "<password>"
    Then user should see error message "Incorrect login or password"
    Examples:
      | username                | password      |
      | hr99@cybertekschool.com | wrongPassword |
      | wrongEmail@gmail.com    | UserUser      |

  @B31G1-209
  Scenario: Verify that the "Remember me on this computer" link exists and is clickable on the login page.
    Then user see on the page "Remember me on this computer" box
    And user is able to click on Remember me on this computer checkbox

  @B31G1-210
  Scenario: Verify that the password is in bullet signs by default.
    Then user type his password in password input line
    And password should be masked by default

