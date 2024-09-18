package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetCrudRepository extends CrudRepository<Pet, Integer> {
}
