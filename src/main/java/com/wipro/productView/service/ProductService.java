package com.wipro.productView.service;

import java.util.List;
import com.wipro.productView.domain.Product;

public interface ProductService {

	List<Product> getAllProducts(String url);

	Product getProduct(String url,Long id);
	
	void create(String url,Product product);

	}
