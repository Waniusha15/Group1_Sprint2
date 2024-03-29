package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//div[@style='display: block; opacity: 1;']//input[@multiple='multiple']")
    private WebElement uploadOrDragFileInput;
    By uploadOrDragFileInputLocator = By.xpath("//div[@style='display: block; opacity: 1;']//input[@multiple='multiple']");

    private WebElement locateUploadOrDragFileInput() {
        return Driver.getDriver().findElement(uploadOrDragFileInputLocator);
    }

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

    @FindBy(xpath = "//span[contains(@id, 'check-in-text')]")
    private List<WebElement> uploadedFilesStatus;
    private By uploadedFilesStatusLocator = By.xpath("//span[contains(@id, 'check-in-text')]/span");

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    private WebElement newMessageFrame;

    @FindBy(xpath = "//span[@class='del-but']")
    private WebElement deleteUploadedFileButton;

    @FindBy(xpath = "//span[@class='feed-add-post-loading']")
    private List<WebElement> fileUploadLoadingBars;
    private By fileUploadLoadingBarsLocator = By.xpath("//span[@class='feed-add-post-loading']");

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]//a")
    private List<WebElement> uploadedFilesInNewestPostText;

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]//div//img")
    private List<WebElement> uploadedImagesInNewestPostText;

    @FindBy(id = "feed-add-post-form-link-text")
    private WebElement moreButton;

    @FindBy(xpath = "//div[@id='popup-window-content-menu-popup-feed-add-post-form-popup']//span[contains(text(), 'Appreciation')]")
    private WebElement appreciationButton;

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
        else if (button.equals("more"))
            return moreButton;
        else if (button.equals("appreciation"))
            return appreciationButton;
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
        int extensionsMatching = 0;
        int filesMatching = 0;
        int imagesMatching = 0;

        for (String extension : listOfExtensions) {
            //to check if files contains extension
            for (WebElement file : listOfUploadedFiles) {
                if (file.getText().contains(extension)) {
                    extensionsMatching++;
                    filesMatching++;
                }
            }

            //to check if images contains extension: if yes - increment counters. Test will fail if counters are not matching with quantity of files
            for (WebElement image : listOfUploadedImages) {
                //second attribute for posted message
                if (image.getAttribute("src").contains(extension) ||
                    (image.getAttribute("data-bx-title") != null &&
                        image.getAttribute("data-bx-title").contains(extension))) {
                    extensionsMatching++;
                    imagesMatching++;
                }
            }
        }

        return listOfExtensions.size() == extensionsMatching &&
                listOfUploadedFiles.size() == filesMatching &&
                listOfUploadedImages.size() == imagesMatching;
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
        BrowserUtils.sleep(1);

        var path = System.getProperty("user.dir") + "\\" + ConfigurationReader.getProperty(fileName);
        locateUploadOrDragFileInput().sendKeys(path);
    }

    public String getUploadFilePath(String fileExtension) {
        if (fileExtension.contains(".pdf"))
            return ConfigurationReader.getProperty("TestPDF.pdf");
        else if (fileExtension.contains(".txt"))
            return ConfigurationReader.getProperty("TestTXT.txt");
        else if (fileExtension.contains(".jpeg"))
            return ConfigurationReader.getProperty("TestJPEG.jpeg");
        else if (fileExtension.contains(".png"))
            return ConfigurationReader.getProperty("TestPNG.png");
        else if (fileExtension.contains(".docx"))
            return ConfigurationReader.getProperty("TestDOCX.docx");
        else
            throw new IllegalArgumentException();
    }

    public boolean fileIsPicture(String fileExtension) {
        if (fileExtension.equals(".docx") ||
                fileExtension.equals(".pdf") ||
                fileExtension.equals(".txt")) {
            return false;
        }
        else if (fileExtension.equals(".jpeg") || fileExtension.equals(".png"))
            return true;
        else
            throw new IllegalArgumentException();
    }

    public List<WebElement> getLisOfUploadedFiles(String fileExtension) {
        if (!fileIsPicture(fileExtension)) {
            return getNewestPostFiles();
        }
        else if (fileIsPicture(fileExtension))
            return getNewestPostPhotos();
        else
            throw new IllegalArgumentException();
    }

    public String getFileNameFromExtension(String fileExtension) {
        return "Test" + fileExtension.substring(1).toUpperCase() + fileExtension;
    }

    public void uploadMultipleFiles(String... fileNames) {
        String path = "";
        for (String fileName : fileNames) {
            path += System.getProperty("user.dir") + "\\" + ConfigurationReader.getProperty(fileName) + "\n";
        }

        //we need to cut last \n (newline char) - which is considered as one character
        path = path.substring(0, path.length()-1);


        uploadOrDragFileInput.sendKeys(path);
    }

    public void uploadFileMultipleTimes(String fileName, int quantity) {
        String path = "";
        for (int i = 0; i < quantity; i++) {
            path += System.getProperty("user.dir") + "\\" + ConfigurationReader.getProperty(fileName) + "\n";
        }

        path = path.substring(0, path.length()-1);
        uploadOrDragFileInput.sendKeys(path);
    }

    public WebElement getMoreButton() {
        return moreButton;
    }

    public WebElement getAppreciationButton() {
        return appreciationButton;
    }

