package org.foden.pages.components;

import org.foden.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static org.foden.pages.BasePage.clickElement;

public class ProductCategory {

    @SafeVarargs
    public static void selectProductCategory(HashMap<String, Boolean>... productCategories){

        for (HashMap<String, Boolean> productCategoryMap : productCategories){
            for (Map.Entry<String, Boolean> entry : productCategoryMap.entrySet()){

                String commonProductCategoryCheckbox = "//input[@data-id='%s']";
                By productCategoryCheckbox = By.xpath(DynamicXpathUtils.getXpath(commonProductCategoryCheckbox, entry.getKey()));

                String commonProductCategoryPlusIcon = "//input[@data-id='%s']/parent::label/preceding-sibling::i[@class='las la-plus']";
                By productCategoryPlusIcon = By.xpath(DynamicXpathUtils.getXpath(commonProductCategoryPlusIcon, entry.getKey()));

                String commonProductCategoryRadioCheck = "//input[@data-id='%s']/parent::label//following-sibling::input[@name='category_id']";
                By productCategoryRadioCheck = By.xpath(DynamicXpathUtils.getXpath(commonProductCategoryRadioCheck, entry.getKey()));

                clickElement(productCategoryCheckbox);

                if (entry.getValue()){
                    clickElement(productCategoryPlusIcon);
                }
                clickElement(productCategoryRadioCheck);
            }
        }
    }

}
