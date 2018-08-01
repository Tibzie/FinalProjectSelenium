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
Feature: Testing game
  As a user
  I want to use click on the arrows
  So I can move with my character

  @tag1
  Scenario: Testing movements in the game
    Given the website
    When I click on the Game webpage
    Then I click on the left arrow the character will move left
  	And I click on the right arrow the character will move right
  	And I click on the up arrow the character will move up
  	And I click on the down arrow the character will down
  	
    


