package com.acquisitionsinc.catalog.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Vendor {
    //Things that the class knows:
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "vendor")
    private Collection<Product> products;
    private String phoneNumber;
    @ElementCollection
    private List<String> comments;

    public Vendor(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    protected Vendor() {
    }

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

    public void addComment(String comment){
        if(comments==null){
            comments=new ArrayList<>();
        }
        comments.add(comment);
    }

    public List<String> getComments() {
        return comments;
    }
}
