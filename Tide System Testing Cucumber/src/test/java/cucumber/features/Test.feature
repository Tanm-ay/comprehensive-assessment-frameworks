Feature: Tide System Testing

@first
Scenario Outline: Check Promotional Image On Homepage

Given Website link is working
When I land on website 
Then A promotional image should appear



Scenario Outline: Check P&G Icon Redirection

Given I am on website's homepage
When I click on P&G icon
Then I am redirected to P&G website



Scenario Outline: Check Text Under Live Chat

Given I am on website's homepage
When I click on Live Chat
Then REAL-TIME CHAT SUPPORT is displayed on page



Scenario Outline: Check Link Under T&C Footer

Given I am on website's homepage
When I click Terms & Conditions footer link
Then Copyrights And Trademarks link should be present on screen



Scenario Outline: Check P&G Text On Homepage

Given Website link is working
When I land on website
Then P&G should be present on page



Scenario Outline: Check Text Under How To Wash Clothes

Given I am on website's homepage
When I hover mouse over How to Wash Clothes
And Click Washing Machine 101
Then How to Use a Washing Machine should be present on page



Scenario Outline: Check Input Search Text Result

Given I am on website's homepage
When I click search box
And Enter text And press Enter 
Then That text should be present on top of the page



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



Scenario Outline: Check Text Under Powder Footer

Given I am on website's homepage
When I click Powder footer link
Then First displayed result should contain the word Powder



@last
Scenario Outline: Check Website Language Change

Given I am on website's homepage
When I click US-English
And Click US-Spanish
Then Website's language should change to Spanish
