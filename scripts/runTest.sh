#!/bin/bash

# Clean and build the project, and run the tests
mvn clean test -D surefire.suiteXmlFiles=src/test/java/com/hybridTest/suite/webTest.xml

# Check if the tests passed before trying to serve the Allure report
if [ $? -eq 0 ]; then
  # Start the Allure server
  allure serve target/allure-results
else
  echo "Tests failed. Allure report will not be generated."
fi