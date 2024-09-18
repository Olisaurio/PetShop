package com.petShop.persistance.controller;

import com.petShop.persistance.SuppliersRepository;
import com.petShop.persistance.entity.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {

    @Autowired
    private SuppliersRepository suppliersRepository;

    @GetMapping("/all")
    public List<Suppliers> getAll() {
        return suppliersRepository.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suppliers> getSupplierById(@PathVariable("id") int supplierId) {
        return suppliersRepository.getSupplierById(supplierId)
                .map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Suppliers> save(@RequestBody Suppliers supplier) {
        return new ResponseEntity<>(suppliersRepository.save(supplier), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int supplierId) {
        if (suppliersRepository.getSupplierById(supplierId).isPresent()) {
            suppliersRepository.delete(supplierId);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

