# TestLink-Integrated-Selenium
Integrating Selenuim Web Automation Framework with TestLink, Test Management Tool for updating test case status automatically.

## Getting started
Selenium web Automation Framework is especially written for test cases which are written in TestLink.So that If we integrate this Automation framework with TestLink, We can achieve manual as well as automation execution of testcases within TestLink. This execution allows to generate Test plan and Test report in a fraction of the time and supports test reports in various formats like Excel, MS word, and HTML formats.  

### Prerequisites
* Install TestLink if you don't have

## Installing
### Step 1:
* Clone the project
### Step 2: Enable Automation in TestLink
Automation need to be enabled for integrating with Selenium.
To enable API Key: Go to Project -> Open your project -> Select “Enable Test Automation” / “API Key”.
### Step 3: Generate API Key
New API Key should be generated to trigger communication between webdriver code and testlink.
Go to My settings -> Click on “Generate a new key”
Then you should create Test Project, Test Plan, Build and Test suite.
### Step 4: Set up DEV_KEY & TESTLINK_URL
* Replace the DEV_KEY field with your TestLink API Key.
* Replace the TESTLINK_URL with your TestLink URL.
### Step 5: Set up Testcase
Provide the following field values of Testcase from TestLink
* Project Name
* Test Plan Name
* Test Case Name
* Build Name
### Step 6: Execute Selenium test and update test result in TestLink
Once you execute the script it updates the result for the particular test case in TestLink.By this integration we can be able to synchronize requirements specification and test specification together.
