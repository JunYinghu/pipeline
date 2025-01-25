package test.cicd.project.priorTestAdapter;

import ConfigUtil.BasicConfig;
import com.priortest.annotation.TestCaseApi;
import com.priortest.annotation.TestStepApi;
import com.priortest.api.PriorTestAPIAdapter;
import com.priortest.config.PTApiConfig;
import com.priortest.config.PTApiFieldSetup;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import payload.PayloadUtility;
import java.io.File;

@Listeners({ PriorTestAPIAdapter.class })
public class PriorTestApiTest extends BasicConfig {

    private static final Logger logger = LogManager.getLogger(PriorTestApiTest.class);

    private RequestSpecification httpRequest;

    private String loginToken;

    // Create an instance of the listener
    private final PriorTestAPIAdapter listener = new PriorTestAPIAdapter();

    @BeforeClass
    public void basicSetup() {
        // setUp test base URI
        RestAssured.baseURI = "http://43.139.159.146:8082/api";
    }

    @BeforeMethod
    public void setupRequest() {
        httpRequest = RestAssured.given();
    }

    @Test(enabled = true)
    @Description("This is to test user login")
    @TestCaseApi(feature = "Login", priority = "高", severity = "严重", caseCategory = "功能", automationId = "TC007", issueId = {})
    public void userLoginApi_PASS_TC07() {
        PTApiConfig.setIsTCPayloadFromAdapter(true);
        // SetUp TestCase Field
        //Assert.assertEquals("testingF","TestP","this is not expected");
    }

    @Test(enabled = true)
    @Description()
    @TestCaseApi(feature = "Login", priority = "高", severity = "严重", caseCategory = "功能", automationId = "TC008", issueId = {})
    public void userLoginApi_PASS_TC08() {
        PTApiConfig.setIsTCPayloadFromAdapter(true);
        System.out.println("testing pass");
    }

    @Test(enabled = true)
    @Description()
    @TestCaseApi(feature = "testCycle", priority = "高", severity = "严重", caseCategory = "功能", automationId = "TC003", testName = "TestCycle_PASS_TC03", issueId = {})
    public void creationTestCycle_PASS_TC03() {
        PTApiConfig.setIsTCPayloadFromAdapter(true);
        // positive case :
        System.out.println("testing pass");
    }

    @Test(enabled = true)
    @Description(" ")
    @TestCaseApi(feature = "Issue", priority = "高", severity = "严重", caseCategory = "功能", automationId = "TC001", testName = "closeIssue_Step_Fail_TC001", issueId = { "1871540576357208066" })
    public void closeIssue_Step_Fail_TC001() {
        PTApiConfig.setIsTCPayloadFromAdapter(true);
        PTApiConfig.setIsIssuePayloadFromAdapter(true);
        stepOpenUrl();
    }

    @TestStepApi(stepDesc = "打开页面", issueId = "")
    public void stepOpenUrl() {
        boolean stepSuccess = false;
        try {
            String loginPayloadPath = "src/main/java/resources/login.json/";
            httpRequest.body(new File(loginPayloadPath));
            httpRequest.contentType("application/json");
            // httpRequest.log().all();
            Response response = httpRequest.post("/login");
            Assert.assertEquals(response.statusCode(), 300, "Fails");
            stepSuccess = true;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            // You may want to rethrow the exception to fail the test
            throw e;
        } finally {
            // Track the final status of the step
            //listener.trackStep(this,"stepOpenUrl", stepSuccess);
            // Fail the test if the step fails
            if (!stepSuccess)
                throw new RuntimeException("testing failed");
        }
    }

    @Test(enabled = true)
    @Description("pass")
    @TestCaseApi(feature = "TestCase", priority = "中", severity = "严重", caseCategory = "功能", automationId = "TC009", testName = "Create_Pass_TC09", issueId = {})
    public void testCaseCreate_Pass_TC09() {
        PTApiConfig.setIsIssuePayloadFromAdapter(true);
        Assert.assertEquals(1, 1);
    }

    @Test
    @Description("这个测试用例 适用版1")
    @TestCaseApi(feature = "createIssue", priority = "低", severity = "严重", caseCategory = "性能", automationId = "TC005", testName = "createIssue_FAIL_TC05", issueId = {})
    public void createIssue_FAIL_SameStepWithTC4_TC05() {
        System.out.println("Test Run Start");
        PTApiConfig.setIsTCPayloadFromAdapter(false);
        String title = "createIssue_FAIL_TC05";
        PTApiFieldSetup.setTitle(title);
        PTApiFieldSetup.setFeature("createIssue");
        PTApiFieldSetup.setModule("createIssue");
        PTApiFieldSetup.setSeverity("一般");
        PTApiFieldSetup.setPriority("低");
        PTApiFieldSetup.setCategory("性能");
        PayloadUtility payloadUti = new PayloadUtility();
        payloadUti.tcPayload("createIssue_TC005");
        //stepOpenUrl();
        PTApiConfig.setIsIssuePayloadFromAdapter(true);
        softAssert.assertEquals(1, 1, "this is from test cases-：fails 1");
        softAssert.assertAll();
        Assert.assertEquals(1, 1, "this is from test cases-：fails 3");
        //verification();
        System.out.println("Test Run END");
    }

    SoftAssert softAssert = new SoftAssert();

    @TestStepApi(stepDesc = "This is verification", issueId = "")
    public void verification() {
        boolean stepSuccess = false;
        try {
            softAssert.assertEquals(1, 2, "failed test cases-：fails 1");
            softAssert.assertEquals(1, 1, "failed test cases- ：fails -2");
            softAssert.assertAll();
            stepSuccess = true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Track the final status of the step
            //listener.trackStep(this,"verification", stepSuccess);
            // if (!stepSuccess) throw new RuntimeException("verification failed");  // Fail the test if the step fails
        }
    }

    @Test
    @Description("this case will be running into failure, an issue will be auto created")
    @TestCaseApi(feature = "NewCreate", priority = "高", severity = "严重", caseCategory = "功能", automationId = "TC002", testName = "testNew_Fail_TC02", issueId = {})
    public void testNew_Fail_TC02_autoCreateIssue() {
        PTApiConfig.setIsTCPayloadFromAdapter(true);
        PTApiConfig.setIsIssuePayloadFromAdapter(true);
        Assert.assertEquals(1, 1);
    }

    @Test(enabled = false)
    @Description("this case will be running into failure, an issue will be auto created")
    @TestCaseApi(feature = "testSet", priority = "高", severity = "严重", caseCategory = "功能", automationId = "TC026", testName = "testSetCreated_SKIP_TC026", issueId = {})
    public void testSetCreated_SKIP_TC026() {
        if (false) {
            throw new SkipException("Skipping this exception");
        }
        //userLoginApi_PASS_TC01();
        String createTestSetPayload = "src/main/java/resources/testSetCreate.json/";
        httpRequest.body(new File(createTestSetPayload));
        httpRequest.contentType("application/Json");
        //httpRequest.header("Authorization", "Bearer " + loginToken);
        //httpRequest.log().all();
        Response response = httpRequest.post("/testCycle/saveTestCycle");
        int responseCode = response.statusCode();
        softAssert.assertEquals(1, 1, "this is from test cases-：fails 1");
        softAssert.assertEquals(1, 1, "this is from test cases-：fails 1");
        softAssert.assertAll();
    }

    @Test(enabled = true)
    @Description("this case will be running into failure, an issue will be auto created")
    @TestCaseApi(feature = "testSet", priority = "高", severity = "严重", caseCategory = "功能", automationId = "TC004", testName = "TESTTILTLE_TC004", issueId = {})
    public void testSetCreated_PASS_TC004() {
        Assert.assertEquals(403, 403);
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
        //logOutApi();
    }
}
