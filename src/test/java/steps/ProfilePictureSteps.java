package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProfilePicturePage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class ProfilePictureSteps extends CommonMethods {


    @Given("I am logged in as an ESS user with valid credentials")
    public void i_am_logged_in_as_an_ess_user_with_valid_credentials() {
        sendText(ConfigReader.read("EssUserName"), profilePicturePage.EssUserName);
        sendText(ConfigReader.read("EssPassword"), profilePicturePage.EssPassword);
        click(profilePicturePage.EssLoginButton);

    }

    @When("I navigate to the {string} section")
    public void i_navigate_to_the_section(String string) {
        click(profilePicturePage.MyInfoLink);
    }
    //------------------------------------->>>>>>>>>

    @When("I upload a valid image with the format {string},{string},or {string} that less than 1MB and has dimensions 200px by 200px")
    public void i_upload_a_valid_image_with_the_format_or_that_less_than_1mb_and_has_demensions_200px_by_200px(String format1, String format2, String format3) throws IOException {

        String[] validFormats = {format1, format2, format3};
        boolean imageUploaded = false;

        for (String format : validFormats) {

            File imageFile = getImageFile(Constants.VALID_IMAGE_DIRECTORY, format);

            if (imageFile == null) {
                System.out.println("No image found with format " + format);
                continue;
            }

            if (imageFile.length() > 1024 * 1024) {
                System.out.println("File " + imageFile.getName() + " is larger than 1MB. Skipping.");
                continue;
            }


            BufferedImage image = ImageIO.read(imageFile);
            if (image.getWidth() > 200 || image.getHeight() > 200) {
                System.out.println("Image " + imageFile.getName() + " does not have dimensions 200x200px. Skipping.");
                continue;
            }

            click(profilePicturePage.empPhoto);
            profilePicturePage.chooseFile.sendKeys(imageFile.getAbsolutePath());
            click(profilePicturePage.upload);


            imageUploaded = true;

        }


        if (!imageUploaded) {
            throw new IOException("No valid image found with the specified formats, size, or dimensions.");


        }

    }

    @Then("the system should display the uploaded profile picture in the profile section")
    public void the_system_should_display_the_uploaded_profile_picture_in_the_profile_section() {
        Assert.assertTrue("Profile picture is not displayed", profilePicturePage.displayPicture.isDisplayed());
    }

    @Then("I should see a success message {string}")
    public void i_should_see_a_success_message(String string) {
        Assert.assertTrue("Successfully Uploaded", profilePicturePage.successMessage.isDisplayed());
    }

    //------------------------------------->>>>>>>>>


    public void PDFReader(WebDriver driver) {
        CommonMethods.driver = driver;
    }

    @When("I upload a file with an unsupported format \\(e.g., {string} or {string})")
    public void i_upload_a_file_with_an_unsupported_format_e_g_or(String format1, String format2) throws URISyntaxException {


        URL resource = getClass().getClassLoader().getResource("InvalidPDFfile/invalid_pdf.pdf");
        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources!");
        }

        File file = new File(resource.toURI());
        click(profilePicturePage.empPhoto);
        profilePicturePage.chooseFile.sendKeys(file.getAbsolutePath());
        click(profilePicturePage.upload);
        readPdfFromFile(file);


        URL BMPResource = getClass().getClassLoader().getResource("InvalidPDFfile/InvalidBMPFile/sample_bmp.bmp");
        if (BMPResource == null) {
            throw new IllegalArgumentException("File not found in resources!");
        }


        File BMPfile = new File(BMPResource.toURI());


        click(profilePicturePage.empPhoto);
        profilePicturePage.chooseFile.sendKeys(BMPfile.getAbsolutePath());
        click(profilePicturePage.upload);


    }


    @Then("the system should display an error message {string}")
    public void the_system_should_display_an_error_message(String errorMessage) {
        if (errorMessage.equals("Failed to Save: File Type Not Allowed")) {
            String actualMessage = profilePicturePage.unSupportedFileTypeWarning.getText().trim();
            actualMessage = actualMessage.replaceAll("\\\\[.*\\\\ ]", "").trim();
            actualMessage = actualMessage.replaceAll("Close$", "").trim();
            Assert.assertEquals("Error message mismatch", errorMessage, actualMessage);
        } else if (errorMessage.equals("Failed to Save: File Size Exceeded")) {
            String actualMessage = profilePicturePage.sizeExceededWarning.getText().trim();
            actualMessage = actualMessage.replaceAll("\\\\[.*\\\\ ]", "").trim();
            actualMessage = actualMessage.replaceAll("Close$", "").trim();
            Assert.assertEquals("Error message mismatch", errorMessage, actualMessage);
        } else if (errorMessage.equals("Image dimensions are incorrect. Please upload an image of 200px x 200px.")) {
            String actualMessage = profilePicturePage.incorrectDimensions.getText().trim();
            actualMessage = actualMessage.replaceAll("\\\\[.*\\\\ ]", "").trim();
            actualMessage = actualMessage.replaceAll("Close$", "").trim();
            Assert.assertEquals("Error message mismatch", errorMessage, actualMessage);

        } else {
            Assert.fail("Unhandled error type: " + errorMessage);
        }
    }

    //------------------------------------->>>>>>>>>

    @When("I upload a file larger than 1MB")
    public void i_upload_a_file_larger_than_1mb() throws URISyntaxException {
        URL fileResource = getClass().getClassLoader().getResource("Invalid Profile Pictures/LargerThan1-MB-png.png");
        if (fileResource == null) {
            throw new IllegalArgumentException("File not found in resources!");
        }
        File file = new File(fileResource.toURI());

        click(profilePicturePage.empPhoto);
        profilePicturePage.chooseFile.sendKeys(file.getAbsolutePath());
        click(profilePicturePage.upload);
    }

    //------------------------------------->>>>>>>>>


    @When("I upload an image with dimensions bigger than 200px x 200px")
    public void i_upload_an_image_with_dimensions_other_than_200px_x_200px() throws URISyntaxException {
        URL fileResource = getClass().getClassLoader().getResource("Invalid Profile Pictures/Test_300x300.png");
        if (fileResource == null) {
            throw new IllegalArgumentException("File not found in resources!");
        }
        File file = new File(fileResource.toURI());

        click(profilePicturePage.empPhoto);
        profilePicturePage.chooseFile.sendKeys(file.getAbsolutePath());
        click(profilePicturePage.upload);
    }


}
