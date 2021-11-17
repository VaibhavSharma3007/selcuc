Feature: Home Feature
  Verify the user is able to open all the functionalities in home page
  @tag1
  Scenario: To validate sign up functionality
    Given user is on home page
    When user clicks on sign up
    Then sign up page is displayed
  Scenario: To validate pricing functionality
    Given user is on home page
    When user clicks on pricing
    Then pricing page is displayed
  Scenario: To validate features functionality
    Given user is on home page
    When user clicks on features
    Then features page is displayed
  Scenario: To validate customer functionality
    Given user is on home page
    When user clicks on customer
    Then customer page is displayed
  Scenario: To validate contact functionality
    Given user is on home page
    When user clicks on contact
    Then contact page is displayed