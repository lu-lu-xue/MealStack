package com.laioffer.onlineorder.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 
 * @author luluxue
 * @date 2024-10-05 10:14 AM
 *
 */

@Table("customers")
public record CustomerEntity(
		@Id Long id, // primary key
		String email,
		String password,
		boolean enabled,
		String firstName,
		String lastName
) {
}
