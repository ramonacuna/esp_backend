package com.espe.infrastructure.utility.response;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.LinkedHashMap;

import com.espe.infrastructure.utility.mapper.HttpModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpResponse {

    public static <T> ResponseEntity<HttpModelResponse<T>> ok(String message, T data) {
        return ResponseEntity.ok(new HttpModelResponse<>(HttpStatus.OK.value(), message, data));
    }

    public static <T> ResponseEntity<HttpModelResponse<T>> created(String message, T data) {
        return new ResponseEntity<>(new HttpModelResponse<>(HttpStatus.CREATED.value(), message, data), HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<HttpModelResponse<T>> customization(HttpStatus status, String message, T data) {
        return new ResponseEntity<>(new HttpModelResponse<>(status.value(), message, data), status);
    }

    public static <T> ResponseEntity<HttpModelResponse<T>> withoutSense() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public static ResponseEntity<?> error(String message, int statusCode) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Status code", statusCode);
        body.put("message", message);
        body.put("hourDate", OffsetDateTime.now());
        body.put("data", null);
        return ResponseEntity.status(statusCode).body(body);
    }

}
