package com.seproject.seproject.model;

public class ApiResponse {

    private String message;
    private Object data;

    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    /*public String getToken() {
        return token;
    }*/

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ApiResponse createResponse(String message, Object data) {
        return new ApiResponse(message, data);
    }


}
