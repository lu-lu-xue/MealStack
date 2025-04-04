package com.laioffer.onlineorder.repository;

import com.laioffer.onlineorder.entity.MenuItemEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 * @author luluxue
 * @date 2024-10-05 10:41 AM
 */

public interface MenuItemRepository extends ListCrudRepository<MenuItemEntity, Long> {
	
	List<MenuItemEntity> getByRestaurantId(Long restaurantId);
}

