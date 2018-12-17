package com.rknowsys.estrolo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rknowsys.estrolo.entities.Items;
import com.rknowsys.estrolo.service.ServiceItems;

@RestController
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ServiceItems serviceItems;

	@RequestMapping(method = RequestMethod.POST, value = "/saveitem")
	public String saveItem(@RequestBody Items items) {
	
		serviceItems.save(items);
		
		return "Items Saved Sucessfully";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getItemsList")
	public List<Items> getAllItems() {

		List<Items> list = serviceItems.getAllItems();
		return list;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getitembyid/{id}")
	public ResponseEntity<Optional<Items>> getCategoryById(@PathVariable Integer id) {
		Optional<Items> category = serviceItems.getItemById(id);
		return new ResponseEntity<Optional<Items>>(category, HttpStatus.FOUND);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteitembyid/{id}")
	public ResponseEntity<String> deleteItemById(@PathVariable Integer id) {
		serviceItems.deleteItemById(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}
