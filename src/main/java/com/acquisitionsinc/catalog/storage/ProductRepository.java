package com.acquisitionsinc.catalog.storage;

import com.acquisitionsinc.catalog.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
