package com.acquisitionsinc.catalog.entities;

import com.acquisitionsinc.catalog.entities.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Vendor {
    //Things that the class knows:
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany
    private Collection<Product> products;
    private String phoneNumber;

    public Vendor(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    protected Vendor(){}

    //Things it does:
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
