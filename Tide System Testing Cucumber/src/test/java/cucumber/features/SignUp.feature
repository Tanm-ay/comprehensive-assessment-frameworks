Feature: SignUp

Scenario Outline: Check Valid Account Sign Up

Given I am on website's homepage
When I click Register link
And Click Sign up now
And Enter the details
Then System should validate the details


Scenario Outline: Check Invalid Account Sign Up

Given I am on website's homepage
When I click Register link
And Click Sign up now
And Enter wrong details 
Then System should invalidate wrong details