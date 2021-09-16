package com.hrsystem.usermanagement.payload.response;

import lombok.Data;

import java.util.List;


@Data
public class ApiResponse {
    private Object data;
    private List<ApiResponseError> errors;
}
