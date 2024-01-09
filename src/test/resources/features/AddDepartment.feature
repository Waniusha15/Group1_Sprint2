Feature: I should be able to use functions on Company Structure
  under Employee menu.

  Background: User is already on the login page
    Given user is on the login page

@titleVerification
  Scenario Outline:Verify that the Company Structure is visible for all users.

  When user logs in as "<userType>"
  And clicks to Employees button
  Then user should see "Company Structure" page

  Examples:
    | userType  |
    | hr        |
    | helpdesk  |
    | marketing |

  @addDepartment
  Scenario: Verify that the HR user can add a department from the Company Structure.

    When user logs in as hr
    And clicks to Employees button
    And user should see ADD DEPARTMENT button and clicks
    And user should enter the department name
    And user should select the parent department
    Then user should click "Add" button

    @wip
    Scenario Outline: Verify that the “ADD DEPARTMENT” button is not displayed for Helpdesk and Marketing users.

      When user logs in as "<userType>"
      And clicks to Employees button
      And user should not see ADD DEPARTMENT button

      Examples:
        | userType  |
        | helpdesk  |
        | marketing |

