package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Quotes;
import org.springframework.data.repository.CrudRepository;

public interface QuotesCrudRepository extends CrudRepository<Quotes, Integer> {
}
