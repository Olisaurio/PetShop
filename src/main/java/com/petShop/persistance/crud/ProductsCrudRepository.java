package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductsCrudRepository extends CrudRepository<Products, Integer> {
}
