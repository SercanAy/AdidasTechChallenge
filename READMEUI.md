
Codes and Test was prepared by:
* Sercan Ay
QA Automation Engineer

Email: sercanaytr3444@gmail.com

- Build Tool: Maven

- Tools: Gherkin, Selenium WebDriver

- Test Framework: Cucumber BBD (with JUnit Assertions)

Environment:
https://www.demoblaze.com/index.html

System Requirements:
Java 8 + JDK
Test RUN
Note: To run the scenarios, use @smoke tag for testing.

1. Way:
   Clone the projects
   Import maven dependencies from POM
   Go src -> test > java > com > productStore > runners > CukesRunner and Run
   To generate "HTML Maven Cucumber Report" ;
   Open Maven right side panel Double Click Project's Lifecycle Click "verify"

2. Way:
   Run from command line invoke mvn clean verify
   Test Reports Locations
   1- Cucumber HTML Plugin Reports: target -> cucumber-html-reports > overview-steps.html (Right Click and Open in any Browser )

a- When you run my project, Cucumber will create automatically online report link. You can click the link with in the 24 hours and check the all test steps and status.


b- To run these scenarios, use the @smoke tag in the CukesRunner class/Cucumber Options

github: https://github.com/Sergio4334

End!!!