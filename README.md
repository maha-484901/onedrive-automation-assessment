# OneDrive assessment demo project

This demo project is to automate the OneDrive web application.

Automation covers testing the following test cases (refer to these scenarios from /test/resources/upload.feature file written in Gherkin format)

```gherkin
  Scenario Outline: Login and upload zero byte file to OneDrive
    Given I am on the One Drive Home page URL <appUrl>
    When I fill in Username with <username> and click Next
    And I fill in Password with <password> and click Sign In
    Then I upload zero byte file <file> under documents folder and verify the file cannot be uploaded

    Examples: 
      | appUrl                    | username   | password   | file       |
      | https://onedrive.live.com | _username_ | _password_ | C:\\t0.txt |

  Scenario Outline: Login and upload byte file to OneDrive
    Given I am on the One Drive Home page URL <appUrl>
    When I fill in Username with <username> and click Next
    And I fill in Password with <password> and click Sign In
    Then I upload a file <file> under documents folder and verify the uploaded file

    Examples: 
      | appUrl                    | username   | password   | file       |
      | https://onedrive.live.com | _username_ | _password_ | C:\\t1.txt |

  Scenario Outline: Login and upload byte file to OneDrive and edit the uploaded file
    Given I am on the One Drive Home page URL <appUrl>
    When I fill in Username with <username> and click Next
    And I fill in Password with <password> and click Sign In
    And I upload a file <file> under documents folder and verify the uploaded file
    And I edit <modifiedFileContent> and save the uploaded file
    Then I download and compare the different versions of the file with <modifiedFileContent> from <fileLoc>
    Then I delete the uploaded document

    Examples: 
      | appUrl                    | username   | password   | file       | modifiedFileContent | fileLoc           |
      | https://onedrive.live.com | _username_ | _password_ | C:\\t1.txt | modify content -    | Downloads\\t1.txt |

```

## Software required

* Java v8
* Chrome Driver - for running scripts in Chrome headless browser
* Maven
* Any Java supported IDE


## Frameworks/Patterns used

* Selenium v3.11.0
* Cucumber BDD v1.2.5
* Page Object Model (POM)
* TestNG v1.2.5

## Installation

Install the dependencies via the Maven command:

    mvn install

## Browser Compatibility

* Chrome
* Firefox


## How to run?

Download [Chrome Driver](https://chromedriver.chromium.org/) and place it inside src/resources/ folder 

There are multiple ways to run this demo.

Run through maven    
    
    mvn verify 

Run through TestRunner, run TestRunner.java as "JUnit Test"

## Resources used

[Chrome Driver vChromeDriver 76.0.3809.126]( https://chromedriver.chromium.org/)

[Cucumber Extent Reports v3.1.1](https://github.com/email2vimalraj/CucumberExtentReporter) - MIT License

