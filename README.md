#  Selenium Automation Testing Framework

##  Project Overview

This project is a **Selenium + TestNG automation framework** developed to test multiple web functionalities from the Expand Testing website.

It covers:

* Notes Management
* Form Interactions
* Alerts Handling
* Form Validation

The framework follows a **Page Object Model (POM)** design for better readability, reusability, and scalability.

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Extent Reports

---

##  Project Structure

```
src
 ├── main
 │    └── java
 │         ├── base
 │         │     ├── BaseTest.java
 │         │     └── BasePage.java
 │         │
 │         ├── pages
 │         │     ├── NotesPage.java
 │         │     ├── NotesLoginPage.java
 │         │     ├── FormInteractionsPage.java
 │         │     ├── FormValidationPage.java
 │         │     └── AlertsPage.java
 │         │
 │         └── utils
 │               ├── ConfigReader.java
 │               ├── ScreenshotUtil.java
 │               ├── ExtentManager.java
 │               └── TestListener.java
 │
 └── test
      └── java
           └── tests
                ├── NotesTest.java
                ├── FormInteractionsTest.java
                ├── FormValidationTest.java
                └── AlertsTest.java

reports/
screenshots/
testng.xml
pom.xml
```

---

##  Test Modules Covered
### Module 1: Authentication
* Verify valid login
* Verify locked user error
* Verify empty login
* Verify logout functionality

###  Module 2 – Notes Management

* Create a note
* Edit note
* Delete note
* Filter notes

---

### Module 3 – Form Interactions

* Input fields validation
* Dropdown selection
* Checkbox toggle
* Radio button selection

---

### Module 4 – Alerts Handling

* Handle cookie alerts
* Navigate back to Home

---

### Module 5 – Form Validation

* Fill form fields
* Validate input acceptance
* Select dropdown values

---

## Setup Instructions

### Clone Repository

```
git clone <your-repo-url>
cd <project-folder>
```

---

### Install Dependencies

```
mvn clean install
```

---

### Run Tests

Using TestNG XML:

```
mvn test -DsuiteXmlFile=testng.xml
```

OR

Right-click `testng.xml` → Run as TestNG Suite

---

## Extent Reports

After execution, open:

```
/reports/ExtentReport.html
```

### Report Features:

* Pass / Fail / Skip status
* Error logs
* Test execution details

---

## Screenshots

Screenshots are captured on failures and saved in:

```
/screenshots/
```

---

## Key Features

* Page Object Model (POM)
* Reusable utility classes
* Centralized configuration
* Screenshot capture on failure
* Extent Reports integration
* Modular test design

---

## Notes

* Ensure Chrome browser is installed
* Internet connection required
* Some elements (like disabled radio buttons) are intentionally non-clickable

---

## Author

**Bhavya Sree Kasa**

---
