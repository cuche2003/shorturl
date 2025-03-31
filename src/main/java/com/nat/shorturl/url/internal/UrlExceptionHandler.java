package com.nat.shorturl.url.internal;

import com.nat.shorturl.url.BadUrlCreateRequestException;
import com.nat.shorturl.url.UrlNotFoundException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.*;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
class UrlExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = UrlNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ApiResponse(
        responseCode = "404",
        description = "URL Not Found",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ProblemDetail.class)
        )
    )
    ResponseEntity<ProblemDetail> handleUrlNotFound(UrlNotFoundException ex) {
        return createResponseEntity(ex);
    }

    @ExceptionHandler(BadUrlCreateRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ApiResponse(
        responseCode = "400",
        description = "Bad URL Create Request",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ProblemDetail.class)
        )
    )
    ResponseEntity<ProblemDetail> handleUrlCreateRequestNotValid(
        BadUrlCreateRequestException ex
    ) {
        return createResponseEntity(ex);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ApiResponse(
        responseCode = "403",
        description = "Forbidden",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ProblemDetail.class)
        )
    )
    public ResponseEntity<Object> handleAccessDenied(AccessDeniedException ex) {
        return new ResponseEntity<>(
            ProblemDetail.forStatusAndDetail(
                HttpStatus.FORBIDDEN,
                "You do not have permission to perform this operation!"
            ),
            new HttpHeaders(),
            HttpStatus.FORBIDDEN
        );
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ApiResponse(
        responseCode = "401",
        description = "Unauthorized",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ProblemDetail.class)
        )
    )
    public ResponseEntity<ProblemDetail> handleAuthentication(AuthenticationException ex) {
        return new ResponseEntity<>(
            ProblemDetail.forStatusAndDetail(
                HttpStatus.UNAUTHORIZED,
                "You are not authorized for this operation!"
            ),
            new HttpHeaders(),
            HttpStatus.UNAUTHORIZED
        );
    }

    protected ResponseEntity<ProblemDetail> createResponseEntity(ErrorResponseException ex) {
        HttpHeaders headers = new HttpHeaders(ex.getHeaders());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(ex.getBody(), headers, ex.getStatusCode());
    }
}