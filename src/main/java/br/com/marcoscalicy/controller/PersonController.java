package br.com.marcoscalicy.controller;

import br.com.marcoscalicy.model.Person;
import br.com.marcoscalicy.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findByAll(){
        return service.findAll();
    }

    @RequestMapping(value="/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id){
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody Person person){
        return service.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person updatePerson(@RequestBody Person person){
        return service.update(person);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteId(@PathVariable("id") String id){
        service.delete(id);
    }



}
