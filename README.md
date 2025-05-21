# Selenium Automation Framework

This is a Selenium Automation Framework developed using Java, TestNG, Maven, and Extent Reports .

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports
- Page Object Model (POM)

## Features
- Cross-browser testing
- Modular test scripts using Page Object Model
- HTML test reports with screenshots
- Data-driven testing with Excel integration

## Folder Structure

   1) src/test/java

        pageobject – Contains Page Object classes for UI elements.

        testbase – Base class with WebDriver setup and teardown logic.

        testcases – All TestNG test classes for different modules.

        utilities – Helper classes like Excel handling, listeners, screenshots, etc.

   2) src/test/resources

        config.properties – Stores configurable test settings like URL, browser, etc.

   3) reports

        Stores ExtentReports generated after test execution.

   4) testdata

        Excel files used for data-driven testing.

   5) pom.xml

        Maven build file with all required dependencies and plugins.

   6) grouping.xml & mastersuite.xml

        TestNG suite XML files to group and manage test execution.

## How to Run
1. Clone this repository:
   ```bash
   https://github.com/ashutoshpatil1410/Opencart_Automation_Project.git 
2. Import as Maven Project in IntelliJ or Eclipse
3. Update test data/config if needed
4. Run test using `pom.xml` by selecting as maven test / customize the pom under suiteXmlFile tag and run the test which you want

## Sample Report
A sample Extent Report will be generated with timestamp at `reports/Extentreport.html`

## 👤 Author
Ashutosh Patil
