package test.cicd.project.mockGraphQL;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class GraphQLHandler extends AbstractHandler {
    private final GraphQL graphQL;

    public GraphQLHandler(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        try {
            if ("/graphql".equalsIgnoreCase(s) && "POST".equalsIgnoreCase(request.getMethod())) {
                // get request body from request
                String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                // covert request boy as jsonObject
                JsonObject jsonObject = JsonParser.parseString(requestBody).getAsJsonObject();

                // extract query part from jsonObject
                String query = jsonObject.get("query").getAsString();
                // extract variables part from jsonObject
                JsonObject variablesObj = jsonObject.getAsJsonObject("variables");

                // reform variables as map type
                LinkedHashMap<String, Object> variables = new LinkedHashMap<>();
                variablesObj.entrySet().forEach(entry -> {
                    variables.put(entry.getKey(), entry.getValue().getAsString());
                });

                // covert query with variables as execution input
                ExecutionInput executionInput = ExecutionInput.newExecutionInput().query(query).variables(variables).build();

                // perform execution
                ExecutionResult executionResult = graphQL.execute(executionInput);
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);

                // reform returned data as json
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(httpServletResponse.getWriter(), executionResult.toSpecification());
                request.setHandled(true);
            }
            else {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.getWriter().println("请求地址有误");
                request.setHandled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.getWriter().println("Internal Server Error");
            request.setHandled(true);
        }
    }
}
