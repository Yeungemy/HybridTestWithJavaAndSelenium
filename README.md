# Project name: HybridTestWithJavaAndSelenium

HybridTestWithJavaAndSelenium
|-- .dockerignore
|-- .gitignore
|-- .github
|-- Dockerfile
|-- jenkinsfiles
|-- k8s
|-- pom.xml
|-- README.md
|-- runTest.sh
|-- src
| |-- main
| |-- test
|-- target
| |-- allure-results
| |-- allure-reports

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
    10. Cucumber

# Steps to run the project:
    1. clone the repository: git@github.com:Yeungemy/HybridTestWithJavaAndSelenium.git
    2. Install dependencies: 
        - mvn clean install -D skipTests
        - update to latest version: mvn versions:use-latest-versions
        - commit to the changes to pom file: mvn versions:commit
        - revert changes: mvn versions:revert

    3. run web UI test and then open allure report accordingly:
        c. run web test: mvn clean test -D suiteXmlFile=src/test/resources/testSuite/webTest.xml
        b. run api test: mvn clean test -D suiteXmlFile=src/test/resources/testSuite/apiTest.xml
        c. run all tests: ./scripts/runTest.sh
        d. open the allure report: allure serve target/allure-results
