package test.cicd.project;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class PriorTestAdapterAPITest {
    @Test
    public void retrieveTestCycleAsTitle_NotFound_TC01() {
        System.out.println("for Mock Server UI Learning");
        String sessionId = UUID.randomUUID().toString();
        String exceptionErrorMessage = "test failed: no found verification string";
        Long projectLong = 361971315692802098L;
        Response response = given().baseUri("http://43.139.159.146:8082/api/apiAdpater/361971315692802098/testCycle/retrieveTestCycleAsTitle/getId").param("title", "标题20021")
                //.param("projectId", projectLong)
                .header("Authorization", "7d585s07pc6t3hcxsf32w827gjqsyizh9959750sqbck2p088g").header("emailid", "qatest.hu.mary3@gmail.com").log().all().cookie("sessionId", sessionId).when().get().then().log().all() // print out response payload on console
                .statusCode(200).contentType("application/json").extract().response();
        response.jsonPath();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String dataID = jsonPathEvaluator.get("data.id");
        if (dataID.isEmpty()) {
            System.out.println("no testcycle, create it");
        }
    }

    @Test
    public void retrieveTestCycleAsTitle_Found_TC01() {
        System.out.println("for Mock Server UI Learning");
        String sessionId = UUID.randomUUID().toString();
        String exceptionErrorMessage = "test failed: no found verification string";
        Long projectLong = 593988941040848898L;
        Response response = given().baseUri("http://43.139.159.146:8082/api/apiAdpater/593988941040848898/testCycle/retrieveTestCycleAsTitle/getId")
                .param("title", "version_platform_env")
                //.param("projectId", projectLong)
                .header("Authorization", "7d585s07pc6t3hcxsf32w827gjqsyizh9959750sqbck2p088g").header("emailid", "qatest.hu.mary3@gmail.com").log().all().cookie("sessionId", sessionId).when().get().then().log().all() // print out response payload on console
                .statusCode(200).contentType("application/json").extract().response();
        response.jsonPath();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String dataID = jsonPathEvaluator.get("data.id");
        if (!dataID.isEmpty()) {
            System.out.println("testcycle is there " + dataID);
        }
    }

    @Test
    public void createIssue_TC01() {
        //apiAdpater/${projectId}/Issue/createIssue  done
        //apiAdpater/${projectId}/Issue/udpateIssue  done

        System.out.println("for Mock Server UI Learning");
        String sessionId = UUID.randomUUID().toString();
        String exceptionErrorMessage = "test failed: no found verification string";
        Long projectLong = 361971315692802098L;
        Response response = given().baseUri("http://43.139.159.146:8082/api/apiAdpater/361971315692802098/Issue/createIssue").param("title", "tesitng testcycle")
                //.param("projectId", projectLong)
                .header("Authorization", "7d585s07pc6t3hcxsf32w827gjqsyizh9959750sqbck2p088g").header("emailid", "qatest.hu.mary3@gmail.com").log().all().cookie("sessionId", sessionId).when().get().then().log().all() // print out response payload on console
                .statusCode(200).contentType("application/json").extract().response();
        response.jsonPath();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String dataID = jsonPathEvaluator.get("data.id");
        System.out.println("testcycle is there" + dataID);

    }

    @Test
    public void udpateIssue_TC01() {
        //apiAdpater/${projectId}/Issue/createIssue  done
        //apiAdpater/${projectId}/Issue/udpateIssue  done

        System.out.println("for Mock Server UI Learning");
        String sessionId = UUID.randomUUID().toString();
        String exceptionErrorMessage = "test failed: no found verification string";
        Long projectLong = 361971315692802098L;
        Response response = given().baseUri("http://43.139.159.146:8082/api/apiAdpater/361971315692802098/Issue/udpateIssue").param("title", "tesitng testcycle")
                //.param("projectId", projectLong)
                .header("Authorization", "7d585s07pc6t3hcxsf32w827gjqsyizh9959750sqbck2p088g").header("emailid", "qatest.hu.mary3@gmail.com").log().all().cookie("sessionId", sessionId).when().get().then().log().all() // print out response payload on console
                .statusCode(200).contentType("application/json").extract().response();
        response.jsonPath();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String dataID = jsonPathEvaluator.get("data.id");

        if (dataID.isEmpty()) {
            System.out.println("no testcycle, create it");
        }
    }

    @Test
    public void retrieveTCIdIInTestCycle_Found_TC02() {
        System.out.println("for Mock Server UI Learning");
        String sessionId = UUID.randomUUID().toString();
        String exceptionErrorMessage = "test failed: no found verification string";
        Long projectLong = 593988941040848898L;
        Response response = given().baseUri("http://43.139.159.146:8082/api/apiAdpater/" + projectLong + "/testRun/retrieveTCInTestCycle/getCaseId").param("testCaseId", "1713542099892563969").param("testCycleId", "1719149264447275009")
                //.param("projectId", projectLong)
                .header("Authorization", "7d585s07pc6t3hcxsf32w827gjqsyizh9959750sqbck2p088g").header("emailid", "qatest.hu.mary3@gmail.com").log().all().cookie("sessionId", sessionId).when().get().then().log().all() // print out response payload on console
                .statusCode(200).contentType("application/json").extract().response();
        response.jsonPath();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String dataID = jsonPathEvaluator.get("data.id");
        if (dataID.isEmpty()) {
            System.out.println("no test case in test cycle, will add it");
        } else {
            System.out.println("test case in test cycle :" + dataID);
        }
    }

    @Test
    public void retrieveTCIdIInTestCycle_NoFound_TC02() {
        System.out.println("for Mock Server UI Learning");
        String sessionId = UUID.randomUUID().toString();
        String exceptionErrorMessage = "test failed: no found verification string";
        Long projectLong = 593988941040848898L;
        Response response = given().baseUri("http://43.139.159.146:8082/api/apiAdpater/593988941040848898/testRun/retrieveTCInTestCycle/getCaseId")
                .param("testCaseId", "1713542099892563969").param("testCycleId", "1719149264447275109")

                .header("Authorization", "7d585s07pc6t3hcxsf32w827gjqsyizh9959750sqbck2p088g").header("emailid", "qatest.hu.mary3@gmail.com").log().all().cookie("sessionId", sessionId).when().get().then().log().all() // print out response payload on console
                .statusCode(200).contentType("application/json").extract().response();
        response.jsonPath();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String dataID = jsonPathEvaluator.get("data");
        if (dataID.isEmpty()) {
            System.out.println("no test case in test cycle, will add it");
        } else {
            System.out.println("test case in test cycle :" + dataID);
        }
    }

}
