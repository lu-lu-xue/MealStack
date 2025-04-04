package com.laioffer.onlineorder.model;

/**
 * @author luluxue
 * @date 2024-10-12 10:29 AM
 */
public record RegisterBody(
		String email,
		String password,
		String firstName,
		String lastName
) {
}

