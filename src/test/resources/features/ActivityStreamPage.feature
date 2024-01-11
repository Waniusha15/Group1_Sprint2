@B31G1-206
Feature: Default

	Background:User is already on the login page
		Given user is on the login page
		

	
	@B31G1-204
	Scenario Outline: 1. Verify that the user views the following options on the Activity Stream page.     MESSAGE     TASK     EVENT     POLL     MORE
		    When user is logs in as "<userType>"
		    Then User should able to see fallowing "MESSAGE"
		    Then User should able to see fallowing modules
		      | TASK  |
		      | EVENT |
		      | POLL  |
		      | MORE  |
		   Examples:
		     |userType|
		     |hr|
		     |helpdesk|
		     |marketing|	

	
	@B31G1-205
	Scenario Outline:  Verify that the user views the following 4 options under the MORE tab.     File     Appreciation     Announcement     Workflow
		    When user is logs in as "<userType>"
		    Given user is enters the  more information
		    Then User should able to see fallowing more modules
		      | File         |
		      | Appreciation |
		      | Announcement |
		      | Workflow     |
		   Examples:
		     |userType|
		     |hr|
		     |helpdesk|
		     |marketing|