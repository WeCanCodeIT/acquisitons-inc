package com.acquisitionsinc.catalog;

import com.acquisitionsinc.catalog.entities.Vendor;
import com.acquisitionsinc.catalog.storage.VendorStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    VendorStorage vendorStorage;

    public Populator(VendorStorage vendorStorage) {
        this.vendorStorage = vendorStorage;
    }

    @Override
    public void run(String... args) throws Exception {
        Vendor vendor1 = new Vendor("ACME Inc", "419-950-4343");
        Vendor vendor2 = new Vendor("Jenni's Ice Cream", "614-867-5309");
        vendorStorage.save(vendor1);
        vendorStorage.save(vendor2);
    }
}
