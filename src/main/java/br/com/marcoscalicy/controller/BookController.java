package br.com.marcoscalicy.controller;

import br.com.marcoscalicy.data.vo.v1.BookVO;
import br.com.marcoscalicy.service.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(value = "Book Controller", tags  = "Book Endpoint")
@RestController
@RequestMapping("/api/book/v1")
public class BookController {

    @Autowired
    private BookServices service;

    @ApiOperation(value = "Busca todos Livros" )
    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public List<BookVO> findAll() {
        List<BookVO> books =  service.findAll();
        books
                .stream()
                .forEach(p -> p.add(
                        linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()
                        )
                );
        return books;
    }

    @ApiOperation(value = "Busca por livros específico por ID" )
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public BookVO findById(@PathVariable("id") Long id) {
        BookVO bookVO = service.findById(id);
        bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return bookVO;
    }

    @ApiOperation(value = "Cria novo Livro")
    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public BookVO create(@RequestBody BookVO book) {
        BookVO bookVO = service.create(book);
        bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
        return bookVO;
    }

    @ApiOperation(value = "Atualiza livros ")
    @PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public BookVO update(@RequestBody BookVO book) {
        BookVO bookVO = service.update(book);
        bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
        return bookVO;
    }

    @ApiOperation(value = "Deleta livro por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
