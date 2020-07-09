package com.acquisitionsinc.catalog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @JsonIgnore
    @ManyToOne
    private Vendor vendor;
    private BigDecimal price;

    public Product(String name, Vendor vendor, BigDecimal price) {
        this.name = name;
        this.vendor = vendor;
        this.price = price;
    }

    protected Product(){}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
