package com.petShop.web.controller;

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

tengo estas entipackage com.petShop.persistance.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name = "proveedores" )
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String contactLastName;

    @Column(name = "email")
    private String contactEmail;

    @Column(name = "telefono")
    private String contactPhoneNumber;

    @Column(name = "direccion")
    private String address;




} package com.petShop.persistance.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name = "citas" )
public class Quotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cita_id")
    private int id;

    @Column(name = "cliente_id")
    private String customerId   ;

    @Column(name = "fecha_cita")
    private String appointmentDate;


    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private  Owner Owner;

}
package com.petShop.persistance.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name = "producto" )
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "precio")
    private double price;

    @Column(name = "cantidad_stock")
    private int stockQuantity;


}
package com.petShop.persistance.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name = "mascota" )
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "especie")
    private String species;

    @Column(name = "edad")
    private String age;

    @Column(name = "genero")
    private String gender;

    @Column(name = "cliente_id")
    private int clientId;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private  Owner Owner;

}
package com.petShop.persistance.entity;

import jakarta.persistence.*;
        import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cliente" )
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int id;

    @Column(name = "nombres")
    private String name;

    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "correo")
    private  String email;

    @Column(name = "celular")
    private String celphoneNumbrer;

    @Column(name = "direccion")
    private String address;

    @OneToMany(mappedBy = "Owner")
    private List<Pet> pets;

    @OneToMany(mappedBy = "Owner")
    private List<Quotes> quotes;


}
package com.petShop.persistance.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name = "factura" )
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private int id;

    @Column(name = "cliente_id")
    private String customerId;

    @Column(name = "monto_total")
    private double totalAmount;

    // Getters and setters

}
y este crud package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Suppliers;
import org.springframework.data.repository.CrudRepository;

public interface SuppliersCrudRepository extends CrudRepository<Suppliers, Integer> {
}
package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Quotes;
import org.springframework.data.repository.CrudRepository;

public interface QuotesCrudRepository extends CrudRepository<Quotes, Integer> {
}
package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductsCrudRepository extends CrudRepository<Products, Integer> {
}
package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetCrudRepository extends CrudRepository<Pet, Integer> {

}
package com.petShop.persistance.crud;


import com.petShop.persistance.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerCrudRepository extends CrudRepository<Owner, Integer> {
}
package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillCrudRepository extends CrudRepository<Bill, Integer> {
} y este repository package com.petShop.persistance;

import com.petShop.persistance.crud.SuppliersCrudRepository;
import com.petShop.persistance.entity.Quotes;
import com.petShop.persistance.entity.Suppliers;

import java.util.List;
import java.util.Optional;

public class SuppliersRepository {

    SuppliersCrudRepository SuppliersCrudRepository;

    public List<Suppliers> getAll(){
        return (List<Suppliers>) SuppliersCrudRepository.findAll();
    }


    public Optional<Suppliers> getPetById(int id) {
        return SuppliersCrudRepository.findById(id);
    }

    public Suppliers save(Suppliers Suppliers) {
        return SuppliersCrudRepository.save(Suppliers);
    }

    public void delete(int id) {
        SuppliersCrudRepository.deleteById(id);
    }

}
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
package com.petShop.persistance;

import com.petShop.persistance.crud.ProductsCrudRepository;
import com.petShop.persistance.entity.Products;

import java.util.List;
import java.util.Optional;

public class ProductsRepository {

    ProductsCrudRepository ProductsCrudRepository;

    public List<Products> getAll(){
        return (List<Products>) ProductsCrudRepository.findAll();
    }


    public Optional<Products> getPetById(int id) {
        return ProductsCrudRepository.findById(id);
    }

    public Products save(Products products) {
        return ProductsCrudRepository.save(products);
    }

    public void delete(int id) {
        ProductsCrudRepository.deleteById(id);
    }
}
package com.petShop.persistance;

import com.petShop.persistance.crud.PetCrudRepository;
import com.petShop.persistance.entity.Pet;

import java.util.List;
import java.util.Optional;

public class PetRepository {
    private PetCrudRepository PetCrudRepository;

    public List<Pet> getAll(){
        return (List<Pet>) PetCrudRepository.findAll();
    }

    public Optional<Pet> getPetById(int id) {
        return PetCrudRepository.findById(id);
    }

    public Pet save(Pet pet) {
        return PetCrudRepository.save(pet);
    }

    public void delete(int id) {
        PetCrudRepository.deleteById(id);
    }


}
package com.petShop.persistance;

import com.petShop.persistance.crud.OwnerCrudRepository;
import com.petShop.persistance.entity.Owner;

import java.util.List;
import java.util.Optional;

public class OwnerRepository {
    private OwnerCrudRepository OwnerCrudRepository;

    public List<Owner> getAll(){
        return (List<Owner>) OwnerCrudRepository.findAll();
    }

    public Optional<Owner> getPetById(int id) {
        return OwnerCrudRepository.findById(id);
    }

    public Owner save(Owner owner) {
        return OwnerCrudRepository.save(owner);
    }

    public void delete(int id) {
        OwnerCrudRepository.deleteById(id);
    }
}
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



me puedes revisar este codigo como se encuentra y decirme si tiene un error y que e falta para poder terminar de crear una api y que se ejecute en postman, si falta codigo o falta algo dimero para copiar y pegar