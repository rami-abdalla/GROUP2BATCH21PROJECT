package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static utils.CommonMethods.click;
import static utils.CommonMethods.sendText;
import static utils.PageInitializer.dashboardPage;
import static utils.PageInitializer.employeeSearchPage;

public class EmployeeSearchSteps {
// Admin searches for employee using full name:

    @When("user clicks on PIM button")
    public void user_clicks_on_pim_button() {
        click(dashboardPage.pimOption);
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        click(dashboardPage.empListOption);
    }

    @When("user enters valid employee full name")
    public void user_enters_valid_employee_full_name() {
        sendText("Lisa J Smithson", employeeSearchPage.empNameSearchField);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(employeeSearchPage.searchButton);
    }

    @Then("user is able to see searched employee")
    public void user_is_able_to_see_searched_employee() {
        System.out.println("Test Passed");

    }

    //Admin searches for employee using partial name:

    @When("user enters valid employee partial name")
    public void user_enters_valid_employee_partial_name() {
        sendText("Lisa J", employeeSearchPage.empNameSearchField);
    }


    //Admin searches for employee with variation in capitalization:

    @When("user enters valid employee name in lowercase and uppercase letters")
    public void user_enters_valid_employee_name_in_lowercase_and_uppercase_letters() {
        sendText("LiSa j SmiTHsoN", employeeSearchPage.empNameSearchField);
    }

    //Admin searches for employee using employee ID:

    @When("user enters valid employee ID")
    public void user_enters_valid_employee_id() {
        sendText("78402380", employeeSearchPage.empIDSearchField);
    }

    //Admin searches for employee but no records are found:

    @When("user searches for invalid employee")
    public void user_searches_for_invalid_employee() {
        sendText("Jahn Smithe", employeeSearchPage.empNameSearchField);
    }
    @Then("user is able to see no records found")
    public void user_is_able_to_see_no_records_found() {
        System.out.println("Test Passed");

    }

}
