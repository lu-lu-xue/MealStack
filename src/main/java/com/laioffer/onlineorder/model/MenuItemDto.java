package com.laioffer.onlineorder.model;

import com.laioffer.onlineorder.entity.MenuItemEntity;

/**
 * @author luluxue
 * @date 2024-10-06 3:16 PM
 */

public record MenuItemDto(
		Long id,
		String name,
		String description,
		Double price,
		String imageUrl
) {
	
	
	public MenuItemDto(MenuItemEntity entity) {
		this(entity.id(), entity.name(), entity.description(), entity.price(), entity.imageUrl());
	}
}
