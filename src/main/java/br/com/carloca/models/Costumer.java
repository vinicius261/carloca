package br.com.carloca.models;

import javax.persistence.*;

@Entity
@Table(name = "costumers")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String document;
    private String name;
    @Column(name = "using_car")
    private boolean usingCar;
    @ManyToOne
    private Address address;

    public Costumer(String document, String name, Address address) {
        this.document = document;
        this.name = name;
        this.usingCar = false;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUsingCar() {
        return usingCar;
    }

    public void setUsingCar(boolean usingCar) {
        this.usingCar = usingCar;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address idAddress) {
        this.address = idAddress;
    }
}
