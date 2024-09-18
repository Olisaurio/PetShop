package com.petShop.persistance.controller;


import com.petShop.persistance.crud.QuotesCrudRepository;
import com.petShop.persistance.entity.Quotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quotes")
public class QuotesController {

    @Autowired
    private QuotesCrudRepository quotesCrudRepository;

    // Obtener todas las citas
    @GetMapping("/all")
    public List<Quotes> getAll() {
        return (List<Quotes>) quotesCrudRepository.findAll();
    }

    // Obtener una cita por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Quotes> getById(@PathVariable("id") int id) {
        Optional<Quotes> quote = quotesCrudRepository.findById(id);
        if (quote.isPresent()) {
            return new ResponseEntity<>(quote.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva cita
    @PostMapping("/save")
    public ResponseEntity<Quotes> save(@RequestBody Quotes quotes) {
        Quotes savedQuote = quotesCrudRepository.save(quotes);
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }

    // Eliminar una cita por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<Quotes> quote = quotesCrudRepository.findById(id);
        if (quote.isPresent()) {
            quotesCrudRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

