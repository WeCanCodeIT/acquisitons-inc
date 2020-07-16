package com.acquisitionsinc.catalog.storage;

import com.acquisitionsinc.catalog.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductStorage {

    public ProductStorage(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    ProductRepository productRepo;

    public Product save(Product product) {
        return productRepo.save(product);
    }
}
