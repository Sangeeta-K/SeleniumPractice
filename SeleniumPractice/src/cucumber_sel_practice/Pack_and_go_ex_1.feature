Feature:Pack and Go:About page

	Scenario:Getting content of About page
		Given Load Pack and Go homepage
		When User get title of homepage
		And User click on About link
		Then User navigated to About page
		And Print the content of about page in console