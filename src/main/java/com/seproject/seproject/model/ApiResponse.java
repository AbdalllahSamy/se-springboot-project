package com.seproject.seproject.model;

public class ApiResponse {

    private String message;
    private Object data;
    private boolean success;

    public ApiResponse(String message, Object data, boolean success) {
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ApiResponse createResponse(String message, Object data, boolean success) {
        return new ApiResponse(message, data, success);
    }
    
}
