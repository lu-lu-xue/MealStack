package com.laioffer.onlineorder.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author luluxue
 * @date 2024-10-05 10:39 AM
 */

@Table("restaurants")
public record RestaurantEntity(
		@Id Long id,
		String name,
		String address,
		String phone,
		String imageUrl
) {
}
