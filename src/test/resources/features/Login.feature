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