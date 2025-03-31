package com.nat.shorturl.url.internal;

import com.nat.shorturl.url.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
class UrlDeleteTasks {
    private static final Logger log = LoggerFactory.getLogger(UrlDeleteTasks.class);

    private final UrlService urlService;

    public UrlDeleteTasks(UrlService urlService) {
        this.urlService = urlService;
    }

    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.MINUTES)
    public void deleteExpiredUrlsEvery5Minutes() {
        urlService.deleteAllExpiredUrls();
        log.info("Deleted expired urls.");
    }
}
