# DEPI Automation Exercise — Products POM

Selenium + TestNG automation for [automationexercise.com](https://automationexercise.com/products) using the Page Object Model pattern.

Branch: `salma/products-automation`

## Project structure

```
Depi_AutomationExercise/
├── pom.xml                              Maven dependencies (Selenium, TestNG, WebDriverManager)
├── testng.xml                           TestNG suite (5 feature groups)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/                   Page Object classes
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── ProductsPage.java
│   │   │   │   ├── ProductDetailsPage.java
│   │   │   │   └── LoginPage.java
│   │   │   └── utils/
│   │   │       ├── ConfigReader.java    Reads config.properties
│   │   │       └── DriverFactory.java   Creates Chrome driver
│   │   └── resources/
│   │       └── config.properties        URLs + test credentials (placeholders)
│   └── test/
│       └── java/
│           ├── Base/
│           │   └── BaseTest.java                  @BeforeMethod / @AfterMethod
│           └── Tests/
│               ├── ProductBrowsingTests.java      5 cases
│               ├── ProductDetailsTests.java       5 cases
│               ├── ProductSearchTests.java        5 cases
│               ├── ProductFilterTests.java        5 cases
│               └── HeaderNavigationTests.java     5 cases (Guest + Logged-in)
```

Total: **25 test cases** across **5 features**.

## Features covered

| # | Feature           | Cases | User type        |
|---|-------------------|-------|------------------|
| 1 | Product Browsing  | 5     | Guest            |
| 2 | Product Details   | 5     | Guest            |
| 3 | Product Search    | 5     | Guest            |
| 4 | Product Filter    | 5     | Guest            |
| 5 | Header Navigation | 5     | Guest + Logged-in|

## Prerequisites

- Java 17+
- Maven 3.8+
- Google Chrome installed (driver auto-downloaded by WebDriverManager)

## How to run

### Run the full suite
```bash
mvn clean test
```

### Run a single test class
```bash
mvn -Dtest=ProductBrowsingTests test
```

### Update test credentials
Before running `HeaderNavigationTests` cases 04 and 05 you must put your real login in:
```
src/main/resources/config.properties
```
The default values are placeholders.

## Author

Salma Khalil — DEPI QA Engineering grad project.
