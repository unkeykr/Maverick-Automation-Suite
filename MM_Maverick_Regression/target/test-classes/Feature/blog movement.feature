@MMRegression
Feature: Verify blog.movement.com page and its navigations

  Scenario Outline: Verify https://blog.movement.com/ url 
			Given Movement blog Page is Loaded Successfully
			Then verify url
			Then Close the browser
			
	Scenario Outline: Verify MovementBlog logo
			Given Movement blog Page is Loaded Successfully
			Then verify BlogMovement logo
			Then Close the browser
			
	 Scenario Outline: Verify Search field
			Given Movement blog Page is Loaded Successfully
			Then Click on search button and verify Search field
			Then Close the browser
			
	 Scenario Outline: Verify Hamburger icon
			Given Movement blog Page is Loaded Successfully
			Then Click on Hamburger icon and verify Home,Trending,Categories,About,Movement.com
			Then Close the browser	
			
	 Scenario Outline: Verify Home Option redirects properly 
			Given Movement blog Page is Loaded Successfully
			Then Click on 3 lines on blog home page
			Then Click on Home option and verify url
			Then Close the browser
			
	 Scenario Outline: Verify Trending Option redirects properly 
			Given Movement blog Page is Loaded Successfully
			Then Click on 3 lines on blog home page
			Then Click on Trending option and verify url
			Then Close the browser						
			
	 Scenario Outline: Verify when category Option is clicked more options pops up with the option to navigate back to the original option 
			Given Movement blog Page is Loaded Successfully
			Then Click on 3 dots beside Categories Option
			Then Click on category Option and verify more options pops up with the option to navigate back to the original option
			Then Close the browser	
			
	Scenario Outline: Verify Market Update Option redirects properly 
			Given Movement blog Page is Loaded Successfully
			Then Click on 3 dots beside Categories Option
			Then Click on Market Update option inside Categories Option and verify url
			Then Close the browser
			
	Scenario Outline: Verify Movement Foundation Option redirects properly 
			Given Movement blog Page is Loaded Successfully
			Then Click on 3 dots beside Categories Option
			Then Click on Movement Foundation option inside Categories Option and verify url
			Then Close the browser					
					
	Scenario Outline: Verify Movement News Option redirects properly 
			Given Movement blog Page is Loaded Successfully
			Then Click on 3 dots beside Categories Option
			Then Click on Movement News option inside Categories Option and verify url
			Then Close the browser
			
	 Scenario Outline: Verify Mortgage 101 Option redirects properly 
			Given Movement blog Page is Loaded Successfully
			Then Click on 3 dots beside Categories Option
			Then Click on Mortgage 101 option inside Categories Option and verify url
			Then Close the browser	
			
			
	 Scenario Outline: Verify Spotlight Option redirects properly 
			Given Movement blog Page is Loaded Successfully
			Then Click on 3 dots beside Categories Option
			Then Click on Spotlight option inside Categories Option and verify url
			Then Close the browser
			
	 Scenario Outline: Verify About Option redirects properly 
			Given Movement blog Page is Loaded Successfully
			Then Click on 3 lines on blog home page
			Then Click on About option and verify url
			Then Close the browser
			
	 Scenario Outline: Verify movement.com Option redirects properly 
			Given Movement blog Page is Loaded Successfully
			Then Click on 3 lines on blog home page
			Then Click on movement.com option and verify url
			Then Close the browser
			
	 Scenario Outline: Verify MARKET UPDATE redirects properly 
			Given Movement blog Page is Loaded Successfully
			Then Click on MARKET UPDATE and verify url
			Then Close the browser									