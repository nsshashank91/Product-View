package com.wipro.productView.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	private String time;
	private String productId;
	private String productName;
	private String productDesc;
	private String createdBy;
	private String modelYear;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String productName, String productDesc, String createdBy, String modelYear) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.createdBy = createdBy;
		this.modelYear = modelYear;
	}
	
	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	

}
