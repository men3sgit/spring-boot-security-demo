package com.menes.security.exceptions;

import com.menes.security.ultis.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author amigoscode, menes implementation =))
 */
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<?> handlerApiRequestException(ApiRequestException e) {
        ApiException error = new ApiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                DateFormatter.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
