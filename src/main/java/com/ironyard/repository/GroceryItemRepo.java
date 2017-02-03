package com.ironyard.repository;

import com.ironyard.data.GroceryItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by osmanidris on 2/3/17.
 */
public interface GroceryItemRepo extends CrudRepository<GroceryItem, Long> {
}
