Feature: Website Language

@last
Scenario Outline: Verify Website Language Change

Given I am on website's homepage
When I click US-English
And Click US-Spanish
Then Website's language should change to Spanish