package com.example.android.giphyapi.model;


import com.google.gson.annotations.SerializedName;


public class Onsent{

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
			"Onsent{" + 
			"url = '" + url + '\'' + 
			"}";
		}
}