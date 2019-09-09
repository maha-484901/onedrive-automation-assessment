@Assessment
Feature: Login to One Drive and automate

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
