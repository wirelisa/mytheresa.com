package com.mytheresa.pages;

import com.mytheresa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchResultsPage extends BasePage {
    public searchResultsPage() { PageFactory.initElements(Driver.get(),this); }

    @FindBy(xpath = "//p[contains(.,'products')]")
    public WebElement numberOfProducts;




}
