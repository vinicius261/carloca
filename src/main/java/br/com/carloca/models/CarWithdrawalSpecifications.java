package br.com.carloca.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "withdrawal_specifications")
public class CarWithdrawalSpecifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    @Column(name = "odometer_registration")
    private Integer odometerRegistration;
    @ManyToOne
    private FranchiseUnit franchiseUnit;

    public CarWithdrawalSpecifications(LocalDate date, Integer odometerRegistration, FranchiseUnit franchiseUnit) {
        this.date = date;
        this.odometerRegistration = odometerRegistration;
        this.franchiseUnit = franchiseUnit;
    }

    public CarWithdrawalSpecifications(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getOdometerRegistration() {
        return odometerRegistration;
    }

    public void setOdometerRegistration(Integer odometerRegistration) {
        this.odometerRegistration = odometerRegistration;
    }

    public FranchiseUnit getFranchiseUnit() {
        return franchiseUnit;
    }

    public void setFranchiseUnit(FranchiseUnit franchiseUnit) {
        this.franchiseUnit = franchiseUnit;
    }
}

