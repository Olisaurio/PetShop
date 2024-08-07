package com.petShop.persistance;

import com.petShop.persistance.crud.OwnerCrudRepository;
import com.petShop.persistance.entity.Owner;

import java.util.List;
import java.util.Optional;

public class OwnerRepository {
    private OwnerCrudRepository OwnerCrudRepository;

    public List<Owner> getAll(){
        return (List<Owner>) OwnerCrudRepository.findAll();
    }

    public Optional<Owner> getPetById(int id) {
        return OwnerCrudRepository.findById(id);
    }

    public Owner save(Owner owner) {
        return OwnerCrudRepository.save(owner);
    }

    public void delete(int id) {
        OwnerCrudRepository.deleteById(id);
    }
}
