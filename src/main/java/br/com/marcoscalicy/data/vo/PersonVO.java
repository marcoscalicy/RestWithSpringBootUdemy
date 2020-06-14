package br.com.marcoscalicy.data.vo;

import java.io.Serializable;
import java.util.Objects;

public class PersonVO implements Serializable {

    private static final long serialVersionUID = 4220834798812769593L;

    private Long id;
    private String firstName;
    private String lastName;
    private String adrdess;
    private String genere;

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
        if (!(o instanceof PersonVO)) return false;
        PersonVO personVO = (PersonVO) o;
        return Objects.equals(getId(), personVO.getId()) &&
                Objects.equals(getFirstName(), personVO.getFirstName()) &&
                Objects.equals(getLastName(), personVO.getLastName()) &&
                Objects.equals(getAdrdess(), personVO.getAdrdess()) &&
                Objects.equals(getGenere(), personVO.getGenere());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAdrdess(), getGenere());
    }
}
