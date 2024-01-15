@B31G1-226
Feature: As a user, I should be able to log out

  #@B31G1-178
  Background: User is already logged in
    Given user is on the login page

  @B31G1-224
  Scenario Outline: Verify that the user can log out from the app after clicking the “Log out” button.
    Then user is logs in as "<userType>"
    Then user clicks on his profile
    Then user clicks on Log out button
    And user should land on the login page with title "Authorization"
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  @B31G1-225
  Scenario Outline: Verify that the user can see 5 options under the profile name.
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

