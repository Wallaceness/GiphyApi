package com.example.android.giphyapi.model;


import com.google.gson.annotations.SerializedName;


public class Meta{

	@SerializedName("msg")
	private String msg;

	@SerializedName("response_id")
	private String responseId;

	@SerializedName("status")
	private int status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setResponseId(String responseId){
		this.responseId = responseId;
	}

	public String getResponseId(){
		return responseId;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"msg = '" + msg + '\'' + 
			",response_id = '" + responseId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}