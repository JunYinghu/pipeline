package test.cicd.project;

import Config.BasicConfig;
import com.priortest.annotation.TestCaseApi;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

//@Listeners({ConnectAPIListener.class})
public class PriorTestApiTest extends BasicConfig {
    private static final Logger logger = LogManager.getLogger(PriorTestApiTest.class);
    private String loginToken;
    private RequestSpecification httpRequest;

    @BeforeClass
    public void basicSetup() {
        // setUp test base URI
        RestAssured.baseURI = "http://43.139.159.146:8082/api";

    }

    @BeforeMethod
    public void setupRequest() {
        httpRequest = RestAssured.given();
    }

    @Test
    @Description()
    @TestCaseApi(testCaseId = "1710492397516914690", feature = "Login")
    public void $userLoginApi_TC01() {
        String loginPayloadPath = "src/main/java/resources/login.json/";
        httpRequest.body(new File(loginPayloadPath));
        httpRequest.contentType("application/json").log().all();
        //httpRequest.log().all();
        Response response = httpRequest.post("/login");

        int responseCode = response.statusCode();
        Assert.assertEquals(responseCode, 200);

        if (responseCode == 200) {
            JsonPath jsonPathEvaluator = response.jsonPath();
            loginToken = jsonPathEvaluator.get("data.token");

        }
    }

    @Test
    @Description()
    @TestCaseApi(testCaseId = "1710492397454000130", feature = "testCycle")
    public void createTestCycle_TC02() {
        String createTestSetPayload = "src/main/java/resources/testSetCreate.json/";
        httpRequest.body(new File(createTestSetPayload));
        httpRequest.contentType("application/Json");
        httpRequest.header("Authorization", "Bearer " + loginToken).log().all();
        //httpRequest.log().all();
        Response response = httpRequest.post("/testCycle/saveTestCycle");
        logger.info("TC2 ---------" + response.asString());
        int responseCode = response.statusCode();

        Assert.assertEquals(responseCode, 200);
    }

    @Test
    @Description("this case will be running into failure, an issue will be auto created")
    @TestCaseApi(testCaseId = "1710492372304953345", feature = "testSet")
    public void testSetCreated_TC03() {
        String createTestSetPayload = "src/main/java/resources/testSetCreate.json/";
        httpRequest.body(new File(createTestSetPayload));
        httpRequest.contentType("application/Json");

        //httpRequest.header("Authorization", "Bearer " + loginToken);
        //httpRequest.log().all();
        Response response = httpRequest.post("/testCycle/saveTestCycle");
        int responseCode = response.statusCode();

        Assert.assertEquals(responseCode, 403);
    }


    private void callIssueCreation(String issueTitle) {
        //httpRequest.body(new File());
        httpRequest.contentType("application/Json");
        Response response = httpRequest.post("/issue/save");
    }

    public void createIssue() {
    }


    private void logOutApi() {
        httpRequest.contentType("application/json");
        httpRequest.log().all();
        httpRequest.header("Authorization", "Bearer " + loginToken);
        Response response = httpRequest.get("/logout");
        int responseCode = response.statusCode();
        Assert.assertEquals(responseCode, 200);
        if (responseCode == 200) {
            JsonPath jsonPathEvaluator = response.jsonPath();
            String logout = jsonPathEvaluator.get("data.msg");
            Assert.assertTrue(logout.contains("注销成功。"));
        }
    }

    @AfterClass
    public void logOut() {
        logOutApi();
    }

}
