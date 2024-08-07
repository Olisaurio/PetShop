package com.petShop.persistance;

import com.petShop.persistance.crud.ProductsCrudRepository;
import com.petShop.persistance.entity.Products;

import java.util.List;

public class ProductsRepository {

    ProductsCrudRepository ProductsCrudRepository;

    public List<Products> getAll(){
        return (List<Products>) ProductsCrudRepository.findAll();
    }

}
