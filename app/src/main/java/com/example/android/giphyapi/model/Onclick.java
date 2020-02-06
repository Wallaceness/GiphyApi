package com.example.android.giphyapi.model;


import com.google.gson.annotations.SerializedName;


public class Onclick{

	@SerializedName("url")
	private String url;

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Onclick{" + 
			"url = '" + url + '\'' + 
			"}";
		}
}