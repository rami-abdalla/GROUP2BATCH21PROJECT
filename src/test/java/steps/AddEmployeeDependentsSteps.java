package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class AddEmployeeDependentsSteps extends CommonMethods {
    @Given("the employee is logged into the HRMS application")
    public void the_employee_is_logged_into_the_hrms_application() {
        login("employeeUserName", "employeePassword");
    }

    @When("the employee navigates to My info page")
    public void the_employee_navigates_to_page_my_info_page() {
        click(myInfoPage.myInfoTab);
    }

    @When("the employee clicks on the Dependents section in the profile")
    public void the_employee_clicks_on_the_dependents_section_in_the_profile() {
        click(myInfoPage.dependents);
    }

    @When("the employee clicks on the Add button to add a dependent")
    public void the_employee_clicks_on_the_add_button_to_add_a_dependent() {
        click(employeeDependentsPage.addDependentButton);
    }

    @When("the employee enters the Name {string}:")
    public void the_employee_enters_the_name(String string) {
        sendText(string, employeeDependentsPage.dependentNameInputField);
    }

    @When("the employee selects the relationship as {string} from the dropdown.")
    public void the_employee_selects_the_relationship_as_from_the_dropdown(String string) {
        selectFromDropDown(string, employeeDependentsPage.dependentRelationshipDropdown);
    }

    @When("the employee selects the Date of birth from calender as {string}")
    public void the_employee_selects_the_date_of_birth_from_calender_as(String string) {
        sendText(string, employeeDependentsPage.dependentDateOfBirthInputField);
    }

    @When("clicks on the Save button")
    public void clicks_on_the_save_button() {
        click(employeeDependentsPage.addSaveButton);
    }

    @Then("the dependent list should display {string} with relationship {string} and date of birth {string}")
    public void the_dependent_list_should_display_with_relationship_and_date_of_birth(String string, String string2, String string3) {
        Assert.assertTrue(checkIfRecordExistsInTheTable(employeeDependentsPage.dependentTableIdValue, "Name", string));
        Assert.assertTrue(checkIfRecordExistsInTheTable(employeeDependentsPage.dependentTableIdValue, "Relationship", string2));
        Assert.assertTrue(checkIfRecordExistsInTheTable(employeeDependentsPage.dependentTableIdValue, "Date of Birth", string3));

    }

    @When("the employee leaves the {string} field empty")
    public void the_employee_leaves_the_field_empty(String string) {
        sendText(string, employeeDependentsPage.dependentNameInputField);
    }


    @Then("the system should show an error message {string} below name input field")
    public void the_system_should_show_an_error_message_below_name_input_field(String string) {
        var discovered = getText(employeeDependentsPage.errorMessageRequiredField).trim();
        Assert.assertTrue(discovered.equalsIgnoreCase(string));
    }

    @When("the employee clicks on the checkbox next to {string}")
    public void the_employee_clicks_on_the_checkbox_next_to(String string) {
       selectCheckBox(getCheckBoxXpathByName(getTable(employeeDependentsPage.dependentTableIdValue),string));
    }

    @When("the employee clicks on the Delete button")
    public void the_employee_clicks_on_the_delete_button() {
        click(employeeDependentsPage.deleteField);

    }
    @Then("the dependent list should not display {string} with relationship {string} and date of birth {string}")
    public void the_dependent_list_should_not_display_with_relationship_and_date_of_birth(String string, String string2, String string3) {
        Assert.assertFalse(checkIfRecordExistsInTheTable(employeeDependentsPage.dependentTableIdValue, "Name", string));
        Assert.assertFalse(checkIfRecordExistsInTheTable(employeeDependentsPage.dependentTableIdValue, "Relationship", string2));
        Assert.assertFalse(checkIfRecordExistsInTheTable(employeeDependentsPage.dependentTableIdValue, "Date of Birth", string3));

    }

}
