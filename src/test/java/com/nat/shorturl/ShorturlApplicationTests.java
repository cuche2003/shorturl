package com.nat.shorturl;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@EnableCaching
@SpringBootTest
class ShorturlApplicationTests {
    void contextLoads() {
    }
}
