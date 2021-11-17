Feature: Forgot Password
  Verify the user is able to login in to the site by clicking on forgot password
    @tag
  Scenario: Click on Forgot Password as authenticated user
    Given user is on login page
    When  user  clicks on forgot password
    Then  reset password page is displayed
    When  user enter valid VaibhavSharma
    Then  click on get password and it should accept the details and show success message
    @tag
  Scenario: Click on Forgot Password as unauthenticated user
    Given user is on login page
    When  user  clicks on forgot password
    Then  reset password page is displayed
    When user enter invalid username
    Then click on get password and it should not accept the details and show error message1
      @tag
   Scenario: Accept details as a unauthenticated User
    Given user is on login page
    When  user  clicks on forgot password
    Then  reset password page is displayed
    When user enter null username
    Then click on get password and it should not accept the details and show error message2
        @tag
   Scenario: user success login
    Given user is on login page
    When user enters valid username and valid password
    Then user is successfully logged in





