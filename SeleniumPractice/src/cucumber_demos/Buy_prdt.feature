Feature:Buy Product Functionality
  
  @buy_product
  Scenario Outline: Validate User can place an order successfully
    Given Load the website homepage
    When User sign in using "<username>" and "<password>" 
    Then User signed in successfully
    Then User move the cursor over Women's link
    And User click on sub-menu T-shirts
    When User mouse hover on the second product displayed and click on the More button
    And Increase the quantity to "2",size to "L" and select color
    Then Cilck on Add to Cart button
    And Click on Proceed to checkout button
    When User perform the payment
    Then User placed order successfully
  
  Examples:
  | username                   | password          |  
  | dfg239@yopmail.com         |  yuiojty90        |
     