package br.com.marcoscalicy.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private static final long serialVersionUID = 4220834798812769593L;

    private Long id;
    private String firstName;
    private String lastName;
    private String adrdess;
    private String genere;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdrdess() {
        return adrdess;
    }

    public void setAdrdess(String adrdess) {
        this.adrdess = adrdess;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(adrdess, person.adrdess) &&
                Objects.equals(genere, person.genere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, adrdess, genere);
    }
}
