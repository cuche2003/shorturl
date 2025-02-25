package com.nat.shorturl.url;

import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import java.time.Instant;

public record UrlDto(Long id, @URL String fullUrl, String key, Instant expiredAt, Instant createdAt,
                     Instant modifiedAt) implements Serializable {
}