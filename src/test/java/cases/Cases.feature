Feature: Cases Feature
  Verify the user is able to click on cases 
  @tag
  Scenario: Login as a authenticated User
    Given user is on login page
    When user enters valid username and valid password
    Then success message is displayed
    @tag
  Scenario: To validate click on new cases 
    Given user is on home page after login
    When user clicks on new cases
    Then success message is displayed
    @tag
   Scenario: To validate that user is able to add details 
    Given user is on add cases page
    And user enter title 
    When user clicks on save button
    Then data is saved
    @tag
   Scenario: To validate that user is able to add details 
    Given user is on add cases page
    And user enter null details in title 
    When user clicks on save button
    Then alert box is shown
    @tag
   Scenario: To validate click on search form 
    Given user is on home page after login
    When user clicks on full search form button
    Then success message is displayed
    @tag
   Scenario: To validate that user is able to search details 
    Given user is on search cases page
    And user enter valid title
    When user clicks on search button
    Then search data is saved
    @tag
   Scenario: To validate that user is able to search details 
    Given user is on search cases page
    And user enter invalid title
    When user clicks on search button
    Then no data is shown
   Scenario: To validate that user is able to add details 
    Given user is on add cases page
    And user enter same added title 
    When user clicks on save button
    Then it shows data is already entered
   
   
   