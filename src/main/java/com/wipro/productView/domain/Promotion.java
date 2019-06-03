package com.wipro.productView.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Promotion {
	
	private int promoid;
    private int productId;
    private String promoName;
    private String detailDescription;
    private String promoUsage;
    private String startDate;
    private String expireDate;
    private String termsandConditions;
	public int getPromoid() {
		return promoid;
	}
	public void setPromoid(int promoid) {
		this.promoid = promoid;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getPromoName() {
		return promoName;
	}
	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public String getPromoUsage() {
		return promoUsage;
	}
	public void setPromoUsage(String promoUsage) {
		this.promoUsage = promoUsage;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getTermsandConditions() {
		return termsandConditions;
	}
	public void setTermsandConditions(String termsandConditions) {
		this.termsandConditions = termsandConditions;
	}
    

}
