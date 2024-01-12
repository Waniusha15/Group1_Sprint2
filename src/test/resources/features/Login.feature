@login
Feature: User should be able to Login

  Background: User is already on the login page
    Given user is on the login page

  Scenario Outline: Verify login with different valid credentials
    When user is logs in as "<userType>"
    Then user should land on Home page with "Portal" in title
    Examples:
    |userType|
    |hr|
    |helpdesk|
    |marketing|

    Scenario Outline: Verify login functionality with invalid credentials
      When user logs in with invalid "<username>" and "<password>"
      Then user should see error message "Incorrect login or password"
      Examples:
      |username|password|
      |hr99@cybertekschool.com|wrongPassword|
      |wrongEmail@gmail.com|UserUser|

    Scenario: Verify that the "Remember me on this computer" link exists and is clickable on the login page.
      Then user see on the page "Remember me on this computer" box
      And user is able to click on Remember me on this computer checkbox

    Scenario: Verify that the password is in bullet signs by default.
      Then user type his password in password input line
      And password should be masked by default

