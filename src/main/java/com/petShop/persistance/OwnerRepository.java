package com.petShop.persistance;

import com.petShop.persistance.crud.OwnerCrudRepository;
import com.petShop.persistance.entity.Owner;

import java.util.List;

public class OwnerRepository {
    private OwnerCrudRepository OwnerCrudRepository;

    public List<Owner> getAll(){
        return (List<Owner>) OwnerCrudRepository.findAll();
    }
}
