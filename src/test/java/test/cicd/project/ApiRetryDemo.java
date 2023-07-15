package test.cicd.project;

import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Headers;
import org.mockserver.verify.VerificationTimes;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.Header.header;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class ApiRetryDemo {
    String headerId = "id";
    String headerVersion = "version";
    String headerName = "name";
    String queryParameter = "testParameter";
    String queryParameterValue = "false";
    String baseURI = "http://localhost:10800";
    int requestTime = 1;
    private ClientAndServer mockServer;

    private void startMockServer() {
        mockServer = startClientAndServer(10800);
    }

   @Test
    public void RetryTest_Request200_TC1() {
        // Prepare - Start Mock server
        // Mock server API - Active Expectations as required
        int pathId = 1;
        String basePath = "/testing.retry/";
        String requestPathWithPathId = basePath + pathId;
        mockServerActiveExpectations(requestPathWithPathId, 200);

        // Step - simulate call API with necessary data
        given().param(queryParameter, queryParameterValue)
                .headers(headerName, "test", headerVersion, "test", headerId, "test").log().all()
                .when().get(baseURI + basePath + "{id}", pathId)
                .then().statusCode(200).log().all();

        // Verify - Server receiving 1 times request
        // Verify - Server receiving request data (header, path, parameter)
        SoftAssert assertions = new SoftAssert();
        assertions.assertTrue(verifyReceivedRequestDataAndTimes(requestPathWithPathId, 2), "Failed: request not as expected");

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Restore - stop mock server
        stopMockServer();
        assertions.assertAll();
    }

    void mockServerActiveExpectations(String requestPath, int responseCode) {
        startMockServer();
        mockServer.when(request().withPath(requestPath).withQueryStringParameter(queryParameter, queryParameterValue)
                        .withHeaders(header(headerId), header(headerVersion), header(headerName)), exactly(requestTime))
                .respond(response().withStatusCode(responseCode));
    }

    boolean verifyReceivedRequestDataAndTimes(String requestPath, int expectedReceivedTimes) {
        try {
            mockServer.verify(request().withPath(requestPath).withQueryStringParameter(queryParameter, queryParameterValue)
                            .withMethod("GET").withHeaders(new Headers(
                                    header(headerName, "test"),
                                    header(headerVersion, "test"),
                                    header(headerId, "ID")
                            )),
                    VerificationTimes.exactly(expectedReceivedTimes));
            return true;
        } catch (AssertionError ex) {
            System.out.println("Exceptional: "+ ex);
            return false;
        }
    }

    private void stopMockServer() {
        mockServer.stop();
    }
}