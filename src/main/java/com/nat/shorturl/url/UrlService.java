package com.nat.shorturl.url;

import java.util.List;

/**
 * Used for mock tests
 */
public interface UrlService {
    List<UrlDto> getAllUrls();

    UrlDto getUrlByKey(String key);

    UrlDto createUrl(UrlCreateRequestDto urlCreateRequestDto);

    void deleteAllExpiredUrls();
}
