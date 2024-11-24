package com.stu.cloudlibrary.vo;

import lombok.Data;

@Data
public class ApiResponse<T> {

    public  static final int CODE_SUCCESS = 200;
    public  static final int CODE_FAILED = -1;

    private int code;
    private String status;
    private String message;
    private T data;


    public static <T> ApiResponse<T> success(T data){
        ApiResponse<T> response = new ApiResponse<>();
        response.code = CODE_SUCCESS;
        response.status = "success";
        response.data = data;
        return response;
    }

    public static <T> ApiResponse<T> failed(String message){
        ApiResponse<T> response = new ApiResponse<>();
        response.code = CODE_FAILED;
        response.status = "failed";
        response.message = message;
        return response;
    }
}
