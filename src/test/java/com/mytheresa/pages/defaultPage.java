package com.mytheresa.pages;

import com.mytheresa.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class defaultPage extends BasePage {

    public defaultPage(){ PageFactory.initElements(Driver.get(),this); }



}
