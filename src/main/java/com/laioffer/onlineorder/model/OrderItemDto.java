package com.laioffer.onlineorder.model;

import com.laioffer.onlineorder.entity.MenuItemEntity;
import com.laioffer.onlineorder.entity.OrderItemEntity;

/**
 * @author luluxue
 * @date 2024-10-06 3:14 PM
 */
public record OrderItemDto(
		Long orderItemId,
		Long menuItemId,
		Long restaurantId,
		Double price,
		Integer quantity,
		String menuItemName,
		String menuItemDescription,
		String menuItemImageUrl
) {
	public OrderItemDto(OrderItemEntity orderItemEntity, MenuItemEntity menuItemEntity) {
		this(
				orderItemEntity.id(),
				orderItemEntity.menuItemId(),
				menuItemEntity.restaurantId(),
				orderItemEntity.price(),
				orderItemEntity.quantity(),
				menuItemEntity.name(),
				menuItemEntity.description(),
				menuItemEntity.imageUrl()
		);
	}
}

