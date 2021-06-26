Automation Assesment

### Pre-requisites: ###
* Download and install Java Development Kit (JDK 1.8)
* Download and install Maven
* Sauce Labs Login (Sign in with Github -> Username :- akshaymrt98@gmail.com  , Password:- BrainLara1@

### Project Setup: ###

* Extract the zip file
* Import as Maven Project

### Run tests ###
*Run by right click runner file Execution Using Web Runner in src/test/java/runner package on the basis of tags in Feature files. It will pick necessary configuration from config and sessions file
*or
*Run by maven use test command

###Report###
*Extent Reports,Allure Reports are Generated Under target folder
*Allure report can be generated using command in command prompt after changing directory to target folder and using command -> allure serve allure-results
*Word screenshots can be seen in Screenshots folder


####Framework suitable for a modern CICD pipeline#####

Jenkins Build Parameters & Goals in Jenkins Maven Project will execute  ->
pom.xml on github maven using test command ->
pom.xm will invoke WebRunner->
Web Runner Invokes Feature Files using tags->
Feature file invokes Step Definition ->
Step definition will invoke Page Factory Object model



########OTher Details#########

*Project is created on MAC 
Scenarios for the Corresponding use cases are in Cucumber Feature File tagged as @ Regression
To use this project simply use File->Import->ExistingMavenProjects  in eclipse.
Import UI Automation Project.
->pom.xml file will download necessary jar files required in project from internet.
->To Run this Project go to Web Runner class inside Junit Runner package(inside src/test/java) and                      
              run as Junit Test.

6->	Reports are generated using extent Reports configuration and are generated on below path:-
a)	target/ExtentReport/ExtentHtml.html
b)	target/Logger/index.html :- With logs
c)	target/Spark/index.html :-  Detailed Reporting with Graph
d)	target folder:- Also Contains all the generated screenshots in execution after each Step
•	Reports can be seen by opening html files in web browser



