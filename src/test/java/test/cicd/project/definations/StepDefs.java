package test.cicd.project.definations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

    @Then("Test Case record is created successfully")
    public void testCaseRecordIsCreatedSuccessfully() {
        System.out.print("0909");
    }
        @And("User clicks on submit button")
        public void userClicksOnSubmitButton() {
            System.out.print("0909");
        }
        @When("User clicks on create button")
        public void userClickOnCreateButton () {
            System.out.print("0909");
        }
        @And("User enters all fields")
        public void userEnterAllFields (){
            System.out.print("0909");
        }
        @And("User is at Test Case Module")
        public void userIsAtTestCaseModule (){
            System.out.print("0909");
        }

        @Given("User has been login")
        public void userLogin() {
           System.out.print("0909");
        }


    @When("User select a test case record")
    public void userSelectATestCaseRecord() {
        System.out.print("0909");
    }

    @Then("Selected Record is deleted")
    public void selectedRecordIsDeleted() {
        System.out.print("0909");
    }

    @And("User is at Issue Module")
    public void userIsAtIssueModule() {
        System.out.print("0909");
    }

    @When("User select an issue record")
    public void userSelectAnIssueRecord() {
        System.out.print("0909");
    }

    @And("User clicks on delete button")
    public void userClicksOnDeleteButton() {
        System.out.print("0909");
    }
}
