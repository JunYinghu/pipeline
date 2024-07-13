package test.cicd.project.mockGraphQL;

import graphql.GraphQL;
import graphql.schema.*;
import org.eclipse.jetty.server.Server;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static graphql.Scalars.GraphQLString;

public class MockGraphQLServer {

    private Server server;

    public static void main(String[] args) {
        MockGraphQLServer graphQLServer = new MockGraphQLServer();

        GraphQLSchema schema = graphQLServer.schemaBuilder();
        int port = 8080;
        graphQLServer.serverStart(schema, port);

        // disable serverStop
        // graphQLServer.serverStop();
    }

    public GraphQLSchema schemaBuilder() {
        // define staff level type (response filed , type)
        GraphQLObjectType staffLevelType = GraphQLObjectType.newObject()
                .name("StaffLevel")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("department").type(GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("name").type(GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("web").type(GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("level").type(GraphQLString))
                .build();

        // define query parameter type
        GraphQLObjectType queryType = GraphQLObjectType.newObject()
                .name("Query")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("getStaffLevel")
                        .type(new GraphQLList(staffLevelType))
                        .argument(argument -> argument.name("name").type(GraphQLString))
                        .argument(argument -> argument.name("professional").type(GraphQLString))
                        .argument(argument -> argument.name("fileName").type(GraphQLString))
                        .dataFetcher(getStaffLevelDetails())) // get response data
                .build();

        GraphQLSchema schema = GraphQLSchema.newSchema().query(queryType).build();
        return schema;
    }

    public void serverStart(GraphQLSchema schema, int port) {
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        server = new Server(port);

        server.setHandler(new GraphQLHandler(graphQL));
        try {
            server.start();
            System.out.println("Local server with port "+ port +" has been started");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void serverStop() {
        if (server != null) {
            try {
                server.stop();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private DataFetcher<?> getStaffLevelDetails() {
        return environment -> {
            String name = environment.getArgument("name");
            String professional = environment.getArgument("professional");
            String fileName = environment.getArgument("fileName");
            List<Map<String, Object>> staffLevelList = new ArrayList<>();

            if (professional.contentEquals("manager")) {
                Map<String, Object> details = new LinkedHashMap<>();
                details.put("department", "LAB A");
                details.put("name", name);
                details.put("web", "http://www." + name + ".com");
                details.put("level", "high, your are allowed to review " + fileName);

                staffLevelList.add(details);
            } else {
                if (fileName.contains("confidential")) {
                    Map<String, Object> details = new LinkedHashMap<>();
                    details.put("department", "LAB A");
                    details.put("name", name);
                    details.put("web", "http://www." + name + ".com");
                    details.put("level", "low, you are not allowed to review confidential file " + fileName);
                    staffLevelList.add(details);
                } else {
                    Map<String, Object> details = new LinkedHashMap<>();
                    details.put("department", "LAB A");
                    details.put("name", name);
                    details.put("web", "http://www." + name + ".com");
                    details.put("level", "low, your are allowed to review none confidential file " + fileName);
                    staffLevelList.add(details);
                }
            }
            return staffLevelList;
        };
    }


}

