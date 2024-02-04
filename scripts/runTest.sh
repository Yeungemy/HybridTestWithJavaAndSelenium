#!/bin/bash

run_web_tests() {
    echo "Running Web Tests..."
    mvn clean test -D suiteXmlFile=src/test/resources/testSuite/webTest.xml
}

run_api_tests() {
    echo "Running API Tests..."
    mvn clean test -D suiteXmlFile=src/test/resources/testSuite/apiTest.xml
}

run_all_tests() {
    echo "Running All Tests..."
    mvn clean test
}

generate_allure_report() {
    echo "Generating Allure Report..."
    allure generate --clean -o target/allure-report
}

# Check command-line argument
if [ "$1" == "web" ]; then
    run_web_tests
elif [ "$1" == "api" ]; then
    run_api_tests
else
    run_all_tests
fi

# Generate Allure report
generate_allure_report


# Check if the tests passed before trying to serve the Allure report
allure serve target/allure-results