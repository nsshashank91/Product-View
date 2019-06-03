package com.wipro.productView.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.productView.domain.Product;

@Component
public class ProductValue {

	@Autowired
	Product product;
	
	@Autowired
	Random rand;
	
	String[] productName={"Charger", "Shirt", "Shoes","Pen","Eraser","Watch","Jewelley","stove","induction","lighter"};
	String[] productDesc = {"Clothing","Wear","Fashion","Electronics","Stationery","Mobile","Kitchen","furniture"};
	String[] createdBy = {"Nokia","OnePlus","Camel","Polo","BBK","Pigeon","Tanishsq","Prestige","Fastrack"};
	String[] modelYear = {"2015","2016","2017","2018","2019"};
	
	int getNumber() {
		int n = rand.nextInt(1000);
		return n += 1;
	}
	
	String getName() {
		  int randomNumber=rand.nextInt(productName.length);
	       return productName[randomNumber];
	}
	
	String getDesc() {
		  int randomNumber=rand.nextInt(productDesc.length);
	       return productDesc[randomNumber];
	}
	
	String getCreatedBy() {
		  int randomNumber=rand.nextInt(createdBy.length);
	       return createdBy[randomNumber];
	}
	
	String getModelYear() {
		  int randomNumber=rand.nextInt(modelYear.length);
	       return modelYear[randomNumber];
	}
	
	public Product getProduct() {
		product.setProductId(String.valueOf(getNumber()));
		product.setProductName(getName());
		product.setProductDesc(getDesc());
		product.setCreatedBy(getCreatedBy());
		product.setModelYear(getModelYear());
		return product;
	}
}
