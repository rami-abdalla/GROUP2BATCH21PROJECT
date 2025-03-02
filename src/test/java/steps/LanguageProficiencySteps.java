package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LanguageProficiencyPage;
import pages.DashboardPage;
import utils.CommonMethods;

import java.time.Duration;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static utils.CommonMethods.click;
import static utils.CommonMethods.driver;

public class LanguageProficiencySteps extends CommonMethods {

    private DashboardPage dashboardPage;
    private LanguageProficiencyPage languageProficiencyPage;

    public LanguageProficiencySteps() {
        this.dashboardPage = new DashboardPage();
        this.languageProficiencyPage = new LanguageProficiencyPage();
    }

    // Navigate to "My Info" page after login
    @When("user clicks on My Info tab")
    public void userClicksOnMyInfoTab() {

        click(LanguageProficiencyPage.MyInfoLink);
    }

    // Navigate to "Qualifications" section under "My Info"
    @And("user clicks on Qualifications section")
    public void userClicksOnQualificationsSection() {
        click(LanguageProficiencyPage.qualificationsLink);
    }





    // Scenario one

    @And("user clicks on Add button")
    public void userClicksOnAddButton() {
        click(LanguageProficiencyPage.addLanguageButton);

    }

    @Then("the add language form should be displayed")
    public void theAddLanguageFormShouldBeDisplayed() {
        assertTrue("The language input field should be displayed", languageProficiencyPage.languageInputField.isDisplayed());
    }



    @When("user selects {string} as the language")
    public void userSelectsLanguage(String Language) {
        click(languageProficiencyPage.German);

    }


    @And("user selects Writing as the fluency level")
    public void userSelectsFluencyLevel() {
        click(LanguageProficiencyPage.Writing);
    }

    @And("user selects Good as the competency")
    public void userSelectsCompetency() {
        click(languageProficiencyPage.Good);

    }


    @And("user enters {string} for the comments field")
    public void userEntersForTheCommentsField(String Comments) {

        click(languageProficiencyPage.commentsTextbox);
        sendText(Comments, languageProficiencyPage.commentsTextbox);
    }

    @And("user clicks the save button to save the language proficiency")
    public void userClicksTheSaveButtonToSaveLanguageProficiency() {
        click(languageProficiencyPage.saveButton);
    }


    @Then("the system should save the language proficiency details successfully")
    public void theSystemShouldSaveTheLanguageProficiencyDetailsSuccessfully() {
        String actualMessage = languageProficiencyPage.successMessage.getText().trim();
        actualMessage = actualMessage.replaceAll("Close$", "").trim();
        Assert.assertEquals("Successfully Saved", actualMessage);
        System.out.println("Success Message Shown");
    }

    @And("the language proficiency details should be visible in the profile")
    public void theLanguageProficiencyDetailsShouldBeVisibleInTheProfile() {
        String actualMessage = languageProficiencyPage.visibleGerman.getText().trim();
        actualMessage = actualMessage.replaceAll("Close$", "").trim();
        Assert.assertEquals("German", actualMessage);
        System.out.println("Success Message Shown");

    }

  


// scenario two

    @When("user selects German as the language to edit")
    public void userSelectsGermanAsTheLanguageToEdit() {
        click(languageProficiencyPage.visibleGerman);
    }





    @And("user sets competency to Basic")
    public void userSetsCompetencyToBasic() {
        click(LanguageProficiencyPage.Basic);

    }

    @And("user enters {string} in the comments field")
    public void userEntersInTheCommentsField(String Comments) {

        click(languageProficiencyPage.commentsTextbox);
        sendText(Comments, languageProficiencyPage.commentsTextbox);


    }


    @And("user clicks the save button save language proficiency")
    public void userClicksSaveButtonSaveLanguageProficiency() {
        click(languageProficiencyPage.saveButton);
    }


    @Then("the system should update the language proficiency details successfully")
    public void theSystemShouldUpdateTheLanguageProficiencyDetailsSuccessfully() {
        String actualMessage = languageProficiencyPage.successMessage.getText().trim();
        actualMessage = actualMessage.replaceAll("Close$", "").trim();
        Assert.assertEquals("Successfully Saved", actualMessage);
        System.out.println("Success Message Shown");
    }

    @And("the updated language proficiency details should be visible in the profile")
    public void theUpdatedLanguageProficiencyDetailsShouldBeVisibleInTheProfile() {
        String actualMessage = languageProficiencyPage.visibleGerman.getText().trim();
        actualMessage = actualMessage.replaceAll("Close$", "").trim();
        Assert.assertEquals("German", actualMessage);
        System.out.println("Success Message Shown");


}



// Scenario Three

    @When("user selects German as the language to delete")
    public void userSelectsGermanLanguageToDelete() {
        click(LanguageProficiencyPage.languageCheckbox);

    }

    @Then("the system should remove the language proficiency details successfully")
    public void theSystemShouldRemoveTheLanguageProficiencyDetailsSuccessfully() {
        // Find the delete button and click it to delete the selected language
        click(languageProficiencyPage.deleteButton);


    }
    @Then("the system should show the successfully deleted message")
    public void theSystemShouldShowTheSuccessfullyDeletedMessage() {

        String actualMessage = languageProficiencyPage.successMessage.getText().trim();
        actualMessage = actualMessage.replaceAll("Close$", "").trim();
        Assert.assertEquals("Successfully Deleted", actualMessage);
        System.out.println("Success Message Shown");
}


    @When("user enters ESS username and password")
    public void userEntersESSUsernameAndPassword() {
        login("EssUserName", "EssPassword");
    }
}




