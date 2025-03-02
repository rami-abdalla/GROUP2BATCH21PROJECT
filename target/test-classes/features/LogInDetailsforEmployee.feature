Feature: Creating Login details for an Employee in the HRMS Application
  As an HRMS application administrator,
  I want to create login credentials for a new employee in the HRMS system,
  So that the employee can access the HRMS application with unique login details.



  @EmployeeDetails
  Scenario: Admin creates login details for a new employee
    When user enters admin username and password
    And user clicks on login button
    When the admin navigates to the Add Employee page
    And enters the first name
    And enters the middle name
    And enters the last name
    And checks the Create Login Details checkbox
    Then the admin enters a unique username
    And enters a password
    And re-enters the password for confirmation
    When the admin selects the status from the dropdown
    And clicks the Save button


    @RecentlyAddedEmployee
    Scenario: Use the recently created employee to login
      When User enters the recently created username and password
      Then User click on login button
      Then User sees HRMS homepage



