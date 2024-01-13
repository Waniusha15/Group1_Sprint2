Feature: As a user, I should be able to log out

  Background: User is already logged in
    Given user is on the login page

  Scenario Outline: Verify the users can log out from the app after clicking the “Log out” button.
    Then user is logs in as "<userType>"
    Then user clicks on his profile
    Then user clicks on Log out button
    And user should land on the login page with title "Authorization"
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  Scenario Outline: Verify users see 5 options under the profile name.
    Then user is logs in as "<userType>"
    Then user clicks on his profile
    And user sees following options
      | My Profile              |
      | Edit Profile Settings   |
      | Themes                  |
      | Configure notifications |
      | Log out                 |
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


