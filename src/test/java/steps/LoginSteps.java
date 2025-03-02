package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {


    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() {

        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"),loginPage.passwordField);


    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }

    @Then("user is able to see dashboard")
    public void user_is_able_to_see_dashboard() {

        Assert.assertTrue(dashboardPage.messageText.isDisplayed());
        System.out.println("Test Passed");

        }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        sendText("wrongUsername", loginPage.usernameField);
        sendText("wrongPassword", loginPage.passwordField);
    }
    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        String errorMsg = loginPage.errorMessage.getText();
        Assert.assertEquals("Invalid credentials",errorMsg);
        System.out.println("Error Message shown");

    }


}
