package test.cicd.project.priorTestAdapter;

import ConfigUtil.BasicConfig;
import com.priortest.annotation.TestCaseApi;
import com.priortest.annotation.TestStepApi;
import com.priortest.api.PTAPIAdapter;
import com.priortest.api.PriorTestAPIAdapter;
import com.priortest.config.PTApiConfig;
import com.priortest.config.PTApiFieldSetup;
import com.priortest.run.api.PTApiUtil;
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
import payload.PayloadFieldSetup;
import payload.PayloadUtility;

import java.io.File;

@Listeners({PriorTestAPIAdapter.class})
public class PriorTestApiTest extends BasicConfig {
    private static final Logger logger = LogManager.getLogger(PriorTestApiTest.class);
    private RequestSpecification httpRequest;
    private String loginToken;

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
    @Description()
    @TestCaseApi(feature = "Login", priority = "高", severity = "严重", caseCategory = "功能", automationId = "00000017", issueId = {})
    public void userLoginApi_PASS_TC01() {
        // positive case :
        // no need to create case
        // no issue to close
        // no need to add test cycle
        // test run status update to test cycle
        PTApiFieldSetup.setPriority("高");
        PTApiFieldSetup.setSeverity("严重");
        PTApiFieldSetup.setCategory("功能");
        PTApiFieldSetup.setTitle("this is from est");

        System.out.println("testing pass");
    }

    @Test(enabled = true)
    @Description()
    @TestCaseApi(feature = "Login", priority = "高", severity = "严重",caseCategory = "功能", automationId = "00000015", issueId = {"1811744516475031553"})
    public void userLoginApi_PASS_TC02() {
        // positive case :
        // no issue to close
        // no need to add test cycle
        // test run status update to test cycle // issue bug to be fixed token error 500
        PTApiFieldSetup.setPriority("高");
        PTApiFieldSetup.setSeverity("严重");
        PTApiFieldSetup.setCategory("功能");
        PTApiFieldSetup.setTitle("this is from est");

        System.out.println("testing pass");
    }

    @Test(enabled = true)
    @Description()
    @TestCaseApi(feature = "Login", priority = "高", severity = "严重", caseCategory = "功能", automationId = "00000012", issueId = {"1789070444041674754", "1790297781840138242"})
    public void creationTestCycle_PASS_TC03() {
        // positive case :
        // no need to create case
        // no issue to close
        // need to setup test cycle  > go to BasicConfig to provide test cycle title parameter
        // 1. saveInstance  -
        // 2. saveTestCycle -
        // test run status update to test cycle
        PTApiFieldSetup.setPriority("高");
        PTApiFieldSetup.setSeverity("严重");
        PTApiFieldSetup.setCategory("功能");
        PTApiFieldSetup.setTitle("this is from est");

        System.out.println("testing pass");
    }

    @Test(enabled = true)
    @Description(" ")
    @TestCaseApi(feature = "Login", priority = "高", severity = "严重", caseCategory = "功能", automationId = "TC_01", testName = "closeIssue_PASS_TC04", issueId = {})
    public void closeIssue_PASS_TC04() {
        // positive case :
        // no need to create case
        // issue to close // as per auto-search
        // no need to setup test cycle  > go to BasicConfig to update test cycle
        // test run status update to test cycle

        PayloadFieldSetup.category("功能");
        PayloadFieldSetup.priority("高");
        PayloadFieldSetup.severity("严重");
        //String automationId = "TC_01";
        //String testName = "closeIssue_PASS_TC04";
        //PayloadUtility payloadUti = new PayloadUtility();

        //payloadUti.tcPayload(testName, automationId);

        System.out.println("testing pass");

    }

    @Test(enabled = true)
    @Description("pass")
    @TestCaseApi(feature = "Logout", priority = "中", severity = "严重", caseCategory = "功能", automationId = "TC_01", testName = "userLoginApi_testCaseCreate_Pass_TC01", issueId = "1793783114376417281")
    public void userLoginApi_testCaseCreate_Pass_TC01() {
            /*String loginPayloadPath = "src/main/java/resources/login.json/";
            httpRequest.body(new File(loginPayloadPath));
            httpRequest.contentType("application/json");
            httpRequest.log().all();
            Response response = httpRequest.post("/login");
            int responseCode = response.statusCode();
            logger.info(response.asString());
            Assert.assertEquals(responseCode, 200);

        if (responseCode == 200) {
            JsonPath jsonPathEvaluator = response.jsonPath();
            loginToken = jsonPathEvaluator.get("data.token");
        }*/


        String automationId = "TC00001";
        String testName = "userLoginApi_testCaseCreate_Pass_TC01";
        PayloadUtility payloadUti = new PayloadUtility();
        payloadUti.tcPayload(automationId);


        Assert.assertEquals(1, 1);
    }

    @Test
    @Description("这个测试用例 适用版1")
    @TestCaseApi(feature = "testCycle", priority = "高", severity = "严重", caseCategory = "功能", automationId = "TC_19", testName = "createIssue_FAIL_TC02", issueId = "1789070444041674754")
    public void createIssue_FAIL_TC02() {
        String externalId = "TC_19";
        String title = "createIssue_FAIL_TC02";
        PTApiFieldSetup.setTitle("createIssue_FAIL_TC02");
        PTApiFieldSetup.setFeature("功能");
        PTApiFieldSetup.setModule("功能");

        PayloadUtility payloadUti = new PayloadUtility();
        PTApiConfig.setIsTestCasePayloadFromTestCase(true);
        payloadUti.tcPayload(externalId);
        payloadUti.issueCreationPayload("Issue" + title);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 2, "failed test cases-：fails 1");
        softAssert.assertEquals(1, 2, "failed test cases- ：fails -2");
        softAssert.assertAll();
    }


    @TestStepApi(stepDesc = "this is web open step ")
    public void stepOpen() {
        System.out.println("test");
    }

    @TestStepApi(stepDesc = "this is user,password enter step ")
    public void stepUserPassword() {
        System.out.println("test");
    }


    @TestStepApi(stepDesc = "this is stpe ")
    public void step() {
        System.out.println("test");
    }


    @Test
    @Description("this case will be running into failure, an issue will be auto created")
    @TestCaseApi(feature = "NewCreate", priority = "高", severity = "严重", caseCategory = "功能", automationId = "1211222122", issueId = "1789070444041674754")
    public void testNewCreation_PASS_TC04() {
        Assert.assertEquals(1, 1);

    }


    @Test
    @Description("this case will be running into failure, an issue will be auto created")
    @TestCaseApi(feature = "testSet", priority = "高", severity = "严重", caseCategory = "功能", automationId = "1211222122", issueId = "1789070444041674754")
    public void testSetCreated_SKIP_TC03() {
        if (1 == 1) {
            throw new SkipException("Skipping this exception");
        }
        userLoginApi_PASS_TC01();
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

        //logOutApi();
    }

}
