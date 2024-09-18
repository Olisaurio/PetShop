package com.petShop.persistance.controller;

import com.petShop.persistance.crud.PetCrudRepository;
import com.petShop.persistance.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetCrudRepository petCrudRepository;

    // Obtener todas las mascotas
    @GetMapping("/all")
    public List<Pet> getAll() {
        return (List<Pet>) petCrudRepository.findAll();
    }

    // Obtener una mascota por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getById(@PathVariable("id") int id) {
        Optional<Pet> pet = petCrudRepository.findById(id);
        if (pet.isPresent()) {
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear o actualizar una mascota
    @PostMapping("/save")
    public ResponseEntity<Pet> save(@RequestBody Pet pet) {
        Pet savedPet = petCrudRepository.save(pet);
        return new ResponseEntity<>(savedPet, HttpStatus.CREATED);
    }

    // Eliminar una mascota por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<Pet> pet = petCrudRepository.findById(id);
        if (pet.isPresent()) {
            petCrudRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
