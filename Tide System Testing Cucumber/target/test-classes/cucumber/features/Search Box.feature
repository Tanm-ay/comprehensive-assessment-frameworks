Feature: Search Box

Scenario Outline: Verify Input Search Text Result

Given I am on website's homepage
When I click search box
And Enter text And press Enter 
Then That text should be present on top of the page