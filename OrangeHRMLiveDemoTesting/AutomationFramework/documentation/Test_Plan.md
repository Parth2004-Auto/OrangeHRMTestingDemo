# Master Test Plan for OrangeHRM Application

| Document Control | |
| :--- | :--- |
| **Project Name** | OrangeHRM Automation Framework |
| **Document ID** | TP_OHRM_v1.0 |
| **Version** | 1.0 |
| **Author** | QA Team (OrangeHRMDemo) |
| **Date** | 2026-02-05 |

## 1. Introduction
The objective of this Test Plan is to define the testing strategy, scope, resources, and schedule for the testing of the OrangeHRM Demo Application. This document serves as the blueprint for all testing activities to ensure the application meets quality standards before sign-off.

## 2. Scope

### 2.1 In-Scope
The following modules and functionalities are in scope for testing:
- **Login Module**: Valid/Invalid login, Forgot Password link verification.
- **Dashboard**: Layout, Quick Launch, My Actions, Menu Navigation.
- **Admin**: User Management (Search, Add, Delete users).
- **PIM**: Employee List, Add Employee, Personal Details.
- **Leave**: Apply Leave, Leave List validation.
- **My Info**: Updating personal details and saving.

### 2.2 Out-of-Scope
- Performance Testing (Load/Stress).
- Security Penetration Testing.
- Third-party integrations (e.g., social media logins if any).
- Visual layouts on mobile devices (Mobile App testing).
- Database migration testing.

## 3. Test Objectives
- Ensure functional correctness of Critical Business Flows.
- Verify UI responsiveness and usability.
- Validate error handling and validation messages.
- Achieve 100% execution coverage of critical high-priority test cases.
- Automate regression suite for Login, PIM, and Admin modules.

## 4. Test Strategy

### 4.1 Functional Testing (Manual)
- **Sanity Testing**: Quick check of critical features after deployment.
- **Regression Testing**: Detailed testing of all modules to ensure no regressions.
- **Exploratory Testing**: Ad-hoc testing to find edge cases.

### 4.2 Automation Testing
- **Framework**: Selenium WebDriver with Java 17 (Page Object Model).
- **Test Runner**: TestNG.
- **Reporting**: Extent Reports.
- **Modules Automated**: Login, Dashboard, Admin Search, PIM Add Employee.

## 5. Test Environment
| Component | Details |
| :--- | :--- |
| **Application URL** | https://opensource-demo.orangehrmlive.com |
| **Browser Support** | Chrome (Latest), Edge (Latest) |
| **OS** | Windows 10/11 |
| **Automation Tool** | Selenium WebDriver 4.x |
| **Java Version** | Java 17 |

## 6. Test Data
Test data will be maintained in external Excel sheets/JSON files or generated dynamically during execution.
- **Admin Credentials**: Admin / admin123
- **Test User**: Generated dynamically (e.g., John Doe + Timestamp) to avoid duplication.
- **Invalid Data**: Special characters, empty strings, SQL injection patterns for negative testing.

## 7. Entry and Exit Criteria

### 7.1 Entry Criteria
- Application is deployed and accessible.
- Smoke/Sanity check passes.
- Test data is ready.
- Test Cases are reviewed and approved.

### 7.2 Exit Criteria
- 100% of Critical and High-priority test cases executed.
- Pass percentage > 95%.
- No Critical or High-severity bugs open.
- Automation Suite execution completed with proper reports.

## 8. Test Deliverables
- Master Test Plan.
- Test Scenarios & Test Cases.
- Defect Report.
- Requirement Traceability Matrix (RTM).
- Automation Scripts & Source Code.
- Test Summary Report (Closure Report).

## 9. Roles and Responsibilities
| Role | Responsibility |
| :--- | :--- |
| **QA Lead** | Strategy, Planning, Review, Sign-off. |
| **QA Engineer (Manual)** | Test Case creation, Execution, Defect Logging. |
| **QA Engineer (Auto)** | script development, Framework maintenance, Execution. |

## 10. Risks and Mitigation
| Risk | Mitigation |
| :--- | :--- |
| **Application Downtime** | Use intermittent retry logic; Coordinate with Dev team. |
| **Dynamic Elements** | Use robust locators (XPath/CSS) and explicit waits. |
| **Test Data dependency** | Create distinct test data creation scripts. |

## 11. Approval
| Name | Role | Date | Signature |
| :--- | :--- | :--- | :--- |
| **Jane Doe** | QA Lead | - | - |
| **John Smith** | Project Manager | - | - |
