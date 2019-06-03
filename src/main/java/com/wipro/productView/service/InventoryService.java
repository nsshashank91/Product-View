package com.wipro.productView.service;

import java.util.List;

import com.wipro.productView.domain.Inventory;

public interface InventoryService {

	List<Inventory> getInventories(String url);

	Inventory getInventory(String url,String id);

	}
