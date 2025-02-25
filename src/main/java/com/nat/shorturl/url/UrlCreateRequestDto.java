package com.nat.shorturl.url;

import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for Url Create Request
 */
public record UrlCreateRequestDto(@URL String fullUrl, String key, Instant expiredAt) implements Serializable {
}