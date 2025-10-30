package com.nopark.backend.global.controller;

import com.nopark.backend.global.exception.BaseException;
import com.nopark.backend.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ExceptionController {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
        log.error(">>>> code : {}, message : {}", e.getErrorCode(), e.getMessage());
        ErrorResponse body = ErrorResponse.builder()
                .code(String.valueOf(e.getStatusCode()))
                .message(e.getMessage())
                .errorCode(e.getErrorCode())
                .build();
        return ResponseEntity.status(e.getStatusCode()).body(body);
    }
}
