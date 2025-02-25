package com.nat.shorturl.url.internal;

import com.nat.shorturl.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import java.time.Duration;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
public class UrlDeleteTaskTests {
    @MockitoSpyBean
    UrlDeleteTasks tasks;

    @Test
    public void shouldDeleteExpiredUrlsHourly() {
        await().atMost(Duration.ofHours(2)).untilAsserted(() -> {
            verify(tasks, atLeast(2)).deleteExpiredUrlsHourly();
        });
    }
}
