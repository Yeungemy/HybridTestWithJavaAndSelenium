# Project name: HybridTestWithJavaAndSelenium

# Languages and Framework
    1. Java-21
    2. Maven
    3. Selenium-java
    4. allure
    5. jquery
    6. testng
    7. webdriver manager
    8. slf4j-api
    9. logback-classic
    10. 

# Steps to run the project:
    1. clone the repository: git@github.com:Yeungemy/HybridTestWithJavaAndSelenium.git
    2. run web UI test: mvn clean test -D surefire.suiteXmlFiles=src/test/java/com/hybridTest/suite/webTest.xml
    3. run allure server: allure serve allure-results 
