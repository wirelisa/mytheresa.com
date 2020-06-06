## mytheresa
I have created this project with maven so I keep all dependencies in pom.xml file

I created configuration.properties file, which contains browser type and urls in key-value format.

# utilities
-I created Driver utility, which is designed as singleton and it supports "chrome","chrome-headless","firefox","firefox-headless","internet explorer" for windows and "edge", "safari" for mac.

-I created ConfigurationReader utility to be able to get the values from configuration.properties file.

-I created BrowserUtility which contains static methods

# pages
I created abstract BasePage, which contains all common webelements and methods and other pages extends it.

I used PageFactory.initElements method to be able to initialize webelements by using @FindBy annotation without using findElement() method.

I created searchResultsPage for that specific page which extends base page.


# tests
I created objects from the pages to be able to use its webelements and methods. 

Since I execute these tests on my local computer, I used waits more than expected to avoid from synchronization issues because of internet and my computer`s speed.

I created TestBase class which contains before and after methods and all test classes extends this TestBase to be able to execute these methods before each test.




