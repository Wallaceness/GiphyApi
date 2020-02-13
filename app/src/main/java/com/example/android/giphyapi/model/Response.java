package com.example.android.giphyapi.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Response {

	@SerializedName("pagination")
	private Pagination pagination;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("meta")
	private Meta meta;

//	protected Response(Parcel datas) {
//	}

//	public static final Creator<Response> CREATOR = new Creator<Response>() {
//		@Override
//		public Response createFromParcel(List<DataItem> datas) {
//			return new Response(datas);
//		}
//
//		@Override
//		public Response[] newArray(int size) {
//			return new Response[size];
//		}
//	};

	public void setPagination(Pagination pagination){
		this.pagination = pagination;
	}

	public Pagination getPagination(){
		return pagination;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"pagination = '" + pagination + '\'' + 
			",data = '" + data + '\'' + 
			",meta = '" + meta + '\'' + 
			"}";
		}

//	@Override
//	public int describeContents() {
//		return 0;
//	}
//
//	@Override
//	public void writeToParcel(Parcel dest, int flags) {
//		dest.writeTypedList();
//	}
}