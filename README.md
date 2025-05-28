# Web UI Testing Framework

A robust Web UI testing framework built with **Cucumber**, **Java**, **Gradle**, and **Selenium**. It follows the **Page Object Model (POM)** and uses **Gherkin** syntax for test case definitions. The framework includes sample tests for login functionality on [the-internet.herokuapp.com/login](https://the-internet.herokuapp.com/login).

---

## 🚀 Project Overview

This framework is designed to automate UI testing using best practices in test automation. It focuses on:

- **Maintainable structure** with Page Object Model
- **Behavior-Driven Development (BDD)** using Cucumber and Gherkin
- **Cross-browser testing** support (Chrome, Firefox, Edge)
- **Detailed reporting** using Cucumber HTML and Allure reports

### ✅ Features

- **Positive Tests:** Successful login with valid credentials
- **Negative Tests:** Invalid username/password, empty fields
- **Boundary Tests:** Login attempt with an excessively long username (1000+ characters)
- **Multi-Browser Support:** Compatible with Chrome, Firefox, and Edge
- **Reporting:** Generates readable Cucumber HTML and Allure reports

---

## 🧪 Test Scenarios

### Feature: Login Functionality

#### 1. Successful Login  
- **Username:** `tomsmith`  
- **Password:** `SuperSecretPassword!`  
- **Expected:** Success message: _“You logged into a secure area!”_

#### 2. Invalid Credentials  
- **Username:** `invalidUser`  
- **Password:** `wrongPassword`  
- **Expected:** Error message: _“Your username is invalid!”_

#### 3. Empty Fields  
- **Username:** _(empty)_  
- **Password:** _(empty)_  
- **Expected:** Error message: _“Your username is invalid!”_

#### 4. Valid Username, Empty Password  
- **Username:** `tomsmith`  
- **Password:** _(empty)_  
- **Expected:** Error message: _“Your password is invalid!”_

#### 5. Long Username (Boundary Case)  
- **Username:** 1000-character string  
- **Password:** `SuperSecretPassword!`  
- **Expected:** Error message: _“Your username is invalid!”_

---

## ⚙️ Prerequisites

Ensure the following tools are installed:

- **Java**: Version 17 or higher  
  _Check: `java --version`_
- **Gradle**: Version 8.10 or higher  
  _Check: `gradle --version`_
- **Browsers**: Chrome, Firefox, or Edge installed
- **Git**: For cloning the repository  
  _Check: `git --version`_
- **Visual Studio Code** (optional): Recommended for development
- **Internet Connection**: Required to access [the-internet.herokuapp.com](https://the-internet.herokuapp.com/login)

---

## ▶️ Running the Tests

### Clone the repository:
```bash
git clone https://github.com/your-username/web-ui-testing-framework.git
cd web-ui-testing-framework

