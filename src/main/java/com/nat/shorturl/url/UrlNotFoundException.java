package com.nat.shorturl.url;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class UrlNotFoundException extends ErrorResponseException {
    public UrlNotFoundException(String key) {
        super(HttpStatus.NOT_FOUND);

        this.setTitle("Url Not Found");
        this.setDetail("Url with key " + key + " is not found");
    }
}
