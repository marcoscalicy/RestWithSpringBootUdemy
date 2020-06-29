package br.com.marcoscalicy.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

//@JsonPropertyOrder({"id","address", "firstName", "last_Name"})
public class PersonVO implements Serializable {

    private static final long serialVersionUID = 4220834798812769593L;

    private Long id;
    private String firstName;
    //@JsonProperty("last_Name")
    private String lastName;
    private String address;
    //@JsonIgnore
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
                Objects.equals(getAddress(), personVO.getAddress()) &&
                Objects.equals(getGenere(), personVO.getGenere());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGenere());
    }
}
