package com.ironyard.data;
import javax.persistence.*;
import java.util.List;

/**
 * Created by osmanidris on 2/2/17.
 */
@Entity
public class ShopperPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHOPPING_PERSON_SEQ")
    @SequenceGenerator(name = "SHOPPING_PERSON_SEQ", sequenceName = "SHOPPING_PERSON_SEQ")
    private long id;
    private String name;
    private String email;
    private char gender;
    private String address;
    @OneToMany(fetch = FetchType.EAGER)
    private List<GroceryItem> itemsList;

    public ShopperPerson(){

    }

    public ShopperPerson(String name, String email, char gender, String address) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<GroceryItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<GroceryItem> itemsList) {
        this.itemsList = itemsList;
    }
}
