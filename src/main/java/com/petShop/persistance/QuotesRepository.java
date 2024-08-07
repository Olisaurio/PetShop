package com.petShop.persistance;

import com.petShop.persistance.crud.QuotesCrudRepository;
import com.petShop.persistance.entity.Products;
import com.petShop.persistance.entity.Quotes;

import java.util.List;
import java.util.Optional;

public class QuotesRepository {

    QuotesCrudRepository QuotesCrudRepository;

    public List<Quotes> getAll(){
        return (List<Quotes>) QuotesCrudRepository.findAll();
    }

    public Optional<Quotes> getPetById(int id) {
        return QuotesCrudRepository.findById(id);
    }

    public Quotes save(Quotes Quotes) {
        return QuotesCrudRepository.save(Quotes);
    }

    public void delete(int id) {
        QuotesCrudRepository.deleteById(id);
    }

}
