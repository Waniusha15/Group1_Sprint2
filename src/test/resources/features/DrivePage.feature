@DrivePage
Feature: user should be able to access Drive page.
  Background: User is already on the login page
    Given user is on the login page

  Scenario Outline: Verify that the <user> can see the following 6 modules on the Drive page.
    When user is logs in as "<user>" and password "<password>"
    And user clicks Drive page
    Then user should be able to see the following options on Drive page like "My Drive,All Documents,Company Drive,Sales and Marketing,Top Management's documents,Drive Cleanup"

    Examples:
      | user                          | password |
      | helpdesk1@cybertekschool.com  | UserUser |
      | hr99@cybertekschool.com       | UserUser |
