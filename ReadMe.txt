1) This project tests different API routes for JsonPlaceHolher API.
2) The technology stack used is Java+RestAssured+Cucumber+Maven
3) The tests are stored at location : JustEatTakeawayAPI/src/test/java/com/jet/framework/test/Features
4) The subsequent glue code is at location : JustEatTakeawayAPI/src/main/java/com/jet/framework/stepDefinitions
5) The TestRunner.java file is at : JustEatTakeawayAPI/src/test/java/com/jet/framework/TestRunner/TestRunner.java
   --> Use tag @Regression to run all the test cases together.

6) To run the test as maven test -->
- Ensure maven is installed on the computer and path set in system variables. (Refer : https://maven.apache.org/install.html)
- Go to project path in command prompt : cd <path of JustEatTakeawayAPI project>
- Execute command : mvn clean install
- All tests will be executed.
- To view the Test logs -->  JustEatTakeawayAPI/logs/TestExecution.log
- To view API logs --> JustEatTakeawayAPI/logs/APILog.txt
- To view test Report (open the report in web browser)--> JustEatTakeawayAPI/target/cucumber-html-reports/overview-features.html


How will we handle some load ? 
We can use any load testing tool like Jmeter, where we can define the number of threads (users) to execute simultaneously
and define the method (GET,POST,PUT,DELETE etc) to be executed by each thread.
All these threads will be executed together against the API, and we will get a report for the execution result of each request.
We can increase the load by increasing the number of threads.


How would we run these tests in a pipeline ?
To run the tests in pipeline, we can use any build management tool like TeamCity/Jenkins.
To create the pipeline with Teamcity and Git :
1) Ensure the project is commited and merged in a branch (preferably master) in Git.
2) Create a new project in Teamcity - say JETAPIAutomation
3) In VCS Roots --> provide the Git repository URL and the branch name.
4) In Build Steps --> set RunnerType as Maven, provide path to POM , and set Goal as clean install.Provide other relevant details
5) Set trigger 
6) Provide any Agent Requirements.
7) Run the build.


