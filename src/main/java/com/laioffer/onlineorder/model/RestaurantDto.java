package com.laioffer.onlineorder.model;

import com.laioffer.onlineorder.entity.RestaurantEntity;

import java.util.List;

/**
 * @author luluxue
 * @date 2024-10-06 3:17 PM
 */

public record RestaurantDto(
		Long id,
		String name,
		String address,
		String phone,
		String imageUrl,
		List<MenuItemDto> menuItems
) {
	
	
	public RestaurantDto(RestaurantEntity entity, List<MenuItemDto> menuItems) {
		this(entity.id(), entity.name(), entity.address(), entity.phone(), entity.imageUrl(), menuItems);
	}
}

