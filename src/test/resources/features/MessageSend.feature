#  As a user, I should be able to send messages by clicking on Message tab in the Activity Stream
@B31G1-203
Feature: User should be able to send message in the Active Stream

  Background: User is already on the login page
    Given user is on the login page

  @B31G1-188
  Scenario Outline: Message sending verification
    Given user is logs in as "<userType>"
    When User click the message tab
    And User filled the message on the message content and recipients
    And User click the send button
    Then User see message on the board
    When User click the message tab
    And User click send button without message content
    Then User see error message for message content
    And User click send button without recipients
    Then User see error message for recipients

    Examples:
      |userType|
      |hr|
      |helpdesk|
      |marketing|

  @B31G1-189
  Scenario Outline: Message sending to all employees by default verification
    Given user is logs in as "<userType>"
    When User click the message tab
    And User filled the message on the message content and recipients
    And User see all employees button as recipient by default
    And User click the send button
    Then User see message on the board
    Examples:
      |userType|
      |hr|
      |helpdesk|
      |marketing|

  @B31G1-190
  Scenario Outline: Message cancel verification
    Given user is logs in as "<userType>"
    When User click the message tab
    And User filled the message on the message content and recipients
    And User click the cancel button
    Then User see send message... message
    Examples:
      |userType|
      |hr|
      |helpdesk|
      |marketing|

    #1. Verify that the user can send a message by filling in the mandatory fields.
  #Mandatory fields: 'Message content & 'Recipient'.
  #Error messages for mandatory fields:
  #"The message title is not specified."
  #"Please specify at least one person."

  #2. Verify that the message delivery is to 'All employees' by default.
  #3. Verify that the user can cancel sending message at any time before sending.