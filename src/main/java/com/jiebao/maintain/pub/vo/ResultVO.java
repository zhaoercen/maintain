package com.jiebao.maintain.pub.vo;

public class ResultVO {
	String code;
	String message;
	Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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

	public ResultVO(){
		//donothing;
	}
	public ResultVO(String code, String message){
		this.code = code;
		this.message = message;
	}
	public ResultVO(String code, String message, Object data){
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResultVO set(String code, String message){
		this.code = code;
		this.message = message;
		return this;
	}

	public ResultVO set(String code, String message, Object data){
		this.code = code;
		this.message = message;
		this.data = data;
		return this;
	}


}
