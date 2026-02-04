# Antigravity Automation Framework

## Overview
This is a robust, scalable, and maintainable end-to-end automation testing framework for the Antigravity website. It is built using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**, following the **Page Object Model (POM)** design pattern.

## Tech Stack
- **Language**: Java 17
- **Automation Tool**: Selenium WebDriver
- **Test Runner**: TestNG
- **Build Tool**: Maven
- **Reporting**: ExtentReports 5
- **Driver Management**: WebDriverManager

## Project Structure
```
src
  ├── main
  │    ├── java
  │    │    └── com.antigravity
  │    │         ├── base        # BaseTest, DriverManager
  │    │         ├── pages       # Page Object Classes
  │    │         ├── utils       # ElementUtil, ConfigReader, ScreenshotUtil
  │    │         └── reports     # ExtentManager, TestListener
  │    └── resources
  │         └── config.properties # Global Configuration (URL, Browser)
  └── test
       ├── java
       │    └── com.antigravity.tests # Test Classes
       └── resources
            └── testng.xml       # Test Suite Configuration
```

## How to Run Tests

### 1. From Command Line (Maven)
Run the following command in the project root:
```bash
mvn clean test
```
This will execute the tests defined in `testng.xml` and generate reports.

### 2. From IDE (IntelliJ/Eclipse)
- Right-click on `src/test/resources/testng.xml` and select **Run**.
- Or, right-click on individual test classes (e.g., `LoginTest`) and select **Run**.

## Test Reports
After execution, the HTML report is generated at:
`reports/TestReport_yyyymmdd_hhmmss.html`

## Configuration
Update `src/main/resources/config.properties` to change:
- `url`: The target application URL.
- `browser`: chrome, edge, or firefox.
- `headless`: true/false.

## Adding New Tests
1. **Create Page Class**: in `com.antigravity.pages` extending `BasePage` (if added) or using `ElementUtil`.
2. **Create Test Class**: in `com.antigravity.tests` extending `BaseTest`.
3. **Add to `testng.xml`**: Include the new test class in the suite.
