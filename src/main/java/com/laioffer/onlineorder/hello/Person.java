package com.laioffer.onlineorder.hello;

/**
 * @author luluxue
 * @date 2024-09-29 3:48 PM
 */
public record Person(
		String name,
		String company,
		Address homeAddress,
		Book favoriteBook
) {
}
