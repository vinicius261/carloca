package br.com.carloca.models;

import javax.persistence.*;

@Entity
@Table(name = "complements")
public class Complement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String complement;

    public Complement(String complement){
        this.complement = complement;
    }

    public Complement(){}

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
