package br.com.marcoscalicy.controller;

import br.com.marcoscalicy.data.vo.PersonVO;
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
    public List<PersonVO> findByAll(){
        return services.findAll();
    }

    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable("id") Long id){
        return services.findById(id);
    }

    @PostMapping
    public PersonVO createPerson(@RequestBody PersonVO person){
        return services.create(person);
    }

    @PutMapping
    public PersonVO updatePerson(@RequestBody PersonVO person){
        return services.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteId(@PathVariable("id") Long id){
        services.delete(id);
        return ResponseEntity.ok().build();
    }

}
