package com.rknowsys.estrolo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rknowsys.estrolo.dao.ItemsRepository;
import com.rknowsys.estrolo.entities.Items;

@Service
public class ServiceItems {

	@Autowired
	private ItemsRepository itemsRepository;
	
	public void save(Items items) {
	
		itemsRepository.save(items);
	
	}
	
	public List<Items> getAllItems(){
		List<Items> itemsList =itemsRepository.findAll();
		return itemsList;
	}
	
	public Optional<Items> getItemById(Integer id) {
		
		Optional<Items> item =itemsRepository.findById(id);
		return item;
	}
	
	public void deleteItemById(Integer id) {
		
		itemsRepository.deleteById(id);
		
	}
	
	

	
}
