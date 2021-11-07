Feature:Pack and Go:Sign in and Booking

	Background:
		Given Load Pack and Go homepage
		Scenario:User sign in
			When User click on sign in and enter details
			Then User signed in successfully
		Scenario:User perform Booking
			When User click on booking link and enter details
			Then Print success message in console on successful booking
			