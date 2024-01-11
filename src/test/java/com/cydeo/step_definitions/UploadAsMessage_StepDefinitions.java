package com.cydeo.step_definitions;

import com.cydeo.pages.Stream_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UploadAsMessage_StepDefinitions {

    @Given("user logged in as {string} and launched to the stream page")
    public void userLoggedInAsAndLaunchedToTheMainPage(String userType) {
        CRM_Utils.login(userType);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleContains("Portal"));
    }

    @When("user on stream page click {string} button")
    public void userOnStreamPageClickButton(String button) {
        var streamPage = new Stream_Page();
        streamPage.getButton(button).click();

    }

    @Then("user see {string} button is visible")
    public void userSeeButtonIsVisible(String button) {
        var streamPage = new Stream_Page();
        var uploadButton = streamPage.getButton(button);
        //upload input isDisplayed() and isVisible() failing for some reason, so checking visibility of it's zone
        if (button.equals("upload_or_drag_file"))
            uploadButton = streamPage.getUpLoadZone();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(uploadButton));
        Assert.assertTrue(uploadButton.isDisplayed());
    }

    @When("user upload {string}")
    public void userUpload(String fileExtension) {
        fileExtension = fileExtension.trim();
        String path;
        if (fileExtension.equals(".pdf"))
            path = ConfigurationReader.getProperty("pdfFilePath");
        else if (fileExtension.equals(".txt"))
            path = ConfigurationReader.getProperty("txtFilePath");
        else if (fileExtension.equals(".jpeg"))
            path = ConfigurationReader.getProperty("jpegFilePath");
        else if (fileExtension.equals(".png"))
            path = ConfigurationReader.getProperty("pngFilePath");
        else if (fileExtension.equals(".docx"))
            path = ConfigurationReader.getProperty("docxFilePath");
        else
            throw new IllegalArgumentException();

        var streamPage = new Stream_Page();
        streamPage.getButton("upload_or_drag_file").sendKeys(path);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.numberOfElementsToBe(streamPage.getUpLoadedFilesLocator(), 2));
    }

    @Then("user see {string} in list of attached files")
    public void userSeeInListOfAttachedFiles(String fileExtension) {
        var streamPage = new Stream_Page();

        //to check if fileExtension loaded to the page
        boolean isLoaded = false;
        for (WebElement uploadedFile : streamPage.getUploadedFiles()) {
            if (uploadedFile.getText().contains(fileExtension))
                isLoaded = true;
        }

        Assert.assertTrue(isLoaded);
    }

    @Then("user see feed-post with attached {string}")
    public void userSeeFeedPostWithAttached(String fileExtension) {
        var streamPage = new Stream_Page();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(streamPage.getFirstPostLocator()));

        List<WebElement> listOfUploadedFiles;
        if (!CRM_Utils.fileIsPicture(fileExtension)) {
            listOfUploadedFiles = streamPage.getNewestPostFiles();
        }
        else if (CRM_Utils.fileIsPicture(fileExtension))
            listOfUploadedFiles = streamPage.getNewestPostPhotos();
        else
            throw new IllegalArgumentException();

        boolean isAttached = false;
        for (WebElement uploadedFile : listOfUploadedFiles) {
            //in case of attached files
            if (uploadedFile.getText().contains(fileExtension))
                isAttached = true;

            //in case of attached pictures
            if (uploadedFile.getAttribute("data-bx-title").contains(fileExtension))
                isAttached = true;
        }

        Assert.assertTrue(isAttached);
    }

    @When("user on stream page click on uploaded file")
    public void userOnStreamPageClickOnUploadedFile() {
        var streamPage = new Stream_Page();
        for (WebElement uploadedFile : streamPage.getUploadedFiles()) {
            uploadedFile.click();
        }
    }

    @Then("user see uploaded file status changed to In text")
    public void userSeeFileIsInTextInputField() {
        var streamPage = new Stream_Page();
        boolean isInText = true;
        for (WebElement uploadedFilesStatus : streamPage.getUploadedFilesStatus()) {
            if (uploadedFilesStatus.getText().equals("Insert in text"))
                isInText = false;
        }

        Assert.assertTrue(isInText);
    }

    @And("user see uploaded {string} in text area")
    public void userSeeUploadedFileInTextArea(String fileExtension) {
        var streamPage = new Stream_Page();
        Driver.getDriver().switchTo().frame(streamPage.getNewMessageFrame());

        String uploadedFileInText;
        if (!CRM_Utils.fileIsPicture(fileExtension)) {
            uploadedFileInText = Driver.getDriver().findElement(
                    By.tagName("span")).getText();
        }
        else if (CRM_Utils.fileIsPicture(fileExtension))
            uploadedFileInText = Driver.getDriver().findElement(
                    By.tagName("img")).getAttribute("src");
        else
            throw new IllegalArgumentException();

        Assert.assertTrue(uploadedFileInText.contains(fileExtension));

        Driver.getDriver().switchTo().defaultContent();
    }

    @And("user see feed-post with attached {string} in text of message")
    public void userSeeFeedPostWithAttachedInTestOfMessage(String fileExtension) {
        var streamPage = new Stream_Page();
        String uploadedFileInTextName;
        if (!CRM_Utils.fileIsPicture(fileExtension)) {
            uploadedFileInTextName = streamPage.
                                    getUploadedFilesInNewestPostText().
                                    get(0).
                                    getText();
        }
        else if (CRM_Utils.fileIsPicture(fileExtension))
            uploadedFileInTextName = streamPage.
                                    getUploadedImagesInNewestPostText().
                                    get(0).
                                    getAttribute("data-bx-title");
        else
            throw new IllegalArgumentException();

        Assert.assertTrue(uploadedFileInTextName.contains(fileExtension));
    }

    @Then("user see no files attached to the message")
    public void userSeeNoFilesAttachedToTheMessage() {
        var streamPage = new Stream_Page();
        Assert.assertTrue(streamPage.getUploadedFiles().isEmpty());
    }

    @When("user upload multiple files simultaneously")
    public void userUploadMultipleFilesSimultaneously() {
        var streamPage = new Stream_Page();
        streamPage.uploadFile("TestTXT.txt");
        streamPage.uploadFile("TestPDF.pdf");
        streamPage.uploadFile("TestDOCX.docx");
        streamPage.uploadFile("TestJPEG.jpeg");
        streamPage.uploadFile("TestPNG.png");

    }

    @Then("user see simultaneously uploaded files in list of attached files")
    public void userSeeSimultaneouslyUploadedFilesInListOfAttachedFiles() {
        var streamPage = new Stream_Page();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        int filesToBeLoaded = streamPage.getListOfUploadedExtensions().size();
        wait.until(ExpectedConditions.numberOfElementsToBe(streamPage.getUploadedFilesStatusLocator(), filesToBeLoaded));

        int uploadedFiles = streamPage.getUploadedFilesStatus().size();
        Assert.assertEquals(filesToBeLoaded, uploadedFiles);
    }

    @And("user see simultaneously uploaded files in text area")
    public void userSeeSimultaneouslyUploadedFilesInTextArea() {
        var streamPage = new Stream_Page();
        Driver.getDriver().switchTo().frame(streamPage.getNewMessageFrame());

        //to wait pictures to be loaded
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));

        BrowserUtils.sleep(2);

        var listOfExtensions = streamPage.getListOfUploadedExtensions();
        var listOfFiles = Driver.getDriver().findElements(By.xpath("//span[contains(@id, 'bx')]"));
        var listOfImages = Driver.getDriver().findElements(By.tagName("img"));

        boolean allFilesInText = streamPage.allFilesAreInMessageText(listOfExtensions, listOfFiles, listOfImages);

        //checking if lists are empty to ensure we don't have anything in text which we didn't upload
        Assert.assertTrue(allFilesInText);

        Driver.getDriver().switchTo().defaultContent();
    }

    @Then("user see feed-post with simultaneously uploaded files {string}")
    public void userSeeFeedPostWithSimultaneouslyUploadedFilesAttached(String inAttachmentsOfText) {
        var streamPage = new Stream_Page();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(streamPage.getFirstPostLocator()));

        List<String> listOfExtension = streamPage.getListOfUploadedExtensions();
        List<WebElement> listOfUploadedFiles;
        List<WebElement> listOfUploadedImages;

        if (inAttachmentsOfText.equals("in attachments")) {
            listOfUploadedFiles = streamPage.getNewestPostFiles();
            listOfUploadedImages = streamPage.getNewestPostPhotos();
        }
        else if (inAttachmentsOfText.equals("in text")) {
            listOfUploadedFiles = streamPage.getUploadedFilesInNewestPostText();
            listOfUploadedImages = streamPage.getUploadedImagesInNewestPostText();
        }
        else
            throw new IllegalArgumentException();

        BrowserUtils.sleep(2);

        boolean areAttached = streamPage.allFilesAreInMessageText(listOfExtension, listOfUploadedFiles, listOfUploadedImages);

        Assert.assertTrue(areAttached);
    }
}
