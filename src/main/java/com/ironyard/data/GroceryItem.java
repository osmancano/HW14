package com.ironyard.data;
import javax.persistence.*;

/**
 * Created by osmanidris on 2/2/17.
 */
@Entity
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROCERY_ITEM_SEQ")
    @SequenceGenerator(name = "GROCERY_ITEM_SEQ", sequenceName = "GROCERY_ITEM_SEQ")
    private long id;
    private String name;
    private int aisle;
    private double price;
    private int category;

    public GroceryItem(){
    }

    public GroceryItem(String name, int aisle, double price, int category) {
        this.name = name;
        this.aisle = aisle;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
