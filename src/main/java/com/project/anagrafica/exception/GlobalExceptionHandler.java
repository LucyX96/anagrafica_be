package com.project.anagrafica.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        ErrorCode code = ex.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(
                code.getCode(),
                code.getMessage(),
                code.getHttpStatus().value()
        );
        return new ResponseEntity<>(errorResponse, code.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedException(Exception ex) {
        ErrorCode code = ErrorCode.INTERNAL_ERROR;
        ErrorResponse errorResponse = new ErrorResponse(
                code.getCode(),
                code.getMessage(),
                code.getHttpStatus().value()
        );
        return new ResponseEntity<>(errorResponse, code.getHttpStatus());
    }
}
