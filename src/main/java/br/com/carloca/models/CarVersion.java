package br.com.carloca.models;

import javax.persistence.*;

@Entity
@Table(name = "car_version")
public class CarVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private CarModel carModel;
    private String motorization;
    @Column(name = "air_conditioning")
    private boolean airConditioning;
    @Column(name = "hydraulic_streering")
    private boolean hydraulicStreering;
    private boolean airbag;

    public CarVersion(String name, CarModel carModel, String motorization,
                      boolean airConditioning, boolean hydraulicStreering, boolean airbag) {
        this.name = name;
        this.carModel = carModel;
        this.motorization = motorization;
        this.airConditioning = airConditioning;
        this.hydraulicStreering = hydraulicStreering;
        this.airbag = airbag;
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

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public String getMotorization() {
        return motorization;
    }

    public void setMotorization(String motorization) {
        this.motorization = motorization;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isHydraulicStreering() {
        return hydraulicStreering;
    }

    public void setHydraulicStreering(boolean hydraulicStreering) {
        this.hydraulicStreering = hydraulicStreering;
    }

    public boolean isAirbag() {
        return airbag;
    }

    public void setAirbag(boolean airbag) {
        this.airbag = airbag;
    }
}
