# Test Cases - OrangeHRM

**Table: Test Cases**

| TC ID | Module | Scenario ID | Description | Preconditions | Test Steps | Test Data | Expected Result | Actual Result | Status | Automated? |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **TC_LOGIN_001** | Login | TS_LOGIN_01 | Verify valid login | App open | 1. Enter Username<br>2. Enter Password<br>3. Click Login | User: Admin<br>Pass: admin123 | User redirected to Dashboard | As Expected | **PASS** | Yes |
| **TC_LOGIN_002** | Login | TS_LOGIN_02 | Verify invalid login | App open | 1. Enter Invalid User<br>2. Enter Invalid Pass<br>3. Click Login | User: wrong<br>Pass: wrong | Error "Invalid credentials" displayed | As Expected | **PASS** | Yes |
| **TC_LOGIN_003** | Login | TS_LOGIN_03 | Verify empty login | App open | 1. Leave fields empty<br>2. Click Login | User: ""<br>Pass: "" | Error "Required" under fields | As Expected | **PASS** | Yes |
| **TC_DASH_001** | Dashboard | TS_DASH_01 | Verify Dashboard Load | Logged in | 1. Observe Header<br>2. Check Widgets | N/A | Header "Dashboard" displayed | As Expected | **PASS** | Yes |
| **TC_DASH_002** | Dashboard | TS_DASH_02 | Verify Menu Visibility | Logged in | 1. Check Side Menu | N/A | Admin, PIM, Leave, MyInfo visible | As Expected | **PASS** | Yes |
| **TC_ADMIN_001** | Admin | TS_ADMIN_01 | Search System User | Logged in as Admin | 1. Click Admin<br>2. Enter "Admin" in user box<br>3. Click Search | User: Admin | User "Admin" appears in table | As Expected | **PASS** | Yes |
| **TC_PIM_001** | PIM | TS_PIM_01 | Add Employee | Logged in, PIM Page | 1. Click Add<br>2. Enter First/Last Name<br>3. Click Save | FN: John<br>LN: Doe | Success Message displayed | Success Toast visible | **PASS** | Yes |
| **TC_PIM_002** | PIM | TS_PIM_02 | Search Employee | Logged in, PIM Page | 1. Enter Employee Name<br>2. Click Search | Name: John Doe | Employee ID/Name appears in list | No results found (Data issue) | **FAIL** | Yes |
| **TC_INFO_001** | My Info | TS_INFO_01 | Update Name | Logged in | 1. Click My Info<br>2. Edit First Name<br>3. Click Save | Name: Paul | Success Message displayed | Overlay blocked click | **FAIL** | Yes |
| **TC_INFO_001_R1**| My Info | TS_INFO_01| Update Name (Retry) | Logged in | 1. Wait for loader<br>2. Click Save | Name: Paul | Success Message displayed | Success Toast visible | **PASS** | Yes |
