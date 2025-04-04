package com.laioffer.onlineorder.model;

import com.laioffer.onlineorder.entity.CartEntity;
import com.laioffer.onlineorder.entity.MenuItemEntity;

import java.util.List;

/**
 * @author luluxue
 * @date 2024-10-06 3:14 PM
 */
public record CartDto(
		Long id,
		Double totalPrice,
		List<OrderItemDto> orderItems
) {
	public CartDto(CartEntity entity, List<OrderItemDto> orderItems) {
		// this()对应的参数来自于上面record
		this(entity.id(), entity.totalPrice(), orderItems);
	}
}


