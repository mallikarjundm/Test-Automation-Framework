
# Test Automation Framework

This is a Java 11-based Selenium test automation framework designed for cross-browser and cloud-based testing.  
It leverages **TestNG** for test management, **data-driven testing** using CSV, JSON, and Excel files, and **LambdaTest** for executing tests in the cloud.  
The framework supports **headless mode** for faster execution and provides detailed HTML reports using **ExtentReports**, along with structured logging via **Log4j**.



## Author
- (@mallikarjundm) https://github.com/mallikarjundm
-  Email Address: dmmallikarjun999@gmail.com

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/mallikarjundm)



## About Me
Hello, My Mallikarjun DM and I have over 3.8 years of experience in Automation testing using technologies like Selenium Web driver, Rest assured.
My major expertise is in Java programming language. 


## Prerequisites
Before running the tests, ensure you have:
 - **Java 11** installed
 - **Maven** installed
 - An IDE (IntelliJ IDEA, Eclipse, VS Code) or CLI environment
 - **LambdaTest account** (if running tests on LambdaTest)
 -Download link for maven - https://maven.apache.org/download.cgi?.




 # Features
 - **Java 11** for modern language features and compatibility.
 - **Selenium WebDriver** for browser automation.
 - **TestNG** for parallel test execution and reporting.
 - **Data-Driven Testing**:
   - CSV via OpenCSV
   - JSON
   - Excel via Apache POI
   - **Faker Library** for generating fake test data.
- **LambdaTest Integration** for cross-browser and cross-platform execution in the cloud.
- **Headless Mode** for faster local execution.
- **Configurable CLI Parameters**:
    - `browser` → Chrome, Firefox, Edge, etc.
    - `isLambdaTest` → true/false
    - `isHeadless` → true/false
- **Logging** with Log4j (saved in `/logs`).
- **HTML Reporting** with ExtentReports (generated in `reports.html`).


# Tech Stack
-Language: Java 11
-Test Runner: TestNG
-Build Tool: Maven
-Cloud Execution: LambdaTest
-Data Sources: OpenCSV, JSON, Apache POI (Excel)
-Fake Data Generator: Java Faker
-Reporting: Extent Reports (HTML reports)
-Logging: Log4j2
-Execution Modes: Headless / Non-Headless



## SetUp Instructions
**Clone the repository:**
```bash
git clone https://github.com/mallikarjundm/Test-Automation-Framework.git
cd Test-Automation-Framework
```

**Running Tests on LambdaTest:**
```bash
    mvn test -Dbrowser=chrome -DiLambdaTest=true -DisHeadless=false -X
```

**Running Tests on Chrome Browser on Local machine in Headless Mode:**

```bash
    mvn test -Dbrowser=chrome -DiLambdaTest=false -DisHeadless=true -X 


 **## Reports:**
  -Reports: After execution, a detailed HTML report will be generated at ./report.html.
   The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.

 ## Logs:
  -Logs are created during the test execution and stored in the ./logs/ directory.

## Integrated the project with GitHub Actions:
  This Automation framework is integrated with GitHub Actions.
  The Tests will be executed at 11:30PM IST on every single day.

  The reports will be archived in gh-pages branch
  You can view the html reports at https://mallikarjundm.github.io/Test-Automation-Framework/report.html
