package test.cicd.project;


import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;


public class PriorTestApiTest {
    private String loginToken;
    private RequestSpecification httpRequest;

    @BeforeMethod
    public void basicSetup(){
        RestAssured.baseURI ="http://43.139.159.146:8082/api";
        httpRequest = RestAssured.given();
    }

    @Test
    @Description()
    public void userLoginApi_TC01() {
        String exceptionErrorMessage = "test failed: token not obtained";
        String loginPayloadPath = "src/main/java/resources/login.json/";
        httpRequest.body(new File(loginPayloadPath));
        httpRequest.contentType("application/json");
        httpRequest.log().all();
        Response response = httpRequest.post("/login");

        int responseCode = response.statusCode();
        Assert.assertEquals(responseCode, 200);

        if (responseCode == 200) {
            JsonPath jsonPathEvaluator = response.jsonPath();
            loginToken = jsonPathEvaluator.get("data.token");

        } else {
            callFailed("UserLogin");
        }
    }

    @Test
    @Description()
    public void createTestCycle_TC02(){
        String createTestSetPayload = "src/main/java/resources/testSetCreate.json/";
        httpRequest.body(new File(createTestSetPayload));
        httpRequest.contentType("application/Json");
        System.out.println(loginToken);
        httpRequest.header("Authorization", "Bearer " + loginToken);
        httpRequest.log().all();
        Response response = httpRequest.post("/testCycle/saveTestCycle");
        int responseCode = response.statusCode();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(responseCode, 200);
    }

    private void callFailed(String issueTitle) {
    //httpRequest.body(new File());
    httpRequest.contentType("application/Json");
    Response response = httpRequest.post("/issue/save");

    }


    public void createIssue() {

    }

    @AfterMethod
    public void getTestCaseStatus(ITestResult result){
        System.out.println(result.getStatus());
    }
}
