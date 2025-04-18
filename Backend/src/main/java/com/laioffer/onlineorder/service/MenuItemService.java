package com.laioffer.onlineorder.service;

import com.laioffer.onlineorder.entity.MenuItemEntity;
import com.laioffer.onlineorder.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luluxue
 * @date 2024-10-06 3:24 PM
 */

@Service
public class MenuItemService {
	
	
	private final MenuItemRepository menuItemRepository;
	
	
	public MenuItemService(MenuItemRepository menuItemRepository) {
		this.menuItemRepository = menuItemRepository;
	}
	
	
	public List<MenuItemEntity> getMenuItemsByRestaurantId(long restaurantId) {
		return menuItemRepository.getByRestaurantId(restaurantId);
	}
	
	
	public MenuItemEntity getMenuItemById(long id) {
		return menuItemRepository.findById(id).get();
	}
}

