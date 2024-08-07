package com.petShop.persistance;

import com.petShop.persistance.crud.QuotesCrudRepository;
import com.petShop.persistance.entity.Quotes;

import java.util.List;

public class QuotesRepository {

    QuotesCrudRepository QuotesCrudRepository;

    public List<Quotes> getAll(){
        return (List<Quotes>) QuotesCrudRepository.findAll();
    }

}
