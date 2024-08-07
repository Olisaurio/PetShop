package com.petShop.persistance;

import com.petShop.persistance.crud.ProductsCrudRepository;
import com.petShop.persistance.entity.Products;

import java.util.List;
import java.util.Optional;

public class ProductsRepository {

    ProductsCrudRepository ProductsCrudRepository;

    public List<Products> getAll(){
        return (List<Products>) ProductsCrudRepository.findAll();
    }


    public Optional<Products> getPetById(int id) {
        return ProductsCrudRepository.findById(id);
    }

    public Products save(Products products) {
        return ProductsCrudRepository.save(products);
    }

    public void delete(int id) {
        ProductsCrudRepository.deleteById(id);
    }
}
