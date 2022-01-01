Feature: Register account

	Scenario: Testing register
		Given User go to the Website
		When User click MyAccount
		And User input username email address password and click submit
		Then User finish register account