package com.petShop.persistance.controller;

import com.petShop.persistance.crud.OwnerCrudRepository;
import com.petShop.persistance.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerCrudRepository ownerCrudRepository;

    // Obtener todos los propietarios
    @GetMapping("/all")
    public List<Owner> getAll() {
        return (List<Owner>) ownerCrudRepository.findAll();
    }

    // Obtener un propietario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Owner> getById(@PathVariable("id") int id) {
        Optional<Owner> owner = ownerCrudRepository.findById(id);
        if (owner.isPresent()) {
            return new ResponseEntity<>(owner.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear o actualizar un propietario
    @PostMapping("/save")
    public ResponseEntity<Owner> save(@RequestBody Owner owner) {
        Owner savedOwner = ownerCrudRepository.save(owner);
        return new ResponseEntity<>(savedOwner, HttpStatus.CREATED);
    }

    // Eliminar un propietario por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<Owner> owner = ownerCrudRepository.findById(id);
        if (owner.isPresent()) {
            ownerCrudRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
