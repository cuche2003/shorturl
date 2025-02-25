package com.nat.shorturl.url.internal;

import com.nat.shorturl.url.UrlDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UrlResource.class)
class UrlResourceTests {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UrlService urlService;

    @Test
    @WithMockUser(username = "user", password = "user")
    void shouldGetAllUrls() throws Exception {
        List<UrlDto> urls = List.of(
            new UrlDto(1L, "https://example.com", "aaaaaaa", Instant.now(), Instant.now(), Instant.now())
        );

        given(urlService.getAllUrls()).willReturn(urls);
        mockMvc
            .perform(get("/api/v1/urls"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1L));
    }
}
