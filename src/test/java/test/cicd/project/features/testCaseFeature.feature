Feature: TestCaseCreate

  Scenario: Test Case Is Create Record Successfully
    Given User has been login
    And User is at Test Case Module
    When User clicks on create button
    And User enters all fields
    And User clicks on submit button
    Then Test Case record is created successfully

  Scenario: Test Case Is deleted Successfully
    Given User has been login
    When User select a test case record
    And User clicks on delete button
    Then Selected Record is deleted

    Scenario: this is to test
      Given  user open test case
      When  user is on test case page
      And


