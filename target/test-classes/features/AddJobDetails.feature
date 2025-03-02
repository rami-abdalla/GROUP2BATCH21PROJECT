Feature: Add/update employee's job details

  Background:
    Given the Admin navigates to the employee's profile
    When the Admin selects the "Job" section
    When the Admin clicks on "Edit" button
    When the Admin clicks the "Save" button


  @Meri
  Scenario: Admin adds job details

    When the Admin fills in required fields: "Manual Tester Engineer", "FullTime", "IT Support", "Big Office"
    And the Admin uploads a contract file
    Then Successfully Updated message should be visible
    And the database should contain the correct job details for "78402380"

  @Meri
  Scenario: Admin attempts to save job details without filling mandatory fields

    When the Admin leaves mandatory fields empty
    Then the system should display a validation error message


  @Meri
  Scenario: Admin uploads an invalid contract file

    When the Admin uploads a file larger than 1MB or an unsupported format
    Then the system should display a validation error message


