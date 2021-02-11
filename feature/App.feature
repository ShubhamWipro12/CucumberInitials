Feature: Testing google

  Scenario Outline: Pass some input to get some output
    Given Open Google
    When You pass "<query>"
    Then Pages related to search should get displayed "<query>"

    Examples: 
      | query      |
      | Selenium   |
      | Automation |
      | TestNG     |
