Feature: Footer Links

@first
Scenario Outline: Verify Link Under T&C Footer

Given I am on website's homepage
When I click Terms & Conditions footer link
Then Copyrights And Trademarks link should be present on screen


Scenario Outline: Verify Text Under Powder Footer

Given I am on website's homepage
When I click Powder footer link
Then First displayed result should contain the word Powder