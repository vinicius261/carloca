package br.com.carloca.models;

import javax.persistence.*;

@Entity
@Table(name = "car_model")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Brand Brand;

    public CarModel(String name, Category category, Brand brand) {
        this.name = name;
        this.category = category;
        this.Brand = brand;
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
        return Brand;
    }

    public void setBrand(br.com.carloca.models.Brand brand) {
        Brand = brand;
    }
}