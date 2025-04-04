package com.laioffer.onlineorder.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author luluxue
 * @date 2024-10-05 10:46AM
 */

@Table("carts")
public record CartEntity(
		@Id Long id,
		Long customerId,
		Double totalPrice
) {
}
