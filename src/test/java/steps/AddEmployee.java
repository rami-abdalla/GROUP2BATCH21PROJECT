package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class AddEmployee extends CommonMethods {



       @When("Admin selects PIM and redirects to Add employee")
        public void admin_selects_pim_and_redirects_to_add_employee() {
            click(dashboardPage.pimOption);
            click(dashboardPage.addEmployeeOption);
        }
        @When("Admin enters firstname and lastname without employee ID")
        public void admin_enters_firstname_and_lastname_without_employee_id() {
            sendText(ConfigReader.read("addEmpUserName"), addEmployeePage.firstName);
            sendText(ConfigReader.read("addEmpMidName"), addEmployeePage.middleName);
            sendText(ConfigReader.read("addEmpLastName"), addEmployeePage.lastName);
            sendText(ConfigReader.read("addEmpId"), addEmployeePage.employeeId);



        }
        @When("Admin clicks Save")
        public void admin_clicks_save() {
            click(addEmployeePage.btnSave);

        }
        @Then("Admin should be redirected to employee personal details page with New employee firstname and lastname should be created with unique employee ID")
        public void admin_should_be_redirected_to_employee_personal_details_page_with_new_employee_firstname_and_lastname_should_be_created_with_unique_employee_id() {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            WebElement employeeIdElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtEmployeeId")));


            try {

                employeeIdElement = wait.until(ExpectedConditions.visibilityOf(employeeIdElement));
            } catch (TimeoutException e) {
                Assert.fail("Employee ID element is not visible after waiting for 10 seconds");
            }


            Assert.assertTrue("Employee ID is not displayed", employeeIdElement.isDisplayed());


            String existedEmpID = employeeIdElement.getAttribute("value").trim();
            System.out.println("Employee ID shown: " + existedEmpID);


            driver.switchTo().defaultContent();

            System.out.println("Employee ID shown: " + existedEmpID);

        }

    @When("Admin enters firstname, lastname, and unique employee ID")
    public void admin_enters_firstname_lastname_and_unique_employee_id() {
        sendText("Saul", addEmployeePage.firstName);
        sendText("M.", addEmployeePage.middleName);
        sendText("Michael", addEmployeePage.lastName);
        sendText("123543813289", addEmployeePage.employeeId);

    }
    @When("Admin selects save")
    public void admin_selects_save() {
        click(addEmployeePage.btnSave);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
    @Then("Admin Should be redirected to employee personal details page with employee firstname, lastname, and unique employee ID present")
    public void admin_should_be_redirected_to_employee_personal_details_page_with_employee_firstname_lastname_and_unique_employee_id_present() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement employeeIdElement = wait.until(ExpectedConditions.visibilityOf(addEmployeePage.existedEmpId));
        String existedEmpID = employeeIdElement.getAttribute("value").trim();
        Assert.assertTrue("Employee ID is not displayed", employeeIdElement.isDisplayed());
        System.out.println("Employee ID shown: " + existedEmpID);


    }






}
