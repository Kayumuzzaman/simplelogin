package com.dsi.simpleloginsystem.simpleloginsystem.rest.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

public class RestResponse {
    public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean successStatus, String message, Object responseObj) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            map.put("timestamp", Instant.now());
            map.put("status", status.value());
            map.put("isSuccess", successStatus);
            map.put("message", message);
            map.put("data", responseObj);
            return new ResponseEntity<>(map, status);
        } catch (Exception e) {
            map.clear();
            map.put("timestamp", Instant.now());
            map.put("status", status.value());
            map.put("isSuccess",false);
            map.put("message", e.getMessage());
            map.put("data", null);
            return new ResponseEntity<>(map, status);
        }
    }
}