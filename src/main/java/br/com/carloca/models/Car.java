package br.com.carloca.models;

import br.com.carloca.enums.CarColors;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "license_plate")
    private String licensePlate;
    @ManyToOne
    private CarVersion carVersion;
    @Column(name = "car_color")
    private CarColors carColor;
    @Column(name = "in_use")
    private boolean inUSe;
    private Integer odometer;

    public Car(String licensePlate, CarVersion carVersion, CarColors carColor, boolean inUSe, Integer odometer) {
        this.licensePlate = licensePlate;
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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
