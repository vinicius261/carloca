package br.com.carloca.models;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Zipcode zipcode;
    @ManyToOne
    private Street street;
    @ManyToOne
    private Complement complement;

    public Address(Zipcode zipcode, Street street, Complement complement) {
        this.zipcode = zipcode;
        this.street = street;
        this.complement = complement;
    }

    public Address(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zipcode getZipcode() {
        return zipcode;
    }

    public void setZipcode(Zipcode zipcode) {
        this.zipcode = zipcode;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Complement getComplement() {
        return complement;
    }

    public void setComplement(Complement complement) {
        this.complement = complement;
    }
}
