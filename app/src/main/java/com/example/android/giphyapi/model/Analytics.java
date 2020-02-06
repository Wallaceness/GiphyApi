package com.example.android.giphyapi.model;


import com.google.gson.annotations.SerializedName;


public class Analytics{

	@SerializedName("onclick")
	private Onclick onclick;

	@SerializedName("onsent")
	private Onsent onsent;

	@SerializedName("onload")
	private Onload onload;

	public void setOnclick(Onclick onclick){
		this.onclick = onclick;
	}

	public Onclick getOnclick(){
		return onclick;
	}

	public void setOnsent(Onsent onsent){
		this.onsent = onsent;
	}

	public Onsent getOnsent(){
		return onsent;
	}

	public void setOnload(Onload onload){
		this.onload = onload;
	}

	public Onload getOnload(){
		return onload;
	}

	@Override
 	public String toString(){
		return 
			"Analytics{" + 
			"onclick = '" + onclick + '\'' + 
			",onsent = '" + onsent + '\'' + 
			",onload = '" + onload + '\'' + 
			"}";
		}
}