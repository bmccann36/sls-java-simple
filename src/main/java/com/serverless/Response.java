package com.serverless;

import java.util.Map;


public class Response {
    private String message;
    private Map<String, Object> input;

    public Response(String message, Map<String, Object> input) {
        this.message = message;
        this.input = input;
    }
}
