package test.cicd.project;

import com.priortest.annotation.TestCaseApi;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class PriorTestApiIssue {

    private RequestSpecification httpRequest;
    private String loginToken;
    boolean testRunFlag = false;

    @BeforeMethod
    public void basicSetup() {
        RestAssured.baseURI = "http://43.139.159.146:8082/api";
        httpRequest = RestAssured.given();
    }

    @Test
    @Description()
    public void skipTest_TC01() {
        if (testRunFlag = false) {
            throw new SkipException("Skipping Test 1 as flag is false.");
        }
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

        }


    }
}
