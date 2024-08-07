package com.petShop.persistance;

import com.petShop.persistance.crud.BillCrudRepository;
import com.petShop.persistance.entity.Bill;

import java.util.List;
import java.util.Optional;

public class BillRepository {

    private BillCrudRepository BillCrudRepository;

    public List<Bill> getAll(){
        return (List<Bill>) BillCrudRepository.findAll();
    }


    public Optional<Bill> getPetById(int id) {
        return BillCrudRepository.findById(id);
    }

    public Bill save(Bill bill) {
        return BillCrudRepository.save(bill);
    }

    public void delete(int id) {
        BillCrudRepository.deleteById(id);
    }
}


