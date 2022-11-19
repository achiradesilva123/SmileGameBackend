package com.uob.smilegame.smilegame.dto.response;

public class SuccessResponseDto {
    private int status;
    private String message;
    private Object data;
    private boolean success;
    private int meta;

    public SuccessResponseDto() {
    }

    public SuccessResponseDto(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public SuccessResponseDto(int status, Object data, boolean success) {
        this.status = status;
        this.data = data;
        this.success = success;
    }

    public SuccessResponseDto(int status, String message, boolean success) {
        this.status = status;
        this.message = message;
        this.success = success;
    }

    public SuccessResponseDto(int status, Object data, int meta) {
        this.status = status;
        this.data = data;
        this.meta = meta;
    }

    public SuccessResponseDto(int status, Object data, boolean success, int meta) {
        this.status = status;
        this.data = data;
        this.success = success;
        this.meta = meta;
    }

    public SuccessResponseDto(int status, String message, Object data, boolean success, int meta) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.success = success;
        this.meta = meta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }
}
