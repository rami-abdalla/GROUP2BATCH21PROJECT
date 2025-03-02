Feature: Add employee

  Background:
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard
    When Admin selects PIM and redirects to Add employee

  @Employeeadded
  Scenario: creating new employee without unique employee ID

    When Admin enters firstname and lastname without employee ID
    And Admin clicks Save
    Then Admin should be redirected to employee personal details page with New employee firstname and lastname should be created with unique employee ID



    @Employeeadded
    Scenario: Adding new employee using firstname, lastname, and unique user ID

      When Admin enters firstname, lastname, and unique employee ID
      And Admin selects save
      Then Admin Should be redirected to employee personal details page with employee firstname, lastname, and unique employee ID present
