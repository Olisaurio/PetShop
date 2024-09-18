package com.petShop.persistance.controller;


import com.petShop.persistance.crud.BillCrudRepository;
import com.petShop.persistance.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillCrudRepository billCrudRepository;

    // Obtener todas las facturas
    @GetMapping("/all")
    public List<Bill> getAll() {
        return (List<Bill>) billCrudRepository.findAll();
    }

    // Obtener una factura por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Bill> getById(@PathVariable("id") int id) {
        Optional<Bill> bill = billCrudRepository.findById(id);
        if (bill.isPresent()) {
            return new ResponseEntity<>(bill.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear o actualizar una factura
    @PostMapping("/save")
    public ResponseEntity<Bill> save(@RequestBody Bill bill) {
        Bill savedBill = billCrudRepository.save(bill);
        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);
    }

    // Eliminar una factura por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<Bill> bill = billCrudRepository.findById(id);
        if (bill.isPresent()) {
            billCrudRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
