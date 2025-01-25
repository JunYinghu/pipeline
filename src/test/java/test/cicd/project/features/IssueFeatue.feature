Feature: Issue
  Scenario: Issue Is Create Record Successfully
    Given User has been login
    And User is at Issue Module
    When User clicks on create button
    And User enters all fields
    And User clicks on submit button
    Then Test Case record is created successfully

  Scenario: Issue Is deleted Successfully
    Given User has been login
    When User select an issue record
    And User clicks on delete button
    Then Selected Record is deleted

    Scenario: this is to test
      Given User clicks on create button


