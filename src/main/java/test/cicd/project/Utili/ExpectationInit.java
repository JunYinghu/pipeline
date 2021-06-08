package test.cicd.project.Utili;

import org.mockserver.mock.Expectation;

import org.mockserver.server.initialize.ExpectationInitializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class ExpectationInit implements ExpectationInitializer {

    @Override
    public Expectation[] initializeExpectations() {

        String fileName = System.getProperty("user.dir") + "/src/test/resources/UserList.json";
        String userPayload = getPayloadString(fileName);

        return new Expectation[]{
                new Expectation(request().withPath("/userList")).
                        thenRespond(response().withBody(userPayload).withHeader("content-type", "application/json"))
        };
    }

    private String getPayloadString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
