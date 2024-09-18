package com.petShop.persistance.controller;

import com.petShop.persistance.crud.ProductsCrudRepository;
import com.petShop.persistance.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsCrudRepository productsCrudRepository;

    // Obtener todos los productos
    @GetMapping("/all")
    public List<Products> getAll() {
        return (List<Products>) productsCrudRepository.findAll();
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Products> getById(@PathVariable("id") int id) {
        Optional<Products> product = productsCrudRepository.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear o actualizar un producto
    @PostMapping("/save")
    public ResponseEntity<Products> save(@RequestBody Products product) {
        Products savedProduct = productsCrudRepository.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<Products> product = productsCrudRepository.findById(id);
        if (product.isPresent()) {
            productsCrudRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
