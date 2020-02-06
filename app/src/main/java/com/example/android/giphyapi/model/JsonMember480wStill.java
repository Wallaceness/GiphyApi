package com.example.android.giphyapi.model;


import com.google.gson.annotations.SerializedName;


public class JsonMember480wStill{

	@SerializedName("width")
	private String width;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private String height;

	@SerializedName("size")
	private String size;

	public void setWidth(String width){
		this.width = width;
	}

	public String getWidth(){
		return width;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(String height){
		this.height = height;
	}

	public String getHeight(){
		return height;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	@Override
 	public String toString(){
		return 
			"JsonMember480wStill{" + 
			"width = '" + width + '\'' + 
			",url = '" + url + '\'' + 
			",height = '" + height + '\'' + 
			",size = '" + size + '\'' + 
			"}";
		}
}