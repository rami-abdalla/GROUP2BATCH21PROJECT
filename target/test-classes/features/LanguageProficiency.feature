Feature: Language Proficiency Management

  Background:
    Given the employee is logged into the HRMS application
    When the employee navigates to My info page
    And user clicks on Qualifications section



  @smoke
  Scenario: Add Language
    And user clicks on Add button
    Then the add language form should be displayed
    When user selects "German" as the language
    And user selects Writing as the fluency level
    And user selects Good as the competency
    And user enters "Good understanding of the language" in the comments field
    And user clicks the save button to save the language proficiency
    Then the system should save the language proficiency details successfully
    And the language proficiency details should be visible in the profile

  @smoke2
  Scenario: Edit existing language proficiency details
    When user selects German as the language to edit
    And user sets competency to Basic
    And user enters "Needs improvement" for the comments field
    And user clicks the save button save language proficiency
    Then the system should update the language proficiency details successfully
    And the updated language proficiency details should be visible in the profile

  @smoke3
  Scenario: Delete language proficiency details
   When user selects German as the language to delete
    Then the system should remove the language proficiency details successfully
    Then the system should show the successfully deleted message

