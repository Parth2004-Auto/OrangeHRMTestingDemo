# Defect / Bug Report - OrangeHRM

**Table: Defect Report**

| Bug ID | TC ID | Module | Summary | Steps to Reproduce | Expected Result | Actual Result | Severity | Priority | Status |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **BUG_PIM_001** | TC_PIM_002 | PIM | Search Employee returns no results immediately after creation | 1. Create Employee "John Doe"<br>2. Go to PIM List<br>3. Search "John Doe" | Employee should appear in table | "No Records Found" message appears | Medium | High | **Open** |
| **BUG_INFO_002** | TC_INFO_001 | My Info | Save button click intercepted by loader | 1. Go to My Info<br>2. Edit Name<br>3. Quickly click Save | Save successful | Click intercepted by `oxd-form-loader` | High | High | **Fixed** |
| **BUG_UI_003** | TC_DASH_001 | Dashboard | Widget layout breaks on 50% zoom | 1. Login<br>2. Zoom browser to 50% | Widgets scale responsively | Widgets overlap | Low | Low | **Backlog** |
