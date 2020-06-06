package com.mytheresa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    @FindBy(xpath = "//a[@title='Women']")
    public WebElement womenButton;

    @FindBy(xpath = "//a[@title='Men']")
    public WebElement menButton;

    @FindBy(xpath = "//a[@title='Kids']")
    public WebElement kidsButton;

    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@id='acc-alert-close']")
    public WebElement closeAlert;

    @FindBy(xpath = "//a[@class='close icon icon-x' and @href='#']")
    public WebElement closeNewsletterAlert;



    public void selectGender(String gender){
        if(gender.equalsIgnoreCase("women")){
            womenButton.click();
        }else if(gender.equalsIgnoreCase("men")){
            menButton.click();
        }else if (gender.equalsIgnoreCase("kids")){
            kidsButton.click();
        }
    }

    public void searchFor(String item){
        searchBox.sendKeys(item, Keys.ENTER);
    }


    public void closeNewsletterAlert(){

        try {
            closeNewsletterAlert.click();
        }catch (NoSuchElementException e){

        }

    }




}


