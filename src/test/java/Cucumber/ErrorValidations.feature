@tag
Feature: Error Validation
  I want to use this template for my feature file

Background:
Given I landed on ecommerce page

  @ErrorValidation
  Scenario Outline: Negative test for login functionality
    Given Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

     Examples: 
      | name                     | password    |
      | geetha027.babu@gmail.com | Dheeksha1!  | 
   