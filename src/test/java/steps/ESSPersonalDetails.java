package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.DBUtils;
import java.util.List;
import java.util.Map;

public class ESSPersonalDetails extends CommonMethods {
    String expectedFN;
    String expectedMN;
    String expectedLN;
    String expectedGender;
    String expectedGenderID;
    String expectedMaritalStatus;
    String expectedNationality;
    String expectedNationalityID;


    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        login("EssUserName","EssPassword");

    }

    @Then("user clicks [My info] link")
    public void user_clicks_my_info_link() {
        click(essPersonalInfoPage.MyInfoLink);
    }

    @When("User clicks [Edit] button")
    public void user_clicks_edit_button() {
        click(essPersonalInfoPage.editBTN);
    }

    @When("User enters {string},{string},{string},{string}, {string},{string}:")
    public void userEnters(String fname, String mname, String lastname, String gender, String maritalSt, String nationality) {
        sendText(fname, essPersonalInfoPage.PersonalFirstName);
        sendText(mname, essPersonalInfoPage.PersonalMiddleName);
        sendText(lastname, essPersonalInfoPage.PersonalLastName);
        click(essPersonalInfoPage.MaleRB);
        selectDropdownByValue(essPersonalInfoPage.maritalStatusDD, maritalSt);
        selectDropdownByVisibleText(essPersonalInfoPage.nationalityDD, nationality);
    }

    @And("User hits [Save] button")
    public void userHitsSaveButton() {
        click(essPersonalInfoPage.saveBTN);
    }

    @Then("Message Sucessfull update is shown.")
    public void messageSucessfullUpdateIsShown() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.fadable")));
    }

    @When("User enters {string},{string},{string},{string}, {string},{string} and hits [Save] button")
    public void userEntersAndHitsSaveButton(String firstname, String middlename, String lastName, String gend, String maritalST, String Nationality2) {
        expectedFN = firstname;
        expectedMN = middlename;
        expectedLN = lastName;
        expectedGender = gend;
        expectedNationality = Nationality2;
        expectedNationalityID = essPersonalInfoPage.nationalityDD.getAttribute("value");
        expectedMaritalStatus = maritalST;

        sendText(firstname, essPersonalInfoPage.PersonalFirstName);
        sendText(middlename, essPersonalInfoPage.PersonalMiddleName);
        sendText(lastName, essPersonalInfoPage.PersonalLastName);
        click(essPersonalInfoPage.MaleRB);
        selectDropdownByValue(essPersonalInfoPage.maritalStatusDD, maritalST);
        selectDropdownByVisibleText(essPersonalInfoPage.nationalityDD, Nationality2);
        click(essPersonalInfoPage.saveBTN);

        String expectedGender = essPersonalInfoPage.MaleRB.getText();
        expectedGenderID = essPersonalInfoPage.MaleRBID.getAttribute("value");
        verifyInputValue(essPersonalInfoPage.PersonalFirstName, expectedFN);
        verifyInputValue(essPersonalInfoPage.PersonalMiddleName, expectedMN);
        verifyInputValue(essPersonalInfoPage.PersonalLastName, expectedLN);
        Assert.assertEquals(expectedGender, gend);
        verifyInputValue(essPersonalInfoPage.maritalStatusDD, maritalST);
        verifyInputValue(essPersonalInfoPage.nationalityDD, expectedNationalityID);
    }

    @Then("The updated employee information is saved in the database successfully")
    public void theUpdatedEmployeeInformationIsSavedInTheDatabaseSuccessfully() {

        String query = "select emp_lastname, emp_firstname, emp_middle_name, nation_code, emp_gender, emp_marital_status from hs_hr_employees where employee_id = " + ConfigReader.read("employee_id");
        List<Map<String, String>> actualData = DBUtils.fetch(query);
        Map<String, String> rowMap = actualData.get(0);
        System.out.println(rowMap);
        String actualFN=rowMap.get("emp_firstname");
        String actualMN=rowMap.get("emp_middle_name");
        String actualLN=rowMap.get("emp_lastname");
        String actualNC=rowMap.get("nation_code");
        String actualGen=rowMap.get("emp_gender");
        String actualMS=rowMap.get("emp_marital_status");

        Assert.assertEquals(actualFN,expectedFN);
        Assert.assertEquals(actualMN,expectedMN);
        Assert.assertEquals(actualLN,expectedLN);
        Assert.assertEquals(actualNC,expectedNationalityID);
        Assert.assertEquals(actualGen,expectedGenderID);
        Assert.assertEquals(actualMS,expectedMaritalStatus);
    }

}
