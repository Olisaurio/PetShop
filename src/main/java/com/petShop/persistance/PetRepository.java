package com.petShop.persistance;

import com.petShop.persistance.crud.PetCrudRepository;
import com.petShop.persistance.entity.Pet;

import java.util.List;

public class PetRepository {
    private PetCrudRepository PetCrudRepository;

    public List<Pet> getAll(){
        return (List<Pet>) PetCrudRepository.findAll();
    }

}
