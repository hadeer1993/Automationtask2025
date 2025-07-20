# 📱 Android Registration Form Automation - Appium + TestNG

This project automates the testing of a basic Android **registration form** using **Appium**, **Java**, and **TestNG**.

---

## ✅ Features Covered

- Automated test for **successful registration**
- Automated test for **validations of all required fields**
- Field-by-field input with logging and delay for better observation
- Keyboard is automatically hidden to reveal the submit button
- App is closed and reopened **before each test** to ensure clean state

---

## 🧪 Technology Stack

- Java 21  
- Appium Java Client  
- TestNG  
- Maven  
- Android Emulator / Real Device

---

## 📂 Project Structure

```
Automationtask/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── Pages/
│       │   │   └── RegistrationPage.java
│       │   └── Tests/
│       │       └── RegistrationTest.java
│
├── pom.xml
└── README.md
```

---

## 🚀 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/hadeer1993/Automationtask2025.git
cd Automationtask2025
```

### 2. Install dependencies

Make sure `Maven` is installed, then run:

```bash
mvn clean install
```

### 3. Start Appium server

Ensure Appium server is running on:

```
http://127.0.0.1:4723
```

You can use the Appium Desktop app or run via terminal:

```bash
appium
```

### 4. Run tests

Run all tests:

```bash
mvn test
```

Or run a specific test class (e.g., RegistrationTest):

```bash
mvn -Dtest=RegistrationTest test
```

---

## 📝 Tests Overview

### ✅ testValidRegistration

- Enters valid data in all fields.
- Submits the form and verifies successful completion.

### ❌ testAllValidationMessages

- Submits the form with invalid data.
- Captures validation messages for all fields:
  - `Name is required`
  - `Email is required`
  - `Phone Number is required`
  - `Password is required`
  - `Confirm Password is required`
  - `Address is required`

---

## 📱 App Info

- **Package Name:** `com.example.tester_task`  
- **Main Activity:** `com.example.tester_task.MainActivity`

---

## 🙋‍♀️ Author

**Hadeer Ali**  
Senior Quality Control & Test Automation Engineer  
📧 hadeer@example.com

---

## 📌 Notes

- The code automatically hides the keyboard after entering the address.
- Each test closes and reopens the app to ensure isolation.
- Validation messages are captured using `XPath` selectors.

---

## 📸 Screenshots (optional)

_Add screenshots of your test run or emulator if needed._

---

## 📃 License

This project is open-source and free to use.

