package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.User;
import org.apache.log4j.Logger;

import java.util.*;

public class GetUsersHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = Logger.getLogger(GetUsersHandler.class);

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        LOG.info("received: " + input);
        // make a map with some dummy data as response
        Map<String,Object> mockRes = new HashMap();
        mockRes.put("users", getMockUsers());

        // return apiG responseHandler
        return ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setObjectBody(mockRes)
                .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                .build();
    }

    /*
    helper method to generate some fake users
     */
    private List<User> getMockUsers() {
        User user1 = new User("bob", "1");
        User user2 = new User("sam", "2");
        List<User> userList = Arrays.asList(user1, user2);
        return userList;
    }
}
