package com.petShop.persistance;

import com.petShop.persistance.crud.PetCrudRepository;
import com.petShop.persistance.entity.Pet;

import java.util.List;
import java.util.Optional;

public class PetRepository {
    private PetCrudRepository PetCrudRepository;

    public List<Pet> getAll(){
        return (List<Pet>) PetCrudRepository.findAll();
    }

    public Optional<Pet> getPetById(int id) {
        return PetCrudRepository.findById(id);
    }

    public Pet save(Pet pet) {
        return PetCrudRepository.save(pet);
    }

    public void delete(int id) {
        PetCrudRepository.deleteById(id);
    }

}
