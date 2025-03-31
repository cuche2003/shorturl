package com.nat.shorturl.url;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {
    "http://localhost:4200"
}, maxAge = 3600)
public interface UrlResource {
    @GetMapping(
        value = "",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<List<UrlDto>> all();

    @GetMapping(
        value = "/{key}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<UrlDto> one(@PathVariable String key);

    @PostMapping(
        value = "",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<UrlDto> create(
        @Valid @RequestBody UrlCreateRequestDto requestDto,
        BindingResult result
    );
}
