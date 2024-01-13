@B31G1-202
Feature: I should be able to use functions on Company Structure
	under Employee menu.

	Background: User is already on the login page
		Given user is on the login page
	@B31G1-193
	Scenario Outline: As a user, I should be able to use functions on Company Structure under Employee menu.
		When user logs in as "<userType>"
		  And clicks to Employees button
		  Then user should see "Company Structure" page
		
		Examples:
		    | userType  |
		    | hr        |
		    | helpdesk  |
		    | marketing |	

	
	@B31G1-200
	Scenario: Verify that the HR user can add a department from the Company Structure
		When user logs in as hr
		    And clicks to Employees button
		    And user should see ADD DEPARTMENT button and clicks
		    And user should enter the department name
		    And user should select the parent department
		    Then user should click "Add" button	

	
	@B31G1-201
	Scenario Outline: Verify that the “ADD DEPARTMENT” button is not displayed for Helpdesk and Marketing users.
		When user logs in as "<userType>"
		      And clicks to Employees button
		      And user should not see ADD DEPARTMENT button
		
		      Examples:
		        | userType  |
		        | helpdesk  |
		        | marketing |