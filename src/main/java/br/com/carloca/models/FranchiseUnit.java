package br.com.carloca.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "franchise_units")
public class FranchiseUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    @ManyToOne
    private Address address;

    public FranchiseUnit(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public FranchiseUnit(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
