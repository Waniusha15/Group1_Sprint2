package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream_Page {

    public Stream_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "feed-add-post-form-tab-message")
    private WebElement messageWindowButton;

    @FindBy(id = "bx-b-uploadfile-blogPostForm")
    private WebElement uploadFileButton;

    @FindBy(xpath = "//div[contains(@id, 'diskuf-selectdialog')]//td[1]//input")
    private WebElement uploadOrDragFileInput;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//table[@class='files-list']//span[@class='f-wrap']")
    private List<WebElement> uploadedFiles;

    @FindBy(xpath = "(//div[@class='feed-item-wrap'])[1]//a[contains(@id, 'disk-attach')]")
    private List<WebElement> newestPostFiles;

    @FindBy(xpath = "(//div[@class='feed-item-wrap'])[1]//img[contains(@id, 'disk-attach')]")
    private List<WebElement> newestPostPhotos;

    @FindBy(xpath = "//div[@class='diskuf-uploader']")
    private WebElement upLoadZone;

    @FindBy(xpath = "//span[.='Insert in text']")
    private List<WebElement> listOfUploadedFiles;
    //locator for expected conditions
    private By upLoadedFilesLocator = By.xpath("//span[.='Insert in text']");

    @FindBy(xpath = "(//div[@class='feed-item-wrap'])[1]//span[contains(@id, 'lock-anchor-created')]")
    private List<WebElement> uploadedFilesIcons;

    @FindBy(xpath = "(//div[@class='feed-item-wrap'])[1]")
    private WebElement firstPost;
    private By firstPostLocator = By.xpath("(//div[@class='feed-item-wrap'])[1]");

    @FindBy(xpath = "//span[contains(@id, 'check-in-text')]/span")
    private List<WebElement> uploadedFilesStatus;
    private By uploadedFilesStatusLocator = By.xpath("//span[contains(@id, 'check-in-text')]/span");

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    private WebElement newMessageFrame;

    @FindBy(xpath = "//span[@class='del-but']")
    private WebElement deleteUploadedFileButton;

    @FindBy(xpath = "//span[@class='feed-add-post-loading']")
    private List<WebElement> fileUploadLoadingBars;
    private By fileUploadLoadingBarsLocator = By.xpath("//span[@class='feed-add-post-loading']");

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]/a")
    private List<WebElement> uploadedFilesInNewestPostText;

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]/div//img")
    private List<WebElement> uploadedImagesInNewestPostText;

    public WebElement getButton(String button) {
        if (button.equals("message"))
            return messageWindowButton;
        else if (button.equals("upload_file"))
            return uploadFileButton;
        else if (button.equals("send"))
            return sendMessageButton;
        else if (button.equals("upload_or_drag_file"))
            return uploadOrDragFileInput;
        else if (button.equals("delete_uploaded_file"))
            return deleteUploadedFileButton;
        else
            throw new IllegalArgumentException();
    }


    public List<WebElement> getUploadedFiles() {
        return uploadedFiles;
    }

    public List<WebElement> getNewestPostFiles() {
        return newestPostFiles;
    }

    public List<WebElement> getNewestPostPhotos() {
        return newestPostPhotos;
    }

    public WebElement getUpLoadZone() {
        return upLoadZone;
    }

    public List<WebElement> getListOfUploadedFiles() {
        return listOfUploadedFiles;
    }

    public By getUpLoadedFilesLocator() {
        return upLoadedFilesLocator;
    }

    public List<WebElement> getUploadedFilesIcons() {
        return uploadedFilesIcons;
    }

    public WebElement getFirstPost() {
        return firstPost;
    }

    public By getFirstPostLocator() {
        return firstPostLocator;
    }

    public List<WebElement> getUploadedFilesStatus() {
        return uploadedFilesStatus;
    }

    public WebElement getNewMessageFrame() {
        return newMessageFrame;
    }

    public WebElement getDeleteUploadedFileButton() {
        return deleteUploadedFileButton;
    }

    public List<WebElement> getFileUploadLoadingBars() {
        return fileUploadLoadingBars;
    }

    public By getFileUploadLoadingBarsLocator() {
        return fileUploadLoadingBarsLocator;
    }

    public List<String> getListOfUploadedExtensions() {
        var arrayOfExtension = ConfigurationReader.getProperty("uploadedFilesExtensions").split(",");
        return Arrays.asList(arrayOfExtension);
    }

    //returns true if all extensions are in lists, and nothing else are in the lists
    public boolean allFilesAreInMessageText(List<String> listOfExtensions,
                                            List<WebElement> listOfUploadedFiles,
                                            List<WebElement> listOfUploadedImages) {

        //counting matching extensions
        int extensions = 0;
        int files = 0;
        int images = 0;

        for (String extension : listOfExtensions) {
            //to check if files contains extension
            for (WebElement file : listOfUploadedFiles) {
                if (file.getText().contains(extension)) {
                    extensions++;
                    files++;
                }
            }

            //to check if images contains extension: if yes - remove from list, if no - test will fail
            for (WebElement image : listOfUploadedImages) {
                //second attribute for posted message
                if (image.getAttribute("src").contains(extension) ||
                    (image.getAttribute("data-bx-title") != null &&
                        image.getAttribute("data-bx-title").contains(extension))) {
                    extensions++;
                    images++;
                }
            }
        }

        return listOfExtensions.size() == extensions &&
                listOfUploadedFiles.size() == files &&
                listOfUploadedImages.size() == images;
    }

    public List<WebElement> getUploadedFilesInNewestPostText() {
        return uploadedFilesInNewestPostText;
    }

    public List<WebElement> getUploadedImagesInNewestPostText() {
        return uploadedImagesInNewestPostText;
    }

    public By getUploadedFilesStatusLocator() {
        return uploadedFilesStatusLocator;
    }

    public void uploadFile(String fileName) {
        var path = System.getProperty("user.dir") + "\\" + ConfigurationReader.getProperty(fileName);
        uploadOrDragFileInput.sendKeys(path);
    }
}
