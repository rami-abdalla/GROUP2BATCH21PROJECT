Feature: Employee Search

  Background:
      # Given user is able to access HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard
    When user clicks on PIM button
    And user clicks on employee list option

  @employeefullname
  Scenario: Admin searches for employee using full name
    When user enters valid employee full name
    And user clicks on search button
    Then user is able to see searched employee

  @employeepartialname
  Scenario: Admin searches for employee using partial name
    When user enters valid employee partial name
    And user clicks on search button
    Then user is able to see searched employee

  @capitalizationvaries
  Scenario: Admin searches for employee with variation in capitalization
    When user enters valid employee name in lowercase and uppercase letters
    And user clicks on search button
    Then user is able to see searched employee

  @employeeid
  Scenario: Admin searches for employee using employee ID
    When user enters valid employee ID
    And user clicks on search button
    Then user is able to see searched employee

  @norecords
  Scenario: Admin searches for employee but no records are found
    When user searches for invalid employee
    And user clicks on search button
    Then user is able to see no records found