/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author vital
 */
public class AdvanceSearch {

    WebDriver driver;

    public AdvanceSearch(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(linkText = "Advanced Search")
    private WebElement AdvancedSearch;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='ZIP Code'])[1]/following::select[1]")
    private WebElement zipcode;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='ZIP Code'])[1]/following::select[1]")
    private WebElement zipcode1;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='ZIP Code'])[1]/following::div[1]")
    private WebElement zipcode2;

    @FindBy(name = "zipField")
    private WebElement zipField;

    @FindBy(name = "make")
    private WebElement make;

    @FindBy(name = "make")
    private WebElement make1;

    @FindBy(name = "make")
    private WebElement make2;

    @FindBy(name = "model")
    private WebElement model;

    @FindBy(name = "model")
    private WebElement model1;

    @FindBy(name = "model")
    private WebElement model2;
    
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Price Range'])[1]/following::select[1]")
    private WebElement priceRange;
    
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Price Range'])[1]/following::select[2]")
    private WebElement priceRange1;
    
    @FindBy(xpath = "//input[@value='Search']")
    private WebElement submit;

    public void searchApplic(String distance, String carName, String carModel,String minPrice,String maxPrice)
            throws Exception {
        try {
            driver.manage().window().maximize();
            driver.get("https://www.cars.com/");

            AdvancedSearch.click();
            zipcode.click();
            zipcode1.sendKeys(distance);
            zipcode2.click();
            zipField.click();
            make.click();
            make1.sendKeys(carName);
            make2.click();
            model.click();
            model1.sendKeys(carModel);
            model2.click();
            priceRange.click();
            priceRange.sendKeys(minPrice);
            Thread.sleep(1000);
            priceRange.click();
            priceRange1.click();
            priceRange1.sendKeys(maxPrice);
            priceRange1.click();
            submit.click();
            Thread.sleep(4000);
            driver.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
