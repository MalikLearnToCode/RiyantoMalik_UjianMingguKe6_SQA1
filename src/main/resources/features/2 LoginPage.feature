Feature: Login account
	
	Scenario: Testing the authentication
		When User click MyAccount for login
		And User input registered username password and click submit
		Then User logged in to their account			