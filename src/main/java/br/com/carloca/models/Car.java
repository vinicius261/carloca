package br.com.carloca.models;

import br.com.carloca.enums.CarColors;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private CarVersion carVersion;
    @Column(name = "car_color")
    private CarColors carColor;
    @Column(name = "in_use")
    private boolean inUSe;
    private Integer odometer;

    public Car(String name, CarVersion carVersion, CarColors carColor, boolean inUSe, Integer odometer) {
        this.name = name;
        this.carVersion = carVersion;
        this.carColor = carColor;
        this.inUSe = inUSe;
        this.odometer = odometer;
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

    public CarVersion getCarVersion() {
        return carVersion;
    }

    public void setCarVersion(CarVersion carVersion) {
        this.carVersion = carVersion;
    }

    public CarColors getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColors carColor) {
        this.carColor = carColor;
    }

    public boolean isInUSe() {
        return inUSe;
    }

    public void setInUSe(boolean inUSe) {
        this.inUSe = inUSe;
    }

    public Integer getOdometer() {
        return odometer;
    }

    public void setOdometer(Integer odometer) {
        this.odometer = odometer;
    }
}
