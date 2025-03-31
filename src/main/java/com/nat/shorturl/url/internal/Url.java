package com.nat.shorturl.url.internal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;

import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "url", indexes = @Index(name = "key_index", columnList = "key"))
class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_url", nullable = false)
    @URL
    @Size(min = 1, max = 512)
    private String fullUrl;

    @Column(name = "key", nullable = false, unique = true)
    @Size(min = 1, max = 64)
    private String key;

    @Column(name = "expired_at")
    private Instant expiredAt;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private Instant modifiedAt;
}