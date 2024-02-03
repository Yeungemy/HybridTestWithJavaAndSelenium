#!/bin/bash

# Clean and build the project, and run the tests
mvn clean test -D surefire.suiteXmlFiles=src/test/java/com/hybridTest/testSuite/webTest.xml

# Check if the tests passed before trying to serve the Allure report
allure serve target/allure-results