package com.nat.shorturl.url.internal;

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

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.HOURS)
    public void deleteExpiredUrlsHourly() {
        urlService.deleteAllExpiredUrls();
        log.info("Deleted expired urls.");
    }
}
