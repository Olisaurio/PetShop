package com.petShop.persistance;

import com.petShop.persistance.crud.SuppliersCrudRepository;
import com.petShop.persistance.entity.Suppliers;

import java.util.List;

public class SuppliersRepository {

    SuppliersCrudRepository SuppliersCrudRepository;

    public List<Suppliers> getAll(){
        return (List<Suppliers>) SuppliersCrudRepository.findAll();
    }

}
