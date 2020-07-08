package com.acquisitionsinc.catalog.storage;

import com.acquisitionsinc.catalog.entities.Vendor;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor, Long> {
}
