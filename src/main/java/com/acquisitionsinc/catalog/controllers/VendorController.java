package com.acquisitionsinc.catalog.controllers;

import com.acquisitionsinc.catalog.entities.Product;
import com.acquisitionsinc.catalog.entities.Vendor;
import com.acquisitionsinc.catalog.storage.ProductStorage;
import com.acquisitionsinc.catalog.storage.VendorStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collection;

@RestController
public class VendorController {

    VendorStorage vendorStorage;
    ProductStorage productStorage;

    public VendorController(VendorStorage vendorStorage, ProductStorage productStorage) {
        this.vendorStorage = vendorStorage;
        this.productStorage = productStorage;
    }

    @GetMapping("/api/vendors/")
    public Collection<Vendor> retrieveAllVendors(){
        return vendorStorage.retrieveAllVendors();
    }

    @GetMapping("/api/vendors/{id}/")
    public Vendor retrieveVendorById(@PathVariable long id){
        return vendorStorage.retrieveVendorById(id);
    }

    @PostMapping("/api/vendors/add/")
    public Vendor addVendor(@RequestBody Vendor vendor){
        return vendorStorage.save(vendor);
    }

    @PatchMapping("/api/vendors/{vendorId}/addProduct/")
    public Vendor addProductToVendor(@PathVariable long vendorId, @RequestBody Product product){
        Vendor vendor = vendorStorage.retrieveVendorById(vendorId);
        Product productToAdd = new Product(product.getName(), vendor, product.getPrice());
        productStorage.save(productToAdd);

        return productToAdd.getVendor();
    }
    @DeleteMapping("/api/vendors/{vendorId}/")
    public Collection<Vendor> deleteVendor(@PathVariable long vendorId){
        vendorStorage.delete(vendorId);
        return vendorStorage.retrieveAllVendors();
    }
}
