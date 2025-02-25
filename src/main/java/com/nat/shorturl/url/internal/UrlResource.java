package com.nat.shorturl.url.internal;

import com.nat.shorturl.url.BadUrlCreateRequest;
import com.nat.shorturl.url.UrlCreateRequestDto;
import com.nat.shorturl.url.UrlDto;
import jakarta.validation.Valid;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/urls")
@CrossOrigin("http://localhost:4200/")
@CacheConfig(cacheNames = "url")
class UrlResource {
    private final UrlService urlService;

    public UrlResource(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping(
        value = "",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<UrlDto>> all() {
        return ResponseEntity.ok(urlService.getAllUrls());
    }

    @GetMapping(
        value = "/{key}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UrlDto> one(@PathVariable String key) {
        return ResponseEntity.ok(urlService.getUrlByKey(key));
    }

    @PostMapping(
        value = "",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UrlDto> create(
        @Valid @RequestBody UrlCreateRequestDto requestDto,
        BindingResult result
    ) {
        if (result.hasErrors()) {
            throw new BadUrlCreateRequest(result);
        }

        UrlDto urlDto = urlService.createUrl(requestDto);

        return ResponseEntity.created(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(urlDto.id())
                .toUri()
        ).body(urlDto);
    }
}