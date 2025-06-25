# 🧪 SauceDemo UI Automation Framework

An end-to-end UI test automation framework built with **Selenium**, **TestNG**, and **Java**, featuring:
- Page Object Model (POM)
- Data-driven testing using CSV
- ExtentReports with screenshots
- RetryAnalyzer for flaky tests
- Log4j2 logging

---

## 📦 Tech Stack

| Tool       | Version     |
|------------|-------------|
| Java       | 17+         |
| Selenium   | 4.20.0      |
| TestNG     | 7.9.0       |
| ExtentReports | 5.1.1   |
| Log4j2     | 2.22.1      |
| Maven      | latest      |

---

## 🧱 Project Structure

src
├── main
│ └── java
│ ├── base/
│ ├── pages/
│ ├── utils/
├── test
│ └── java
│ ├── tests/
│ └── dataproviders/
resources/
│ └── testdata/
│ └── login_data.csv
testng.xml