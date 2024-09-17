package com.petShop.persistance;

import com.petShop.persistance.crud.SuppliersCrudRepository;
import com.petShop.persistance.entity.Quotes;
import com.petShop.persistance.entity.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SuppliersRepository {

    @Autowired
    private SuppliersCrudRepository suppliersCrudRepository;

    public List<Suppliers> getAll(){
        return (List<Suppliers>) suppliersCrudRepository.findAll();
    }

    public Optional<Suppliers> getSupplierById(int id) {
        return suppliersCrudRepository.findById(id);
    }

    public Suppliers save(Suppliers supplier) {
        return suppliersCrudRepository.save(supplier);
    }

    public void delete(int id) {
        suppliersCrudRepository.deleteById(id);
    }
}