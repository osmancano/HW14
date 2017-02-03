package com.ironyard;

import com.ironyard.data.*;
import com.ironyard.repository.*;
import org.apache.tomcat.jni.Time;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	GroceryStoreRepo groceryStoreRepo;
	@Autowired
	GroceryItemRepo groceryItemRepo;
	@Autowired
	ShopperPersonRepo shopperPersonRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void readAndSave(){
		GroceryStore gStore = new GroceryStore("Walmart","Orlando", "7 AM", "9 PM");
		groceryStoreRepo.save(gStore);

		GroceryItem gItem = new GroceryItem("Rice", 7,4.6,5);
		groceryItemRepo.save(gItem);

		ShopperPerson osman = new ShopperPerson("Osman", "canohibro@gmail.com",'M',"Orlando");
		shopperPersonRepo.save(osman);

		Assert.assertNotNull(groceryStoreRepo.findOne(gStore.getId()));
		Assert.assertNotNull(groceryItemRepo.findOne(gItem.getId()));
		Assert.assertNotNull(shopperPersonRepo.findOne(osman.getId()));

	}

	@Test
	public void updateTest() {
		GroceryItem gItem = new GroceryItem("Rice", 7, 4.6, 5);
		//Saving
		groceryItemRepo.save(gItem);
		//Updatein
		gItem.setName("Tamatos");
		groceryItemRepo.save(gItem);
		System.out.println(groceryItemRepo.findOne(gItem.getId()).getName());
		Assert.assertNotNull("Item must not be null",groceryItemRepo.findOne(gItem.getId()));
	}

	@Test
	public void deleteTest() {
		GroceryItem gItem = new GroceryItem("Rice", 7, 4.6, 5);
		//Saving
		groceryItemRepo.save(gItem);
		//Deleteing
		groceryItemRepo.delete(gItem);
		Assert.assertNull("Item must be null",groceryItemRepo.findOne(gItem.getId()));
	}

	@Test
	public void testRelations() {
		List<GroceryItem> shoppingItems = new ArrayList<>();
		GroceryItem gItem1 = new GroceryItem("Rice", 7, 4.6, 5);
		GroceryItem gItem2 = new GroceryItem("Tamato", 7, 3.2, 1);
		//Adding to the list
		shoppingItems.add(gItem1);
		shoppingItems.add(gItem2);
		//Creating Shopper Person
		ShopperPerson Osman = new ShopperPerson("Osman","canohibro@gmail.com",'M',"Orlando");
		Osman.setItemsList(shoppingItems);
		//Saving
		groceryItemRepo.save(gItem1);
		groceryItemRepo.save(gItem2);
		shopperPersonRepo.save(Osman);
		//Deleteing
		shoppingItems.remove(1);
		Osman.setItemsList(shoppingItems);
		shopperPersonRepo.save(Osman);
		Assert.assertNotNull("Item must be null",shopperPersonRepo.findOne(Osman.getId()));
	}

}
