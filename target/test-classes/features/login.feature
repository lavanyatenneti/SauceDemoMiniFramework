#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: SauceDemo Login

  @tag1
  Scenario Outline: Valid and invalid login attempts
    Given the user is on the SauceDemo login page
    When the user enters "<username>" and "<password>"
    And clicks the login button
    Then the user should be redirected based on the outcome
  

    Examples: 
      | username         | password      |
      | standard_user    | secret_sauce  |
      | locked_out_user  | secret_sauce  |
      | invalid_user     | wrong_pass    |
