package com.ironyard.repository;

import com.ironyard.data.GroceryStore;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by osmanidris on 2/3/17.
 */
public interface GroceryStoreRepo extends CrudRepository<GroceryStore, Long> {
}
