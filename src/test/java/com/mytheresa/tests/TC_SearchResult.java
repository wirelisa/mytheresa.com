package com.mytheresa.tests;

import com.mytheresa.pages.defaultPage;
import com.mytheresa.pages.searchResultsPage;
import com.mytheresa.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SearchResult extends TestBase{

    @Test (description = "Search 'Gucci bags' for women")
    public void test() {
        defaultPage defaultPage=new defaultPage();
        defaultPage.selectGender("women");
        //since I execute these test cases on my local computer, I used couple of waits to avoid from
        // synchronization issues because of internet and my computer`s speed!
        BrowserUtils.waitForPageToLoad(3);

        defaultPage.closeAlert.click();

        defaultPage.searchFor("Gucci bags");

        BrowserUtils.waitForPageToLoad(3);

        defaultPage.closeNewsletterAlert();

        searchResultsPage searchResultsPage=new searchResultsPage();
        String numberOfProducts=searchResultsPage.numberOfProducts.getText();
        System.out.println(numberOfProducts);

        Assert.assertEquals(numberOfProducts,"234 products");

    }

    @Test (description = "Search 'Gucci bags' for men")
    public void test1() {
        defaultPage defaultPage=new defaultPage();
        defaultPage.selectGender("men");

        BrowserUtils.waitForPageToLoad(3);

        defaultPage.closeAlert.click();

        defaultPage.searchFor("Gucci bags");

        BrowserUtils.waitForPageToLoad(3);

        defaultPage.closeNewsletterAlert();

        searchResultsPage searchResultsPage=new searchResultsPage();
        String numberOfProducts=searchResultsPage.numberOfProducts.getText();
        System.out.println(numberOfProducts);

        Assert.assertEquals(numberOfProducts,"11 products");

    }

    @Test  (description = "Search 'Gucci bags' for kids")
    public void test2() {
        defaultPage defaultPage=new defaultPage();
        defaultPage.selectGender("kids");

        BrowserUtils.waitForPageToLoad(3);

        defaultPage.closeAlert.click();

        defaultPage.searchFor("Gucci bags");

        BrowserUtils.waitForPageToLoad(3);

        defaultPage.closeNewsletterAlert();

        searchResultsPage searchResultsPage=new searchResultsPage();
        String numberOfProducts=searchResultsPage.numberOfProducts.getText();
        System.out.println(numberOfProducts);

        Assert.assertEquals(numberOfProducts,"3 products");

    }
}
