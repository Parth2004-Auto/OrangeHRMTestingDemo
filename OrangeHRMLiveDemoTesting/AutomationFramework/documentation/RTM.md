# Requirement Traceability Matrix (RTM) - OrangeHRM

**Table: RTM**

| Req ID | Requirement Description | Test Scenario ID | Test Case ID | Test Status |
| :--- | :--- | :--- | :--- | :--- |
| **REQ_001** | System shall allow login with valid credential pairs only. | TS_LOGIN_01 | TC_LOGIN_001 | Pass |
| **REQ_001.1** | System shall prevent access with invalid credentials. | TS_LOGIN_02 | TC_LOGIN_002 | Pass |
| **REQ_001.2** | System shall validate empty input fields. | TS_LOGIN_03 | TC_LOGIN_003 | Pass |
| **REQ_002** | Dashboard shall display all module shortcuts based on roles. | TS_DASH_02 | TC_DASH_002 | Pass |
| **REQ_003** | Admin shall be able to search for existing system users. | TS_ADMIN_01 | TC_ADMIN_001 | Pass |
| **REQ_004** | Admin/HR shall be able to add new employees to PIM. | TS_PIM_01 | TC_PIM_001 | Pass |
| **REQ_005** | Admin/HR shall be able to search for employees. | TS_PIM_02 | TC_PIM_002 | Fail |
| **REQ_006** | Users shall be able to update their personal info. | TS_INFO_01 | TC_INFO_001 | Pass (After Fix) |
