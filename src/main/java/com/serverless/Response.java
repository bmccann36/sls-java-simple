package com.serverless;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.User;

import java.util.List;
import java.util.Map;

@Data // this annotation provided by lombok lets us not right java boilerplate getters/setters
@AllArgsConstructor
public class Response {
    private String message;
    private Map<String, Object> input;
    private Map<String, Object> result;

    public Response(String message, Map<String, Object> input) {
        this.message = message;
        this.input = input;
    }
}
