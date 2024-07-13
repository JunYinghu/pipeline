package test.cicd.project.mockGraphQL;

import graphql.schema.GraphQLSchema;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;

public class GraphQLTest {
    public String requestBody(String name, String professional,String fileName){
        String query = "query StaffLevel($name: String, $professional: String, $fileName: String)" +
                "    {  getStaffLevel(name: $name, professional: $professional,fileName: $fileName)" +
                "    {   department" +
                "        name" +
                "        web" +
                "        level" +
                "    }" +
                "}";

        return "{\"query\":\""+query+"\",\"variables\":{\n" +
                "\"name\":\""+name+"\"," +
                "\"professional\":\""+professional+"\"," +
                "\"fileName\":\""+fileName+"\" }}";

    }

    @Test
    public void test_mock(){
        // setup server and baseURI
        MockGraphQLServer graphQLServer = new MockGraphQLServer();
        GraphQLSchema schema = graphQLServer.schemaBuilder();
        int port = 808;
        graphQLServer.serverStart(schema, port);
        baseURI = "http://localhost:"+port+"/graphql";

        // query
        String name="jun";
        String professional="staff";
        String fileName="projectA_design_confidential.doc";

        String requestBody = requestBody(name,professional,fileName);
        Response response = given().contentType("application/json").body(requestBody).log().all().post();

        // verify
        response.then().log().all().statusCode(200);
        String verifyLevelMessage = "low, you are not allowed to review confidential file "+ fileName;
       // response.then().body("data.getStaffLevel[0].level",containsString(verifyLevelMessage));
       // response.getBody().prettyPrint(); // print out response

        //stop server
        graphQLServer.serverStop();
    }
}
