# Installation
Directly clone project by using https://github.com/wirelisa/mytheresa.com.git

Make sure all dependencies are downloaded

Under src > test > java > com > mytheresa > tests package, there are 3 test classes
1-for github API
2-mytheresa.com search result
3-problem solving

You can directly run those test cases and if you want, you can change preferred browser type from configuration.properties file!

# project
I have created this project with maven so I keep all dependencies in pom.xml file
-

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




