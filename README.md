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
    2. Install dependencies: 
        - mvn clean install -D skipTests
        - update to latest version: mvn versions:use-latest-versions
        - commit to the changes to pom file: mvn versions:commit
        - revert changes: mvn versions:revert
    3. run web UI test and then open allure report accordingly: ./scripts/webTestRunner.sh
