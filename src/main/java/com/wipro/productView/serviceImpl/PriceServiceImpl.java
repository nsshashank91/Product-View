package com.wipro.productView.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.wipro.productView.domain.Price;
import com.wipro.productView.service.PriceService;



@Service
public class PriceServiceImpl implements PriceService {

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Price> getAllPrices(String url) {
		Price[] obj = restTemplate.getForObject(url, Price[].class);
		return Arrays.asList(obj);
	}

	@Override
	public Price getPrice(String url, Long id) {
		Price obj = restTemplate.getForObject(url+"/"+id, Price.class);
		return obj;
	}
	
}
