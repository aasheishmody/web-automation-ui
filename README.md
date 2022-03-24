# Enterprise level test framework for web applications in java for UI and Accessibility testing

<b>Application under test</b>

```
https://www.saucedemo.com
```

<b>Prerequisites</b>

```
Java >=1.8
Maven >=3.8.1
Google Chrome
Microsoft Edge
```

<b>Command to run the tests with default options</b>

```
mvn clean verify
```

Examples:

Parallel run on multiple instances of Microsoft Edge
```
mvn clean verify -Dbrowser=Edge
```

To run tests on multiple instances of Chrome in headless mode
```
mvn clean verify -Dbrowser=Chrome -DheadlessFlag=true
```

To run tests on multiple instances of Chrome with Tablet screensize
```
mvn clean verify -Dbrowser=Chrome -DscreenSize=Tablet
```

To run tests on dev environment and place test report in the target/dev folder
```
mvn clean verify -Dcucumber.options="--plugin json:target/dev/json-files/cucumber.json" -DtargetDir=target/dev -Denvironment=dev
```

Parallel test run on multiple browsers and multiple environments (dev and staging) with separate reports for each environnment
```
mvn clean verify -Dcucumber.options="--plugin json:target/staging/chrome/json-files/cucumber.json" -Dbrowser=chrome -DtargetDir=target/staging/chrome -Denvironment=staging
mvn clean verify -Dcucumber.options="--plugin json:target/staging/edge/json-files/cucumber.json" -Dbrowser=edge -DtargetDir=target/staging/edge -Denvironment=staging
mvn clean verify -Dcucumber.options="--plugin json:target/dev/chrome/json-files/cucumber.json" -Dbrowser=chrome -DtargetDir=target/dev/chrome -Denvironment=dev
mvn clean verify -Dcucumber.options="--plugin json:target/dev/edge/json-files/cucumber.json" -Dbrowser=edge -DtargetDir=target/dev/edge -Denvironment=dev
```

To run accessibility tests on dev environment and place test report in the target/dev folder
```
mvn clean verify -Dcucumber.options="--tags @accessibility --plugin json:target/dev/json-files/cucumber.json" -DtargetDir=target/dev -Denvironment=dev
```
*Accessibility tests take slightly over a minute to run because it needs to scan through the entire dom to check for accessibility violations on the page

<b>Test report with screenshots as test evidence embedded beneath each test step</b>

```
open target/../../cucumber-html-reports/overview-features.html in a browser
```

*For other configurable properties check the properties section in the POM file

<b>BDD</b> :heavy_check_mark:  
<b>Cross Browser</b> :heavy_check_mark:  
<b>Parallel run</b> :heavy_check_mark:  
<b>Page Object Pattern</b> :heavy_check_mark:
<b>Accessibility testing</b> :heavy_check_mark:
<b>Test Data Management for different environments</b> :heavy_check_mark:

<b>Tech Stack</b>

```
Selenium
Cucumber
Java
Maven
Axe
```

<b>Sample Test Report</b>

