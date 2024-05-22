package org.foden.enums;

public enum MainMenu {
    DASHBOARD("Dashboard"),
    POSSYSTEM("POS System"),
    PRODUCTS("Products"),
    AUCTIONPRODUCTS("Auction Products"),
    WHOLESALEPRODUCTS("Wholesale Products"),
    SALES("Sales"),
    DELIVERYBOY("Delivery Boy"),
    REFUNDS("Refunds"),
    CUSTOMERS("Customers"),
    SELLERS("Sellers"),
    UPLOADEDFILES("Uploaded Files"),
    REPORTS("Reports"),
    BLOGSYSTEM("Blog System"),
    MARKETING("Marketing"),
    SUPPORT("Support"),
    AFFILIATESYSTEM("Affiliate System"),
    OFFLINEPAYMENTSYSTEM("Offline Payment System"),
    ASIANPAYMENTGATEWAY("Asian Payment Gateway"),
    CLUBPOINTSYSTEM("Club Point System"),
    OTPSYSTEM("OTP System"),
    AFRICANPAYMENTGATEWAY("African Payment Gateway"),
    WEBSITESETUP("Website Setup"),
    SETUPCONFIGURATIONS("Setup & Configuration"),
    STAFFS("Staffs"),
    SYSTEM("System"),
    ADDONMANAGER("Addon Manager");


    private final String description;

    MainMenu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
