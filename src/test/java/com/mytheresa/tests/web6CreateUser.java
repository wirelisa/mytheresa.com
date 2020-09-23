package com.mytheresa.tests;

import com.mytheresa.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class web6CreateUser extends TestBase {

    @DataProvider
    public Object[][] userData(){
        ExcelUtil data=new ExcelUtil("src/test/resources/web6.xlsx","Sheet1");
        String[][] dataArray=data.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void createUser(String name, String surname, String mail, String pass){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(name);
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(surname);
        WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(mail);
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(pass);
        WebElement confirmPassword=driver.findElement(By.xpath("//input[@name='confirmation']"));
        confirmPassword.sendKeys(pass);
        WebElement registerButton=driver.findElement(By.xpath("//button[@title='Register']"));
        registerButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginVerify=driver.findElement(By.xpath("//*[text()='Thank you for registering with mytheresa.com.']"));
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginVerify));
        Assert.assertTrue(loginVerify.isDisplayed());



    }



}
