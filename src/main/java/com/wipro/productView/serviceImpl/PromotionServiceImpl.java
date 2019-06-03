package com.wipro.productView.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.wipro.productView.domain.Promotion;
import com.wipro.productView.service.PromotionService;



@Service
public class PromotionServiceImpl implements PromotionService {

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Promotion> getAllPromotions(String url) {
		Promotion[] obj = restTemplate.getForObject(url, Promotion[].class);
		return Arrays.asList(obj);
	}

	@Override
	public Promotion getPromotion(String url, Long id) {
		Promotion obj = restTemplate.getForObject(url+"/"+id, Promotion.class);
		return obj;
	}
	
}
