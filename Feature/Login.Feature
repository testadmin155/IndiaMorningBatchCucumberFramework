Feature: Login

@Sanity
	Scenario: Single Login 
    Given User launch browser
    When user opens url "https://app-eu1.hubspot.com/login/"
    And User enters valid email as "automationtestacademy123@gmail.com" and valid Password as "Test@9999"
    And Click on Login button
    Then Page Title should be "HubSpot Login"
    And Close browser
    
@Regression
  Scenario Outline: Multi Login 
    Given User launch browser
    When user opens url "https://app-eu1.hubspot.com/login/"
    And User enters valid email as "<email>" and valid Password as "<pwd>"
    And Click on Login button
    Then Page Title should be "HubSpot Login"
    And Close browser
    

    Examples: 
      | email  													| pwd 			|
      | automationtestacademy@gmail.com | Test@9999 |
      | skanees007@gmail.com					  | Test@8888 |
    
    