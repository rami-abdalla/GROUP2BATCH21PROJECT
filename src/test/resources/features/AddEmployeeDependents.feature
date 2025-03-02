Feature: Add Dependents to Employee Profile in HRMS Application
  Background:
    Given the employee is logged into the HRMS application
    When the employee navigates to My info page
    And the employee clicks on the Dependents section in the profile

  @regression
  @happyPath0
  Scenario: Employee successfully adds a dependents
    When the employee clicks on the Add button to add a dependent
    And the employee enters the Name "Edvard Jones":
    And the employee selects the relationship as "child" from the dropdown.
    And the employee selects the Date of birth from calender as "2020-12-21"
    And clicks on the Save button
    Then the dependent list should display "Edvard Jones" with relationship "child" and date of birth "2020-12-21"
    When the employee clicks on the checkbox next to "Edvard Jones"
    And the employee clicks on the Delete button

  @happyPath
  @regression
  Scenario: Employee adds multiple dependents
    Given the employee clicks on the Add button to add a dependent
    And the employee enters the Name "Edvard J. Jones":
    And the employee selects the relationship as "child" from the dropdown.
    And the employee selects the Date of birth from calender as "2016-05-12"
    And clicks on the Save button
    And the employee clicks on the Add button to add a dependent
    And the employee enters the Name "Jane Jones":
    And the employee selects the relationship as "child" from the dropdown.
    And the employee selects the Date of birth from calender as "2010-03-22"
    And clicks on the Save button
    Then the dependent list should display "Edvard J. Jones" with relationship "child" and date of birth "2016-05-12"
    Then the dependent list should display "Jane Jones" with relationship "child" and date of birth "2010-03-22"
    When the employee clicks on the checkbox next to "Edvard J. Jones"
    When the employee clicks on the checkbox next to "Jane Jones"
    And the employee clicks on the Delete button

  @negativePat2
  @regression
  Scenario: Employee deletes a dependent
    Given the employee clicks on the Add button to add a dependent
    And the employee enters the Name "Frank jones":
    And the employee selects the relationship as "child" from the dropdown.
    And the employee selects the Date of birth from calender as "2016-05-12"
    And clicks on the Save button
    Then the dependent list should display "Frank jones" with relationship "child" and date of birth "2016-05-12"
    When the employee clicks on the checkbox next to "Frank jones"
    And the employee clicks on the Delete button
    Then the dependent list should not display "Frank jones" with relationship "child" and date of birth "2016-05-12"

  @negativePat1
  @regression
  Scenario: Employee adds a dependent with missing information
    Given the employee clicks on the Add button to add a dependent
    When the employee leaves the "" field empty
    And the employee selects the relationship as "child" from the dropdown.
    And the employee selects the Date of birth from calender as "2020-12-21"
    And clicks on the Save button
    Then the system should show an error message "Required" below name input field







