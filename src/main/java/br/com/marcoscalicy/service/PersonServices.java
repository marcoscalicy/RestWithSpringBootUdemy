package br.com.marcoscalicy.service;

import br.com.marcoscalicy.exception.ExceptionOperadorNaoSuportado;
import br.com.marcoscalicy.model.Person;
import br.com.marcoscalicy.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public Person create(Person person) {
        return repository.save(person);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ExceptionOperadorNaoSuportado("Não encontrado o Id"));
    }

    public Person update(Person person) {
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ExceptionOperadorNaoSuportado("Não encontrado o Id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdrdess(person.getAdrdess());
        entity.setGenere(person.getGenere());
        return repository.save(entity);
    }

    public void delete(Long id) {
        Person entity = repository.findById(id).orElseThrow(() -> new ExceptionOperadorNaoSuportado("Não encontrado o Id"));
        repository.delete(entity);
    }
}
