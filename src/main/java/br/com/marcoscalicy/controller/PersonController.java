package br.com.marcoscalicy.controller;

import br.com.marcoscalicy.model.Person;
import br.com.marcoscalicy.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @GetMapping
    public List<Person> findByAll(){
        return services.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id){
        return services.findById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return services.create(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person){
        return services.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteId(@PathVariable("id") Long id){
        services.delete(id);
        return ResponseEntity.ok().build();
    }

}
