package com.petShop.persistance;

import com.petShop.persistance.crud.BillCrudRepository;
import com.petShop.persistance.entity.Bill;

import java.util.List;

public class BillRepository {

    private BillCrudRepository BillCrudRepository;

    public List<Bill> getAll(){
        return (List<Bill>) BillCrudRepository.findAll();
    }

}
