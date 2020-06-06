package br.com.marcoscalicy.service;

import br.com.marcoscalicy.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public Person create(Person person) {
        //recebe e persiste na base

        return person;
    }

    public Person findById(String id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Marcos");
        person.setLastName("Silva");
        person.setAdrdess("Rua X 55555");
        person.setGenere("Male");
        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Silva "  + i);
        person.setAdrdess("Rua X 55555 - " + i);
        person.setGenere("Male");
        return person;

    }

    public Person update(Person person) {
        return person;
    }

    public void delete(String id) {

    }
}
