#!/bin/bash

run_web_tests() {
    echo "Running Web Tests..."
    mvn clean test -D suiteXmlFile=src/test/resources/testSuite/webTest.xml -D headless=true
}

run_web_cucumber_tests() {
    echo "Running API Tests..."
    mvn clean test -D suiteXmlFile=src/test/resources/testSuite/webCucumberTest.xml
}

run_api_tests() {
    echo "Running API Tests..."
    mvn clean test -D suiteXmlFile=src/test/resources/testSuite/apiTest.xml
}

generate_allure_report() {
    echo "Generating Allure Report..."
    allure generate --clean -o ../target/allure-report
}

# Run both API and web tests
run_api_tests
run_web_tests
run_web_cucumber_tests

# Generate Allure report
generate_allure_report

