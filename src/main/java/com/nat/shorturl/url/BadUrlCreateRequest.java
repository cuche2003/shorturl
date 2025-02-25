package com.nat.shorturl.url;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.ErrorResponseException;

import java.util.HashMap;
import java.util.Map;

public class BadUrlCreateRequest extends ErrorResponseException {
    public BadUrlCreateRequest(BindingResult result) {
        super(HttpStatus.BAD_REQUEST);

        this.setTitle("Bad URL Create Request");
        this.setDetail("Bad URL Create Request");

        Map<String, Object> errors = new HashMap<>();
        result.getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        this.getBody().setProperty("errors", errors);
    }
}
