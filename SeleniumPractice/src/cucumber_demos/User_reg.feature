Feature:User registration

	@tag1
	Scenario Outline:Validate user account creation
		Given Open the URL 
		When User click on Sign In
		Then User navigated to Sign In or Create Account page
		When User enter "<Email>" and click on Create Account button
		Then User navigated to Create Account page
		When User enter "<Title>","<FirstName>","<LastName>","<Email>","<Password>" and "<DOB>"
		And User enter "<FirstName>","<Lastname>","<Company>","<Address>","<City>","<State>","<Zipcode>","<Country>","<MobileNo>","<Alias>"
		And User Click on Register button
		Then User Account created successfully
	  Examples:
	  | Email               | Password         | DOB         | FirstName      | LastName     | Company                | Address                | City          | State          | Zipcode | Country         | MobileNo       | Alias                  |
	  |	dfg980@yopmail.com  | yuiojty90        | 7-8-2006    |  Abcf          |    Dehf      |  XYZ,Private Ltd       |   yi Test Street       | NY            |Florida         |   35608 | US              |1234597890      |  hjkol@gmail.com       |                
		