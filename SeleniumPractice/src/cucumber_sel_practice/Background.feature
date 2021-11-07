Feature: Testing Background feature in AUT

	Background:
		Given Load Pack and Go homepage
		Scenario: User sign in
			When User clicks on sign in and enter credentials
			Then User is logged in
		Scenario: User registration
			When User click on register and enter details
			Then User is registered successfully	