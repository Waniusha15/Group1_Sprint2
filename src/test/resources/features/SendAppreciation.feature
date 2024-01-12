@appreciation
Feature: US B31G1-174: As a user, I should be able to send appreciation
  by clicking on Appreciation tab in the Activity Stream

  Background: User is already on the login page
    Given user logs in and already on the home page


  Scenario: AC 1. Verify that the user can send an appreciation by filling in the mandatory fields.

    When User on stream page click More button
    Then User should click Appreciation on the option
    When User types "Wooden Spoon" in the message field
    Then User should send the message to All employee
    When User should click SEND button
    Then User should verify Activity Stream is displayed


  Scenario: Verify the error messages if you send out Appreciation by not fill mandatory fields.

    When User on stream page click More button
    Then User should click Appreciation on the option
    When User should click SEND button
    Then User should see "The message title is not specified" as an Error message


  Scenario: Verify the error messages if you send out Appreciation by not specifying to a person.

    When User on stream page click More button
    And User should click Appreciation on the option
    Then User types "any message you like" in the message field
    When User not specify anyone to sending appreciation
    And User should click SEND button
    Then User see "Please specify at least one person."


  Scenario: AC 2. Verify the delivery is 'All employees' by default.
    When User on stream page click More button
    And User should click Appreciation on the option
    Then User should see the delivery button "All employees" displayed by default.


  Scenario: AC 3. Verify that the user can cancel sending appreciation at any time before sending.
    When User on stream page click More button
    Then User should click Appreciation on the option
    When User types "Hello World" in the message field
    Then User can click Cancel button to cancel sending appreciation any time
    Then User should verify Activity Stream is displayed