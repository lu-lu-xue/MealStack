package com.laioffer.onlineorder.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author luluxue
 * @date 2024-10-05 10:43 AM
 */

@Table("order_items")
public record OrderItemEntity(
		@Id Long id,
		Long menuItemId,
		Long cartId,
		Double price,
		Integer quantity
) {
}
