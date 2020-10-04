package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CreateUserHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = Logger.getLogger(CreateUserHandler.class);

    @SneakyThrows
    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> apiGPayload, Context context) {

        /* ? turn this on if you want to see the full raw input to handleRequest
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("api gateway payload:\n");
       System.out.println(mapper.writeValueAsString(apiGPayload));
       */
        System.out.println("BODY \n");
        System.out.println(apiGPayload.get("body"));

        /*
        this is where we would do something with the POST req body like save to a DB
         */
        Map<String, Object> mockSuccessRes = new HashMap<>();
        mockSuccessRes.put("statusMessage", "successfully saved user");

        return ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setObjectBody(mockSuccessRes)
                .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                .build();
    }
}
