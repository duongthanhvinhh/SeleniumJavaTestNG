package org.foden.pages;

import org.openqa.selenium.By;

public final class AuctionProductsPage extends BasePage{
    public AuctionProductsPage(){}

    private final By productName = By.xpath("//input[@placeholder='Product Name']");
    private final By branch = By.xpath("//select[@id='brand_id']");
    private final By unit = By.xpath("//input[@name='unit']");
    private final By weight = By.xpath("//input[@name='weight']");
    private final By tags = By.xpath("//span[@data-placeholder='Type and hit enter to add a tag']");
    private final By startingBiddingPrice = By.xpath("//input[@name='starting_bid']");
    private final By auctionDateRange = By.xpath(""); //TODO: Add DateTimePicker Util or Component

}
