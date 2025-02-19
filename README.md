# 🎮 Проект по автоматизации тестовых сценариев для сайта компании

<p align="center"><img width=30% title="AVITO" src="images/avito.png">
</p>

## 🧑‍💻Test cases run
### Automated test cases
- Main page
  - [x] test text
  - [x] test text
- Search page
  - [x] test text
  - [x] test text
- Help page
  - [x] test text
  - [x] test text
  - [x] test text
### Manual test cases
- Main page
  - [x] test text
  - [x] test text
- Search page
  - [x] test text
  - [x] test text


# 💻 Instruments used
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="images/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="images/java-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="images/selenide-logo.svg"></code>
  <code><img width="5%" title="Selenoid" src="images/selenoid-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="images/gradle-logo.svg"></code>
  <code><img width="5%" title="JUnit5" src="images/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="images/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="images/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Github" src="images/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="images/jenkins-logo.svg"></code>
<!--   <code><img width="5%" title="Jira" src="images/jira-logo.svg"></code> -->
  <code><img width="5%" title="Telegram" src="images/Telegram.svg"></code>

</p>

+ **Java** is the primary programming language for this project.
+ **Selenide** framework was used for writing the automated tests.
+ **JUnit 5** is used as a unit testing framework.
+ **Gradle** is used to build the project.
+ **Jenkins** is used for running the tests.
+ **Selenoid** is used to launch browsers in **Docker** containers.
+ **Allure Report** is used to visualize test results.
+ **Telegram API** is used for receiving the final report via Telegram Bot.



# 🚀 How to run these tests

### Using command prompt
#### Locally
Please note that the following method will run the tests with the following parameters: (can be changed manually at src/test/resources/remote.properties)
+ Browser: **Google Chrome**
+ Browser version: **126.0**
+ Browser size: **1920x1080**

To run the automated tests:
```bash
gradle  jenkins_test -Denv='local'
```
To get the report:
```bash
allure serve build/allure-results
```

#### Remotely
To run the automated tests:
```bash
gradle Jenkins_test
```
To get the report:
```bash
allure serve build/allure-results
```

### Using [Jenkins](https://jenkins.autotests.cloud/job/qa_guru_31_bm_test/build?delay=0sec)

> Jenkins access request: admin@qa.guru

Please note that the following method will run the tests with the following default parameters:
+ Browser: **Google Chrome**
+ Browser version: **126.0**
+ Browser size: **1920x1080**

To run this test through Jenkins, please use this [job](https://jenkins.autotests.cloud/job/qa_guru_31_bm_test/build?delay=0sec), specially created for this project.
The environment is set up for the Russian language, to run it please use the button with an :arrow_forward:.
You can see the results via Allure Reports, or use the link to Allure TestOps.

<p  align="center">
<img src="images/jenkins.png" alt="How to run the tests with Jenkins" width="500">
</p>

The following page will open. You can keep the default credentials and press the indicated button directly.

<p  align="center">
<img src="images/build.png" alt="How to run the tests with Jenkins" width="500">
</p>





### List of tests with a description of steps and visualization of results
This page presents the standard distribution of the tests run by user stories and test suites.

<p align="center">
  <img src="images/moredetails.png" alt="Allure Report" width="500">
</p>

### Video attachment example
There's a video attachment for each test available.
<p align="center">
  <img title="Selenoid Video" src="images/sample-video-web.gif">
</p>

### Telegram notification example
<p align="center">
<img src="images/tgbot.png" alt="Telegram" width="550">
</p>
