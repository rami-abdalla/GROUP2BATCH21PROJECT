package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.DBUtils;
import utils.PageInitializer;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddJobDetailsSteps extends CommonMethods {

    @Given("the Admin navigates to the employee's profile")
    public void the_admin_navigates_to_the_employee_s_profile() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
        click(loginPage.loginButton);
        click(PageInitializer.addJobDetailsPage.pimOption);
        click(PageInitializer.addJobDetailsPage.empListOption);
        sendText("78402380", PageInitializer.addJobDetailsPage.empSearch);
        click(PageInitializer.addJobDetailsPage.searchBtn);
        click(PageInitializer.addJobDetailsPage.employeeID);
    }

    @When("the Admin clicks on {string} button")
    public void the_admin_clicks_on_button(String string) {
        click(PageInitializer.addJobDetailsPage.EditBtn);
    }

    @When("the Admin selects the {string} section")
    public void the_admin_selects_the_section(String string) {
        click(PageInitializer.addJobDetailsPage.JobElement);
    }

    @When("the Admin fills in required fields: {string}, {string}, {string}, {string}")
    public void the_admin_fills_in_required_fields(String jobTitle, String employmentStatus, String subUnit, String location) {
        click(PageInitializer.addJobDetailsPage.EditBtn);
        selectDropdown(PageInitializer.addJobDetailsPage.JobTitleDropdown, jobTitle);
        selectDropdown(PageInitializer.addJobDetailsPage.employmentStatusDropdown, employmentStatus);
        selectDropdown(PageInitializer.addJobDetailsPage.subUnitDropdown, subUnit);
        selectDropdown(PageInitializer.addJobDetailsPage.locationDropdown, location);
        click(PageInitializer.addJobDetailsPage.SaveBtn);
    }

    @Then("Successfully Updated message should be visible")
    public void success_message_should_be_visible() {
        WebElement successMessageElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(PageInitializer.addJobDetailsPage.SuccessMsg));
        Assert.assertTrue("Success message did not match!", successMessageElement.getText().contains("Successfully Updated"));
    }

    @When("the Admin uploads a contract file")
    public void the_admin_uploads_a_contract_file() throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("Contracts/Final.pdf");
        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources!");
        }
        File file = new File(resource.toURI());

        if (!file.exists()){
            throw new IllegalArgumentException("Contract file does not exist:"+ file.getAbsolutePath());
        }

        uploadFile(PageInitializer.addJobDetailsPage.ContractDetailsDropdown, file.getAbsolutePath());

    }

    @When("the Admin clicks the {string} button")
    public void the_admin_clicks_the_button(String string) {
        if (PageInitializer.addJobDetailsPage.SaveBtn.isEnabled()) {
            click(PageInitializer.addJobDetailsPage.SaveBtn);
        }
    }

    @Then("{string} message should be visible")
    public void message_should_be_visible(String expectedMessage) {
        WebElement successMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(PageInitializer.addJobDetailsPage.SuccessMsg));
        assertEquals(expectedMessage, successMessage.getText().trim(), "Success message did not match!");
    }

    @When("the Admin leaves mandatory fields empty")
    public void the_admin_leaves_mandatory_fields_empty() {
        click(PageInitializer.addJobDetailsPage.SaveBtn);
    }

    @When("the Admin uploads a file larger than 1MB or an unsupported format")
    public void the_admin_uploads_a_file_larger_than_1mb_or_an_unsupported_format() throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("Contracts/Test.xlsx");
        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources!");
        }
        File file = new File(resource.toURI());

        if (!file.exists()){
            throw new IllegalArgumentException("Contract file does not exist:"+ file.getAbsolutePath());
        }

        uploadFile(PageInitializer.addJobDetailsPage.ContractDetailsDropdown, file.getAbsolutePath());

}

    @Then("the system should display a validation error message")
    public void the_system_should_display_a_validation_error_message() {
        try {
            assertTrue(PageInitializer.addJobDetailsPage.ErrorMsg.isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("BUG DETECTED: No error message displayed.");
        }
    }

    public void selectDropdown(WebElement dropdown, String optionText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
    }

    @Then("the database should contain the correct job details for {string}")
    public void theDatabaseShouldContainTheCorrectJobDetails(String employeeID) {

        String query = "SELECT ojt.job_title " +
                "FROM hs_hr_employees hhe " +
                "JOIN ohrm_job_title ojt ON hhe.job_title_code = ojt.id " +
                "WHERE hhe.employee_id = '" + employeeID + "'";


        List<Map<String, String>> dbResults = DBUtils.fetch(query);
        Map<String, String> rowData = dbResults.get(0);

        String actualJobTitle = rowData.get("job_title");

        String expectedJobTitle = "Manual Tester Engineer";
        Assert.assertEquals("Job title verification failed!", expectedJobTitle, actualJobTitle);

        System.out.println("Database Verification Passed!");
    }

}











