Feature: Profile Picture Upload for ESS Users


  Background:
  Given I am logged in as an ESS user with valid credentials
  When I navigate to the "Profile" section


  @smoke
  Scenario: Upload Valid Profile Picture


    And I upload a valid image with the format ".jpg",".png",or "gif" that less than 1MB and has dimensions 200px by 200px
    Then the system should display the uploaded profile picture in the profile section
    And I should see a success message "Successfully Uploaded"

  @morning
  Scenario: Upload an invalid profile picture format

    And I upload a file with an unsupported format (e.g., ".bmp" or ".pdf")
    Then the system should display an error message "Failed to Save: File Type Not Allowed"

    @evening
  Scenario: Upload a profile picture larger than 1MB

    And I upload a file larger than 1MB
    Then the system should display an error message "Failed to Save: File Size Exceeded"

  @afternoon
  Scenario: Upload a profile picture with incorrect dimensions

    And I upload an image with dimensions bigger than 200px x 200px
    Then the system should display an error message "Image dimensions are incorrect. Please upload an image of 200px x 200px."




























