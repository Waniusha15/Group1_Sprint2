Feature:
  User story: As a user,
  I should be able to create a poll by clicking on Poll tab in the Activity Stream

  Background:
    Given user is on the login page

  @B31G1-185
  Scenario Outline: 1. Verify that the delivery is 'All employees' by default.
    When user is logs in as "<userType>"
    Then user should land on Home page
    When user clicks on the Poll tab
    Then user sees default To: All Employees
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |