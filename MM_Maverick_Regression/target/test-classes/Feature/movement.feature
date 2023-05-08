@MMRegression
Feature: Verify Movement.com home page Menu and Sub-menus.

Scenario: Verify Movement Mortgage Logo and Menu Options 
Given  Movement Home Page URL is Loaded Successfully
Then Home Page is loaded successfully with Movement Mortgage Logo
Then Verify Movement Mortgage Menu Options
Then Close the browser

Scenario: Verify Careers Submenus
Given Movement Home Page URL is Loaded Successfully
Then Hover Careers Menu to verify Submenu
Then Open Careers Submenu to verify their screen and URL
Then Close the browser

Scenario: Verify About Submenus
Given Movement Home Page URL is Loaded Successfully
Then Hover About Menu to verify Submenu
Then Open About Submenu to verify their screen and URL
Then Close the browser

Scenario: Verify Home Loans Submenus
Given Movement Home Page URL is Loaded Successfully
Then Hover Home Loans Menu to verify Submenu
Then Open Home Loans Submenu to verify their screen and URL
Then Close the browser

Scenario: Verify Customers Submenus
Given Movement Home Page URL is Loaded Successfully
Then Hover Customers Menu to verify Submenu
Then Open Customers Submenu to verify their screen and URL
Then Close the browser

Scenario: Verify Apply Now button Submenus
Given Movement Home Page URL is Loaded Successfully
Then Click on Apply Now to verify Lets Get Started Page
Then Verify two sub Menu options
Then Verify the Screen and URLs of the Apply Now sub menus by clicking on them
Then Click on the Movement Mortgage Logo to redirect on Home Page
Then Close the browser

Scenario: Verify Contact,Learn More,View Loans and Find A Loan Officer button and their URLs
Given Movement Home Page URL is Loaded Successfully
Then Click on Contact button to verify its screen and URL
Then Click on Learn More About Us button to verify its screen and URL
Then Click on View Loans button to verify its screen and URL
Then Click on Find A loan Officer button to verify its screen and URL
Then Close the browser

Scenario: Verify carousel section and Image enlargement
Given Movement Home Page URL is Loaded Successfully
Then Scroll to Carousel section to verify using left and right arrow
Then Click on small image on right to verify enlargement
Then Close the browser
