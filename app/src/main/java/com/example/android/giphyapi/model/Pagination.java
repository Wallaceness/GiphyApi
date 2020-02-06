package com.example.android.giphyapi.model;


import com.google.gson.annotations.SerializedName;


public class Pagination{

	@SerializedName("offset")
	private int offset;

	@SerializedName("total_count")
	private int totalCount;

	@SerializedName("count")
	private int count;

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}

	public int getTotalCount(){
		return totalCount;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	@Override
 	public String toString(){
		return 
			"Pagination{" + 
			"offset = '" + offset + '\'' + 
			",total_count = '" + totalCount + '\'' + 
			",count = '" + count + '\'' + 
			"}";
		}
}