# UI Test Automation Framework

This is a Java-based test automation framework built using Selenium WebDriver and TestNG for automating web application testing.

The framework is designed with a reusable and maintainable architecture and supports data-driven testing, parallel test execution, explicit waits, logging, automated screenshots, and HTML reporting using Extent Reports. It also supports cross-browser and cloud-based test execution through LambdaTest.

The framework uses Maven for dependency management and build execution and follows the Page Object Model (POM) design pattern to improve code reusability, readability, and maintainability. It also integrates with GitHub Actions for CI/CD-based automated test execution and publishes test reports for easy analysis of test results.


## About Me
Hi, I'm Koustav Basak, a Software QA Engineer with 2+ years of experience in software testing and test automation.

I specialize in Java, Selenium WebDriver, TestNG, API Testing, Postman, RestAssured, and Maven, with hands-on experience building maintainable automation frameworks using Page Object Model, data-driven testing, parallel execution, logging, and Extent Reports.

I'm passionate about improving software quality through automation, intelligent testing, and continuous learning.


## Author Informations

- [@Koustav Basak](https://github.com/EverythingAboutKoustavBasak)
- Email Address - koustav23042001@gmail.com



## 🔗 Link
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/koustav-basak-569887243/)



## Prerequisites

Before running this framework, ensure the following software is installed on your system:
- Java 11 - Make sure Java is installed and the JAVA_HOME environment variable is set.
- Maven - Ensure Maven is installed and added to the system path.

## Features

- **Data-Driven Testing:** Using OpenCSV, Apache POI, and Gson for reading test data from CSV and Excel files and JSON.
- **Cross-Browser Testing:** Supports running tests on different browsers.
- **Parallel Test Execution:** Supports parallel execution using TestNG to reduce overall test execution time.
- **Headless Mode:** Faster execution by running tests in headless mode.
- **Explicit Waits:** Uses Selenium WebDriverWait and expected conditions for reliable synchronization with web elements.
- **Cloud Testing:** Integrated with LambdaTest to run tests on the cloud.
- **Logging:** Uses Log4j for detailed logs.
- **Reporting:** Generates detailed reports using Extent Reports.
- **Screenshot Capture:** Automatically captures screenshots for failed test cases and attaches them to the Extent Report.
- **Maven Integration:** Uses Maven for dependency management and test execution.
- **Configuration Management:** Supports configurable browser, headless mode, and LambdaTest execution through Maven/TestNG parameters.
- **CI/CD Integration:** Integrated with GitHub Actions for automated test execution.
- **GitHub Pages Reporting:** Publishes the latest Extent HTML report through GitHub Pages for easy access to test execution results.

## Technologies Used

- **Java 11** — Primary programming language
- **Selenium WebDriver** — Web UI automation
- **TestNG** — Test execution, assertions, annotations, and parallel execution
- **Maven** — Build and dependency management
- **Apache POI** — Excel-based test data handling
- **OpenCSV** — CSV-based test data handling
- **JavaFaker** — Dynamic test data generation
- **Log4j2** — Application and test execution logging
- **Extent Reports** — HTML test reporting and failure screenshots
- **LambdaTest** — Cloud-based cross-browser test execution
- **Git & GitHub** — Source code management and version control
- **GitHub Actions** — CI/CD automation and scheduled test execution
- **GitHub Pages** — Publishing test execution reports










## Setup Instructions

**Clone the Repository:**

```bash
    git clone https://github.com/EverythingAboutKoustavBasak/UI-Test-Automation-Framework.git

    cd UI-Test-Automation-Framework
```

**Running Tests on LambdaTest:**

```bash
    mvn test -X -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false 
```
**Running Tests on Local Machine with Chrome Browser in Headless Mode:**

```bash
    mvn test -X -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true 
```

## Reports & Logs

### Reports

After test execution, a detailed **Extent HTML report** is generated in the `./test-reports/` directory.

The report provides information about:

* Test cases executed
* Passed, failed, and skipped tests
* Test execution details
* Failure information and error messages
* Screenshots captured for failed test cases

The latest test report is also published through **GitHub Pages** for easy access to test execution results.

### Logs

Detailed execution logs are generated and stored in the `./logs/` directory.


## Integrated with GitHub Actions

This automation framework is integrated with GitHub Actions for continuous integration and automated test execution.

The workflow supports:

- Automated test execution on every push and pull request to the configured branch.
- Scheduled test execution using GitHub Actions cron scheduling.
- The automation tests are automatically executed every day at 11:30 PM IST using GitHub Actions.
- Headless browser execution in the CI environment.
- Automatic collection of test reports, screenshots, and logs after execution.
- Automatic deployment of the latest Extent HTML report to GitHub Pages.
- Easy access to the latest test execution results through the GitHub Pages report.

The reports will be archieved in gh-pages branch You can view the html reports at :
https://everythingaboutkoustavbasak.github.io/UI-Test-Automation-Framework/test-reports/


## Feedback
If you have any feedback, suggestions, or questions regarding this project, feel free to open an Issue in this repository or reach out through my GitHub profile or my email koustav23042001@gmail.com . 
Thank you! 
