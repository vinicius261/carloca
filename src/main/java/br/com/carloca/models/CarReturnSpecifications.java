package br.com.carloca.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "return_specifications")
public class CarReturnSpecifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    @Column(name = "odometer_registration")
    private Double odometerRegistration;
    @ManyToOne
    private FranchiseUnit franchiseUnit;

    public CarReturnSpecifications(Date date, Double odometerRegistration, FranchiseUnit franchiseUnit) {
        this.date = date;
        this.odometerRegistration = odometerRegistration;
        this.franchiseUnit = franchiseUnit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getOdometerRegistration() {
        return odometerRegistration;
    }

    public void setOdometerRegistration(Double odometerRegistration) {
        this.odometerRegistration = odometerRegistration;
    }

    public FranchiseUnit getFranchiseUnit() {
        return franchiseUnit;
    }

    public void setFranchiseUnit(FranchiseUnit franchiseUnit) {
        this.franchiseUnit = franchiseUnit;
    }
}
