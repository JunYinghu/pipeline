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
                .baseUri("https://localhost:10800/userList")
                .log().uri()
                .cookie("sessionId",sessionId)
                .when()
                .get()
                .then()
                .log().all() // print out response payload on console
                .statusCode(200)
                .contentType("application/json")
                .extract().response();
        Assert.assertTrue(response.asString().contains("hujy@gmail.com"), exceptionErrorMessage);

        Thread.sleep(100000000);
    }





    @AfterTest
    public void stopMockServer() {
        mockServer.stop();
    }
}
