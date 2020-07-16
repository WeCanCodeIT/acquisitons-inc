package com.acquisitionsinc.catalog;

import com.acquisitionsinc.catalog.entities.Product;
import com.acquisitionsinc.catalog.entities.Vendor;
import com.acquisitionsinc.catalog.storage.ProductStorage;
import com.acquisitionsinc.catalog.storage.VendorStorage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Populator implements CommandLineRunner {
    VendorStorage vendorStorage;
    ProductStorage productStorage;

    public Populator(VendorStorage vendorStorage, ProductStorage productStorage) {
        this.vendorStorage = vendorStorage;
        this.productStorage = productStorage;
    }

    @Override
    public void run(String... args) throws Exception {
        Vendor vendor1 = new Vendor("ACME Inc", "419-950-4343");
        Vendor vendor2 = new Vendor("Jenni's Ice Cream", "614-867-5309");

        vendorStorage.save(vendor1);
        vendorStorage.save(vendor2);

        productStorage.save(new Product("Large Bottle Rocket", vendor1, new BigDecimal("10.00")));
        productStorage.save(new Product("Anvil", vendor1, new BigDecimal("5.00")));
        productStorage.save(new Product("T.N.T", vendor1, new BigDecimal("15.00")));
        productStorage.save(new Product("Grand Piano", vendor1, new BigDecimal("10000000.00")));
        productStorage.save(new Product("Catapult", vendor1, new BigDecimal("10000.00")));

        productStorage.save(new Product("Salted Carmel", vendor2, new BigDecimal("6.75")));
        productStorage.save(new Product("Cherry Sorbet", vendor2, new BigDecimal("6.75")));
        productStorage.save(new Product("Lavendar and Strawberry", vendor2, new BigDecimal("6.75")));
        productStorage.save(new Product("Blueberry and Sweet Corn", vendor2, new BigDecimal("6.75")));
    }
}
