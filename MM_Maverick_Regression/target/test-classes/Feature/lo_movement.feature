@MMRegression
Feature: Verify lo.movement.com home page and its navigations

Scenario: Verify Loan Officer picture,page,logo and Menus 
Given Loan Officer Movement Home Page URL is Loaded Successfully
Then Loan Officer page loaded successfully with Movement Mortgage Logo
Then Verify Movement Mortgage Loan officer picture
Then Verify three menu options About Pete,Find My Mortgage,Free Tools
Then Close the browser

Scenario: Verify Start My Application 
Given Loan Officer Movement Home Page URL is Loaded Successfully
Then Verify Start My Application button
Then Close the browser

Scenario: Verify Loan Officer Sub Menus 
Given Loan Officer Movement Home Page URL is Loaded Successfully
Then Verify About Pete Menu
Then Verify Find My Mortgage
Then Verify Free Tools
Then Close the browser

Scenario: Verify Redirecton of web page
Given Loan Officer Movement Home Page URL is Loaded Successfully
Then Verify Go To Calculator Redirect
Then Verify Find A Loan Redirect
Then Verify Pay My Mortgage Redirect
Then Verify Market Update Redirect
#Then Verify Movement NewsRoom
Then Verify More FAQs Redirect
Then Close the browser

Scenario: Verify Social Media webpages
Given Loan Officer Movement Home Page URL is Loaded Successfully
Then Verify MM Twitter page
Then Verify MM Instagram page
Then Verify MM Facebook page
Then Verify MM LinkedIn page
Then Verify MM YouTube page
Then Close the browser

Scenario: Verify video play option
Given Loan Officer Movement Home Page URL is Loaded Successfully
Then Verify Moved By Love Video
Then Verify Ten Year anniversary Video
Then Close the browser

#Scenario: Verify contact form
#Given Loan Officer Movement Home Page URL is Loaded Successfully
#Then Verify contact form submit 
#Then Close the browser
