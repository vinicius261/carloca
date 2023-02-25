package br.com.carloca.models;

import javax.persistence.*;

@Entity
@Table(name = "zipcode")
public class Zipcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
