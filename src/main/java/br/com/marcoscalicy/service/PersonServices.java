package br.com.marcoscalicy.service;

import br.com.marcoscalicy.converter.DozerConverter;
import br.com.marcoscalicy.data.model.Person;
import br.com.marcoscalicy.data.vo.v1.PersonVO;
import br.com.marcoscalicy.exception.ExceptionOperadorNaoSuportado;
import br.com.marcoscalicy.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll(Pageable pageable) {
        var entities = repository.findAll(pageable).getContent();

        return DozerConverter.parseListObjects(entities, PersonVO.class);
    }

    public PersonVO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new ExceptionOperadorNaoSuportado("Não encontrado o Id"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        var entity = repository.findById(person.getKey()).orElseThrow(() -> new ExceptionOperadorNaoSuportado("Não encontrado o Id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGenere(person.getGenere());

        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    @Transactional
    public PersonVO disabledPerson(Long id){
        repository.disablePerson(id);
        var entity = repository.findById(id).orElseThrow(() -> new ExceptionOperadorNaoSuportado("Não encontrado o Id"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public void delete(Long id) {
        Person entity = repository.findById(id).orElseThrow(() -> new ExceptionOperadorNaoSuportado("Não encontrado o Id"));
        repository.delete(entity);
    }
}
