package com.laioffer.onlineorder.repository;

import com.laioffer.onlineorder.entity.CartEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

/**
 * @author luluxue
 * @date 2024-10-05 10:46AM
 */

public interface CartRepository extends ListCrudRepository<CartEntity, Long> {
	
	// getByCustomerId()可以被spring自动实现
	CartEntity getByCustomerId(Long customerId);
	
	
	@Modifying
	@Query("UPDATE carts SET total_price = :totalPrice WHERE id = :cartId")
	void updateTotalPrice(Long cartId, Double totalPrice);
}

