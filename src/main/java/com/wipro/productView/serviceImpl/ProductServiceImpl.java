package com.wipro.productView.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.productView.domain.Product;
import com.wipro.productView.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Product> getAllProducts(String url) {
		Product[] obj = restTemplate.getForObject(url, Product[].class);
		return Arrays.asList(obj);
	}

	@Override
	public Product getProduct(String url ,Long id) {
		Product obj = restTemplate.getForObject(url+"/"+id, Product.class);
		return obj;
	}

	@Override
	public void create(String url,Product product) {
		restTemplate.postForObject(url, product, Product.class);
		
	}
	
}
