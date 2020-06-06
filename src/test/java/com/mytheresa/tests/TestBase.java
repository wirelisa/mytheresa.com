package com.mytheresa.tests;
import com.mytheresa.utilities.ConfigurationReader;
import com.mytheresa.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;
    protected String url;

    @BeforeMethod
    public void setUpMethod(){
        url=ConfigurationReader.get("url");
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(url);
        driver.manage().window().maximize();

        //switch to iframe
        driver.switchTo().frame("privacy-iframe");
        //accept all cookies and continue
        WebElement acceptAllandContinue=driver.findElement(By.xpath("//button[contains(.,'Accept all and continue')]"));
        acceptAllandContinue.click();

        //switch to defultContent
        driver.switchTo().defaultContent();
    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
       //Close the driver
       Thread.sleep(1000);   //just to be able to see the last page, It should be removed!
       Driver.closeDriver();
    }
}