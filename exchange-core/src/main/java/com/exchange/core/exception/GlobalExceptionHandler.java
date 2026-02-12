package com.exchange.core.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Email;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> generalExceptionHandler(Exception ex , HttpServletRequest request) {
        log.error("Eroare la critica la enpointul {} | message : {}" , request.getRequestURI(), ex.getMessage() , ex);
        return buildErrorResponse( HttpStatus.INTERNAL_SERVER_ERROR , "Server error" ,  "Eroare tehnica!" , request);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status , String error , String message , HttpServletRequest request ) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                error,
                message,
                request.getRequestURI()
        );

        return new ResponseEntity<>(errorResponse, status);
    }

}
