package org.foden.pages;

import io.qameta.allure.Step;
import org.foden.constants.FrameworkConstants;
import org.foden.pages.components.BrowseFile;
import org.foden.pages.components.ProductCategory;
import org.foden.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public final class ProductsPage extends BasePage{

    //Start section 'General'
    private final By txtProductName = By.xpath("//input[@placeholder='Product Name']");
    private final By selectBrand = By.xpath("//select[@id='brand_id']");
    private final By txtUnit = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
    private final By txtWeight = By.xpath("//input[@name='weight']");
    private final By txtMinPurchaseQty = By.xpath("//input[@name='min_qty']");
    private final By txtTags = By.xpath("//span[@data-placeholder='Type and hit enter to add a tag']");
    private final By txtBarcode = By.xpath("//input[@placeholder='Barcode']");
    private final By toggleRefundable = By.xpath("//input[@name='refundable']");
    private final By txtDescription = By.xpath("//div[@role='textbox']");
    //End section 'General'

    //Start section Files & Media
    private final By sectionFilesMedia = By.xpath("//a[@id='files-and-media-tab']");
    //End section Files & Media

    //Start section 'Price&Stock'
    private final By sectionPriceStock = By.xpath("//a[@id='price-and-stocks-tab']");
    private final By txtUnitPrice = By.xpath("//input[@name='unit_price']");
    private final By txtDiscount = By.xpath("//input[@name='discount']");
    //End section 'Price&Stock'
    private final By btnSavePublish = By.xpath("//button[normalize-space()='Save & Publish']");
    private final By successAlertAddProduct = By.xpath("//*[text()='Product has been inserted successfully']");
    public ProductsPage(){}

    @SafeVarargs
    @Step("Add new product")
    public final void addNewProduct(String productName, String brandName, String unit, String weight, String minPurchaseQty, String tags, String barcode, String description, String unitPrice, String discount, HashMap<String, Boolean>... productCategories){
        //Fill General section
        setText(txtProductName, productName);
        selectOptionByText(selectBrand, brandName);
        setText(txtUnit, unit);
        setText(txtWeight, weight);
        setText(txtMinPurchaseQty, minPurchaseQty);
        setText(txtTags, tags);
        setText(txtBarcode, barcode);
        setText(txtDescription, description);

        //Select Product Category
        ProductCategory.selectProductCategory(productCategories);

        //Fill Files&Media section
        clickElement(sectionFilesMedia);
        BrowseFile.getInstance().selectFirstAvailableFile("Gallery Images");

        //Fill Price&Stock section
        clickElement(sectionPriceStock);
        clearAndFillText(txtUnitPrice, unitPrice);
        clearAndFillText(txtDiscount, discount);
        scrollToElementAtBottom(btnSavePublish);
        clickElementWithJs(btnSavePublish);
    }

    @Step("Verify add new product successfully")
    public void verifyAddNewProductSuccessfully(){
        //Verify add new product successfully
        verifyElementVisible(successAlertAddProduct, FrameworkConstants.getExplicitwait(),"No success alert displayed - Assuming add new product failed!");
    }
}
