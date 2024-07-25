
@tag
Feature: Purchase the order from ecommerce website
  I want to use this template for my feature file

Background:
Given I landed on ecommerce page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
  
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the Order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name                     | password    | productName  |
      | geetha027.babu@gmail.com | Dheeksha21! | ZARA COAT 3  |
