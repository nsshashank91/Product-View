package com.wipro.productView.service;

import java.util.List;

import com.wipro.productView.domain.Promotion;

public interface PromotionService {

	public List<Promotion> getAllPromotions(String string);

	public Promotion getPromotion(String string, Long id);
}
