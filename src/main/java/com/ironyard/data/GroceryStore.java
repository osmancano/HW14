package com.ironyard.data;
import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

/**
 * Created by osmanidris on 2/2/17.
 */

@Entity
public class GroceryStore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROCERY_STORE_SEQ")
    @SequenceGenerator(name = "GROCERY_STORE_SEQ", sequenceName = "GROCERY_STORE_SEQ")
    private long id;

    private String name;
    private String address;
    private String openingTime;
    private String closingTime;

    public GroceryStore(){
    }

    public GroceryStore(String name, String address, String openingTime, String closingTime) {
        this.name = name;
        this.address = address;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
}
