package com.acquisitionsinc.catalog.controllers;

import com.acquisitionsinc.catalog.entities.Vendor;
import com.acquisitionsinc.catalog.storage.VendorStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class VendorController {

    VendorStorage vendorStorage;

    public VendorController(VendorStorage vendorStorage) {
        this.vendorStorage = vendorStorage;
    }

    @GetMapping("/api/vendors/")
    public Collection<Vendor> retrieveAllVendors(){
        return vendorStorage.retrieveAllVendors();
    }

    @GetMapping("/api/vendors/{id}/")
    public Vendor retrieveVendorById(@PathVariable long id){
        return vendorStorage.retrieveVendorById(id);
    }
}
