package com.wipro.productView.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.wipro.productView.domain.Inventory;
import com.wipro.productView.service.InventoryService;



@Service
public class InventoryServiceImpl implements InventoryService {

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Inventory> getInventories(String url) {
		Inventory[] obj = restTemplate.getForObject(url, Inventory[].class);
		return Arrays.asList(obj);
	}

	@Override
	public Inventory getInventory(String url, String id) {
		System.out.println(url+id);
		Inventory obj = restTemplate.getForObject(url+id, Inventory.class);
			
		return obj;
	}
	
}
