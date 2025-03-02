package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LogInDetailsforEmployeePage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

import static utils.CommonMethods.click;
import static utils.CommonMethods.sendText;
import static utils.PageInitializer.detailsforEmployeePage;

public class LogInDetailsforEmployee extends CommonMethods {

    public WebDriver driver;


    @When("the admin navigates to the Add Employee page")
    public void the_admin_navigates_to_the_add_employee_page() {

        click(dashboardPage.pimOption);
        click(dashboardPage.addEmployeeOption);
    }
    @When("enters the first name")
    public void enters_the_first_name() {

        sendText(ConfigReader.read("EmpFirstName"), detailsforEmployeePage.firstName);
    }
    @When("enters the middle name")
    public void enters_the_middle_name() {

        sendText(ConfigReader.read("EmpMiddleName"), detailsforEmployeePage.middleName);

    }
    @When("enters the last name")
    public void enters_the_last_name() {

        sendText(ConfigReader.read("EmpLastName"), detailsforEmployeePage.lastName);

    }
    @When("checks the Create Login Details checkbox")
    public void checks_the_create_login_details_checkbox() {

        click(detailsforEmployeePage.loginCheckbox);
    }
    @Then("the admin enters a unique username")
    public void the_admin_enters_a_unique_username() {

        sendText(ConfigReader.read("EmpUserName"), detailsforEmployeePage.employeeUsername);
    }
    @Then("enters a password")
    public void enters_a_password() {
        sendText(ConfigReader.read("EmpPassword"), detailsforEmployeePage.employeePassword);

    }
    @Then("re-enters the password for confirmation")
    public void re_enters_the_password_for_confirmation() {

        sendText(ConfigReader.read("EmpPassword"), detailsforEmployeePage.confirmPassword);
    }
    @When("the admin selects the status from the dropdown")
    public void the_admin_selects_the_status_from_the_dropdown() {
        click(detailsforEmployeePage.statusDropdown);
        click(detailsforEmployeePage.Enabled);
    }
    @When("clicks the Save button")
    public void clicks_the_save_button() throws InterruptedException {

        Thread.sleep(2000);
        click(detailsforEmployeePage.saveButton);
    }
    @When("User enters the recently created username and password")
    public void user_enters_the_recently_created_username_and_password() {
        sendText(ConfigReader.read("EmpUserName"), detailsforEmployeePage.usernameField);
        sendText(ConfigReader.read("EmpPassword"), detailsforEmployeePage.passwordField);

    }
    @Then("User click on login button")
    public void user_click_on_login_button() {
       click(detailsforEmployeePage.loginButton);
    }
    @Then("User sees HRMS homepage")
    public void user_sees_hrms_homepage() {
        String welcomeMsg = detailsforEmployeePage.welcome.getText();
        Assert.assertEquals("Welcome Jupiterag", welcomeMsg);
        System.out.println("Welcome message shown");
    }

}




