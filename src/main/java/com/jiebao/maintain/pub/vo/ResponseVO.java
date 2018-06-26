package com.jiebao.maintain.pub.vo;

public class ResponseVO {
    ResponseCodes code;
    String message;
    Object data;

    public ResponseCodes getCode() {
        return code;
    }

    public void setCode(ResponseCodes code) {
        this.code = code;
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

    public ResponseVO(){
        //donothing;
    }
    public ResponseVO(ResponseCodes code, String message){
        this.code = code;
        this.message = message;
    }
    public ResponseVO(ResponseCodes code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseVO set(ResponseCodes code, String message){
        this.code = code;
        this.message = message;
        return this;
    }

    public ResponseVO set(ResponseCodes code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public enum ResponseCodes {
        SUCCESS,FAILED,WARN
    }
}
