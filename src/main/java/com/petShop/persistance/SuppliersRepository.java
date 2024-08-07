package com.petShop.persistance;

import com.petShop.persistance.crud.SuppliersCrudRepository;
import com.petShop.persistance.entity.Quotes;
import com.petShop.persistance.entity.Suppliers;

import java.util.List;
import java.util.Optional;

public class SuppliersRepository {

    SuppliersCrudRepository SuppliersCrudRepository;

    public List<Suppliers> getAll(){
        return (List<Suppliers>) SuppliersCrudRepository.findAll();
    }


    public Optional<Suppliers> getPetById(int id) {
        return SuppliersCrudRepository.findById(id);
    }

    public Suppliers save(Suppliers Suppliers) {
        return SuppliersCrudRepository.save(Suppliers);
    }

    public void delete(int id) {
        SuppliersCrudRepository.deleteById(id);
    }

}
