package com.hrsystem.usermanagement.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hrsystem.usermanagement.payload.response.ApiResponse;
import com.hrsystem.usermanagement.payload.response.ApiResponseError;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ApiResponse apiResponse = new ApiResponse();

        List<ApiResponseError> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            ApiResponseError apiResponseError = new ApiResponseError();
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            apiResponseError.setField(fieldName);
            apiResponseError.setMessage(message);
            errors.add(apiResponseError);
        });
        apiResponse.setErrors(errors);
        return handleExceptionInternal(ex, apiResponse, headers, HttpStatus.BAD_REQUEST, request);
    }
    
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse> handleAPiException(
    		AccessDeniedException ex, WebRequest request) {

        ApiResponse apiResponse = new ApiResponse();
        ApiResponseError apiResponseError = new ApiResponseError();
        List<ApiResponseError> errors = new ArrayList<>();
        apiResponseError.setField("Unauthorize error");
        apiResponseError.setMessage(ex.getMessage());
        errors.add(apiResponseError);
        apiResponse.setErrors(errors);

        return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
    }
}
