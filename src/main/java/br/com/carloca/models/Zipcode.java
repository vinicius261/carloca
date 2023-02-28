package br.com.carloca.models;

import javax.persistence.*;

@Entity
@Table(name = "zipcodes")
public class Zipcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String zipcode;

    public Zipcode(String zipcode){
        this.zipcode = zipcode;
    }

    public Zipcode(){}

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
