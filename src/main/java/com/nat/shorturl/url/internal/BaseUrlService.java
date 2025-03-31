package com.nat.shorturl.url.internal;

import com.nat.shorturl.url.UrlCreateRequestDto;
import com.nat.shorturl.url.UrlDto;
import com.nat.shorturl.url.UrlNotFoundException;
import com.nat.shorturl.url.UrlService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
class BaseUrlService implements UrlService {
    private final UrlRepository urlRepository;
    private final UrlMapper urlMapper;

    public BaseUrlService(UrlRepository urlRepository, UrlMapper urlMapper) {
        this.urlRepository = urlRepository;
        this.urlMapper = urlMapper;
    }

    @Override
    public List<UrlDto> getAllUrls() {
        return urlRepository.findAll().stream().map(urlMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UrlDto getUrlByKey(String key) {
        return urlRepository.findByKey(key).map(urlMapper::toDto).orElseThrow(() -> new UrlNotFoundException(key));
    }

    @Override
    public UrlDto createUrl(UrlCreateRequestDto urlCreateRequestDto) {
        Url url = urlMapper.toEntity(urlCreateRequestDto);
        url.setExpiredAt(Instant.now().plus(1, ChronoUnit.DAYS));
        return urlMapper.toDto(
            urlRepository.save(url)
        );
    }

    @Override
    public void deleteAllExpiredUrls() {
        urlRepository.deleteAllExpired();
    }
}
