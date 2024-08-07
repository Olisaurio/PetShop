package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Suppliers;
import org.springframework.data.repository.CrudRepository;

public interface SuppliersCrudRepository extends CrudRepository<Suppliers, Integer> {
}
