package com.wipro.productView.service;

import java.util.List;

import com.wipro.productView.domain.Price;

public interface PriceService {

	List<Price> getAllPrices(String string);

	Price getPrice(String string, Long id);

}
