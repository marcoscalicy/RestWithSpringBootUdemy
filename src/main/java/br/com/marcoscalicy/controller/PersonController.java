package br.com.marcoscalicy.controller;

import br.com.marcoscalicy.data.vo.v1.PersonVO;
import br.com.marcoscalicy.service.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

//@CrossOrigin
@Api(value = "Person Controller", tags  = "Person Endpoint")
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices services;

    @ApiOperation(value = "Busca por todas pessoas com texto específico" )
    @GetMapping( value = "/findPersonByName/{firstName}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<PersonVO> findPersonByName(@PathVariable("firstName") String firstName,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "12") int limit,
            @RequestParam(value = "direct", defaultValue = "asc") String direct){

        var sortDirection = "desc".equalsIgnoreCase(direct) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "firstName"));

        List<PersonVO> personsVO = services.findPersonByName(firstName, pageable);
        personsVO.stream()
                .forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return personsVO;
    }

    @ApiOperation(value = "Busca por todas pessoas" )
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<PersonVO> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "12") int limit,
            @RequestParam(value = "direct", defaultValue = "asc") String direct){

        var sortDirection = "desc".equalsIgnoreCase(direct) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "firstName"));

        List<PersonVO> personsVO = services.findAll(pageable);
        personsVO.stream()
                .forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return personsVO;
    }

    @ApiOperation(value = "Busca por ID específico" )
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO findById(@PathVariable("id") Long id){
        PersonVO personVO = services.findById(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }

    @ApiOperation(value = "Cria Pessoa" )
    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO createPerson(@RequestBody PersonVO person){
        PersonVO personVO = services.create(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());
        return personVO;
    }

    @ApiOperation(value = "Atualiza Pessoa" )
    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO updatePerson(@RequestBody PersonVO person){
        PersonVO personVO = services.update(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());
        return personVO;
    }

    @ApiOperation(value = "Deleta Pessoa" )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        services.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Desabilitando Person por ID específico" )
    @PatchMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO disablePerson(@PathVariable("id") Long id){
        PersonVO personVO = services.disabledPerson(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }

}
