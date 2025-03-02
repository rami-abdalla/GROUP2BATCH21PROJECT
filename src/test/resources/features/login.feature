Feature: Login Scenarios



  @validLogin
  Scenario: Valid admin login
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard

    @invalidLogin
    Scenario: Invalid login scenario
      
      When user enters invalid username and password
      And user clicks on login button
      Then user is able to see error message

