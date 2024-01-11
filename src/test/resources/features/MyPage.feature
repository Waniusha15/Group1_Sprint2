@profile-page
Feature: user should be able to access My Profile page.

  Background: User is already on the login page
    Given user is on the login page

  Scenario Outline: Verify that the <user> can view the following options on My Profile page
    When user is logs in as "<user>" and password "<password>"
    Then user clicks profile dropdown
    And user clicks My Profile option from profile options
    Then user should be able to see the following options on my Profile page like "General,Drive,Tasks,Calendar,Conversations"

    Examples:
      | user                          | password |
      | helpdesk1@cybertekschool.com  | UserUser |
      | hr99@cybertekschool.com       | UserUser |

