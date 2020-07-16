package com.acquisitionsinc.catalog.storage;

import com.acquisitionsinc.catalog.entities.Vendor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VendorStorage {

    private VendorRepository vendorRepo;

    public VendorStorage(VendorRepository vendorRepo) {
        this.vendorRepo = vendorRepo;
    }

    public void delete(long id) {
        vendorRepo.deleteById(id);
    }

    public Vendor save(Vendor vendor) {
        return vendorRepo.save(vendor);
    }

    public Collection<Vendor> retrieveAllVendors() {
        return (Collection<Vendor>) vendorRepo.findAll();
    }

    public Vendor retrieveVendorById(long id) {
        return vendorRepo.findById(id).get();
    }
}
