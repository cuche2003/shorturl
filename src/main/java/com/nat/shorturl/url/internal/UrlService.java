package com.nat.shorturl.url.internal;

import com.nat.shorturl.url.UrlCreateRequestDto;
import com.nat.shorturl.url.UrlDto;
import com.nat.shorturl.url.UrlNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class UrlService {
    private final UrlRepository urlRepository;
    private final UrlMapper urlMapper;

    public UrlService(UrlRepository urlRepository, UrlMapper urlMapper) {
        this.urlRepository = urlRepository;
        this.urlMapper = urlMapper;
    }

    public List<UrlDto> getAllUrls() {
        return urlRepository.findAll().stream().map(urlMapper::toDto).collect(Collectors.toList());
    }

    public UrlDto getUrlByKey(String key) {
        return urlRepository.findByKey(key).map(urlMapper::toDto).orElseThrow(() -> new UrlNotFoundException(key));
    }

    public UrlDto createUrl(UrlCreateRequestDto urlCreateRequestDto) {
        return urlMapper.toDto(
            urlRepository.save(urlMapper.toEntity(urlCreateRequestDto))
        );
    }
    
    public void deleteAllExpiredUrls() {
        urlRepository.deleteAllExpired();
    }
}
