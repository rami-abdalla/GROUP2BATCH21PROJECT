Feature: Edit Personal Information as ESS user

  Background:
    When user enters "johnsmith123" and "CucumberTestingisFun1234!!!"
    Then user is able to see dashboard
    And  user clicks [My info] link
    When User clicks [Edit] button


  Scenario: ESS user updates all personal details
    When User enters "Jack","J","Black","Male", "Single","Ukrainian":
    And User hits [Save] button
    Then Message Sucessfull update is shown.


  Scenario: Database verification
    When User enters "Jack","J","Black","Male", "Single","Ukrainian" and hits [Save] button
    Then The updated employee information is saved in the database successfully


