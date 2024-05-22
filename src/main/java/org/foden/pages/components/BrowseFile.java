package org.foden.pages.components;

import org.foden.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

import static org.foden.pages.BasePage.clickElement;
import static org.foden.pages.BasePage.uploadFileWithSendKeys;

public class BrowseFile {
    private static BrowseFile browseFile;
    private final String commonBtnChooseFile = "(//label[normalize-space(text())='%s']//following::div[text()='Choose file'])[1]";
    private final By tabSelectFile = By.xpath("//a[text()='Select File']");
    private final By firstImage = By.xpath("//div[@class='card-file-thumb']");
    private final By tabUploadNew = By.xpath("//a[text()='Upload New']");
    private final By inputFilePath = By.xpath("//input[@type='file']");
    private final By btnAddFiles = By.xpath("//button[text()='Add Files']");
    private final By btnAddMore = By.xpath("//span[text()='Add more']");
    public BrowseFile(){}

    public static BrowseFile getInstance(){
        if (browseFile == null){
            browseFile = new BrowseFile();
        }
        return browseFile;
    }

    //Select the 1st available file
    public void selectFirstAvailableFile(String labelFile){
        By btnChooseFile = By.xpath(DynamicXpathUtils.getXpath(commonBtnChooseFile, labelFile));
        clickElement(btnChooseFile);
        clickElement(firstImage);
        clickElement(btnAddFiles);
    }

    //Upload new file
    public void uploadNewFile(String labelFile, String filePath){
        By btnChooseFile = By.xpath(DynamicXpathUtils.getXpath(commonBtnChooseFile, labelFile));
        clickElement(btnChooseFile);
        clickElement(tabUploadNew);
        uploadFileWithSendKeys(inputFilePath, filePath);
        clickElement(btnAddFiles);
    }
}
