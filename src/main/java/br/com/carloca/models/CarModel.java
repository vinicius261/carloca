package br.com.carloca.models;

import javax.persistence.*;

@Entity
@Table(name = "car_models")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Brand brand;

    public CarModel(String name, Category category, Brand brand) {
        this.name = name;
        this.category = category;
        this.brand = brand;
    }

    public CarModel(){

    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public br.com.carloca.models.Brand getBrand() {
        return brand;
    }

    public void setBrand(br.com.carloca.models.Brand brand) {
        brand = brand;
    }
}
