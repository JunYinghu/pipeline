package test.cicd.project;

import com.google.common.base.Charsets;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.apache.tika.io.IOUtils;
import org.mockserver.configuration.ConfigurationProperties;
import org.mockserver.integration.ClientAndServer;

import org.mockserver.logging.MockServerLogger;
import org.mockserver.netty.MockServer;
import org.mockserver.socket.tls.KeyStoreFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.cicd.project.Utili.ExpectationInit;

import javax.net.ssl.HttpsURLConnection;


import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class MockServerTest {

    private ClientAndServer mockServer;

    @BeforeTest
    public void startMockServer() {
        ConfigurationProperties.enableCORSForAPI(true);
        ConfigurationProperties.initializationClass(ExpectationInit.class.getName());
        ConfigurationProperties.persistExpectations(true);
        MockServer server = new MockServer();

        HttpsURLConnection.setDefaultSSLSocketFactory(new KeyStoreFactory(new MockServerLogger()).sslContext().getSocketFactory());
        mockServer = startClientAndServer(10800);

    }

    @Test
    public void MockServerGetMethod_TC01() throws InterruptedException {

        System.out.println("for Mock Server UI Learning");
        String sessionId = UUID.randomUUID().toString();

        String exceptionErrorMessage = "test failed: no found verification string";
        Response response = given()
                .baseUri("http://43.139.159.146:8082/userList")
                .log().all()
                .cookie("sessionId",sessionId)
                .when()
                .get()
                .then()
                .log().all() // print out response payload on console
                .statusCode(200)
                .contentType("application/json")
                .extract().response();
        Assert.assertTrue(response.asString().contains("qatest.hu.mary1@gmail.com"), exceptionErrorMessage);

        Thread.sleep(100000000);
    }


    @Test
    public void MockServerGetMethod_TC02() throws InterruptedException {
        System.out.println("for click API");
        String exceptionErrorMessage = "test failed: no found verification string";
        Response response = given()
                .baseUri("http://localhost:8082/api/customFields/getAllCustomList?")
                .param("projectId", "593988941040848896")
                .param("scopeId", "3000001")
                .header("Authorization", "7dkkjaycqgz5k48a6bh61eshfftg8umhw218fmwq4f1fps4ouc")
                .header("emailid", "hujy11@gmail.com")
                .log().uri()
                .when()
                .get()
                .then()
                .log().all() // print out response payload on console
                .statusCode(200)
                .contentType("application/json")
                .extract().response();
        Assert.assertTrue(response.asString().contains("qatest.hu.mary1@gmail.com"), exceptionErrorMessage);

        Thread.sleep(100000000);
    }


    @Test
    public void MockServerGetMethod_TC03() throws InterruptedException {
        System.out.println("for click API");
        String exceptionErrorMessage = "test 我";
        String  myJson="{\"project_id\":\"593988941040848896\",\"test_method\":\"自动化\",\"test_status\":\"草稿\",\"env\":\"测试环境\",\"test_type\":\"正向测试\",\"module\":\"\",\"case_category\":\"性能\",\"test_device\":\"手机\",\"version\":\"1.0.0.0\",\"browser\":\"Chrom\",\"report_to\":\"\",\"description\":\"\",\"remarks\":\"\",\"title\":\"测试用例添加\",\"test_data\":\"\",\"test_step\":\"\",\"link_feature\":\"\",\"test_condition\":\"\",\"customFieldData\":{\"attributes\":[{\"customFieldId\":\"647242539010625538\",\"customFieldLinkId\":\"647242541875335168\",\"fieldNameCn\":\"数值型\",\"scopeNameCn\":\"测试用例\",\"scope\":\"testCase\",\"scopeId\":\"3000001\",\"valueData\":\"2\"},{\"customFieldId\":\"647241103782711298\",\"customFieldLinkId\":\"647241106651615232\",\"fieldNameCn\":\"链接型字段\",\"scopeNameCn\":\"测试用例\",\"scope\":\"testCase\",\"scopeId\":\"3000001\",\"valueData\":\"http：http://localhost:9529/#/admincenter/admincenter\"},{\"customFieldId\":\"647241300587843586\",\"customFieldLinkId\":\"647241303469330432\",\"fieldNameCn\":\"测试日期类型\",\"scopeNameCn\":\"测试用例\",\"scope\":\"testCase\",\"scopeId\":\"3000001\",\"valueData\":\"2023-03-15\"},{\"customFieldId\":\"647239433581498370\",\"customFieldLinkId\":\"647239436597202944\",\"fieldNameCn\":\"单选框测试\",\"scopeNameCn\":\"测试用例\",\"scope\":\"testCase\",\"scopeId\":\"3000001\",\"valueData\":\"checked\"},{\"customFieldId\":\"647241726620078082\",\"customFieldLinkId\":\"647241729501564928\",\"fieldNameCn\":\"链接下拉框\",\"scopeNameCn\":\"测试用例\",\"scope\":\"testCase\",\"scopeId\":\"3000001\",\"valueData\":\"华为\"},{\"customFieldId\":\"647242648641343488\",\"customFieldLinkId\":\"647242651493470208\",\"fieldNameCn\":\"用户列表\",\"scopeNameCn\":\"测试用例\",\"scope\":\"testCase\",\"scopeId\":\"3000001\",\"valueData\":\"mary3\"},{\"customFieldId\":\"647240902133157890\",\"customFieldLinkId\":\"647240905023033344\",\"fieldNameCn\":\"复选框测试必填选择\",\"scopeNameCn\":\"测试用例\",\"scope\":\"testCase\",\"scopeId\":\"3000001\",\"valueData\":1}]}}";
        Response response = given()
                .body(myJson)
                .baseUri("http://localhost:8082/api")
                .header("Authorization", "tnt16se0g8376g3x716kcu67n3vud5w4dsnsvotyeuyy1c4wjb")
                .header("emailid", "hujy11@gmail.com")
                .log().uri()
                .when()
                .post("/testCase/save")
                .then()
                .log().all() // print out response payload on console
                .statusCode(200)
                .contentType("application/json")
                .extract().response();
        //Assert.assertTrue(responsecode=200, exceptionErrorMessage);

    }

    @Test
    public void MockServerGetMethod_TC04() throws InterruptedException {
        System.out.println("for click API");
        String exceptionErrorMessage = "test 我";
        //http://localhost:8082/api/testCase/step/info/1644938480452964354
        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJxYXRlc3QuaHUubWFyeTNAZ21haWwuY29tIiwiZXhwIjoxNjgzNjQyNzI0LCJpYXQiOjE2ODM2MzkxMjR9.LQxThBccgZJi29hr64TWf4sCortI49PQBS8-ScLUSMM

        Response response = given()
                .baseUri("http://43.139.159.146:8082/api")
                .header("Authorization", "tnt16se0g8376g3x716kcu67n3vud5w4dsnsvotyeuyy1c4wjb")
                .header("emailid", "qatest.hu.mary3@gmail.com")
                .log().uri()
                .when()
                .get("/testCase/step/info/1655151142000164866")
                .then()
                .log().all() // print out response payload on console
                .statusCode(200)
                .contentType("application/json")
                .extract().response();
        //Assert.assertTrue(responsecode=200, exceptionErrorMessage);

    }



    @AfterTest
    public void stopMockServer() {
        mockServer.stop();
    }
}
