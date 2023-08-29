package com.menes.security.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ApiException(String message, HttpStatus httpStatus, String timeStamp) {

}
