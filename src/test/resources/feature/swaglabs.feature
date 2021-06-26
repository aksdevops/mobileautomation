Feature: Regression ADIB ONB Test

  Background: User Performs Login
    Given User launches the Mobile Application to land on Welcome Page
    When User performs login with username "standard_user" and password "secret_sauce"
    Then User should be able to land on Dashboard page
    
    @Regression @TestLabs @Positive
    Scenario: Positive:Validate if the all the added items are not listed in cart when add products link is clicked
    When User Add and verify added Product in checkoutflow
    
    @Sanity @TestLabs @Negative
    Scenario: Negative:Deleted Products are verified in cart once deleted from dashboard
    When User Add and verify added Product in checkoutflow
    When User Delete and verify deleted Product in checkoutflow
    
    @Smoke @TestLabs @Negative
    Scenario: Negative:Validate if Deleted Products are verified in dashboard once deleted from cart
    When User Add and delete added Product in checkoutflow
    Then Verify the deleted Product is ready to be added again from dashboard