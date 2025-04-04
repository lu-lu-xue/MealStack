package com.laioffer.onlineorder.controller;

import com.laioffer.onlineorder.entity.MenuItemEntity;
import com.laioffer.onlineorder.model.RestaurantDto;
import com.laioffer.onlineorder.service.MenuItemService;
import com.laioffer.onlineorder.service.RestaurantService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luluxue
 * @date 2024-10-07 7:15PM
 */
@RestController
public class MenuController {
	
	
	private final RestaurantService restaurantService;
	private final MenuItemService menuItemService;
	
	
	public MenuController(RestaurantService restaurantService, MenuItemService menuItemService) {
		this.restaurantService = restaurantService;
		this.menuItemService = menuItemService;
	}
	
	
	@GetMapping("/restaurant/{restaurantId}/menu")
	// this can be modified
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<MenuItemEntity> getMenuByRestaurant(@PathVariable("restaurantId") long restaurantId) {
		return menuItemService.getMenuItemsByRestaurantId(restaurantId);
	}
	
	
	@GetMapping("/restaurants/menu")
	public List<RestaurantDto> getMenuForAllRestaurants() {
		return restaurantService.getRestaurants();
	}
}

