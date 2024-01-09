Feature:
  User story: As a user,
  I should be able to create a poll by clicking on Poll tab in the Activity Stream

  Background:
    Given user is on the login page
    When "hr" user logs in successfully
    Then user is on home page
    When user clicks on the Poll tab

  @B31G1-185
  Scenario: 1. Verify that the delivery is 'All employees' by default.
    Then user sees default To: All Employees

  @B31G1-184
  Scenario: 2. Verify that the user can create a poll by adding questions and multiple answers.
    Given user types in a title message: "Question of the day3"
    And user provides a question: "What is cydeo3"
    And user adds at least one answer
    Then user clicks send
    And user can see the title message: "Question of the day3" at the top of activity stream

  @B31G1-183
  Scenario: 3. Verify that the user can select the “Allow multiple choice” checkbox.
    When user clicks on the multiple choice box
    Then multiple choice box remains selected




