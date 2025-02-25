package com.nat.shorturl.url.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByKey(String key);

    @Modifying
    @Transactional
    @Query("delete from Url u where u.expiredAt <= CURRENT_TIMESTAMP()")
    void deleteAllExpired();
}